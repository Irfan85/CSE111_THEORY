package Assignment07And08;

import Assignment07And08.Layouts.BottomBar;
import Assignment07And08.Layouts.MainFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static StudentManager studentManager = new StudentManager();
    private static DatabaseManager dbm = new DatabaseManager(studentManager);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How do you want to interact?");
        System.out.println("Press '1' for opening up Graphical User Interface\nPress '2' for Commandline interaction");
        try {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    boolean success = dbm.populateData();
                    if (success) {
                        BottomBar bottomBar = new BottomBar(dbm);
                        new MainFrame("Assignment 07 GUI", studentManager, bottomBar);
                    } else {
                        System.err.println("Problem occurred while loading database.");
                    }
                    break;
                case 2:
                    initialize();
                    saveData();
                    break;
                default:
                    System.err.println("Invalid input.\nClosing app.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Wrong input");
        }
    }

    public static void saveData() {
        dbm.clearDatabase();
        dbm.writeData();
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Input Method:\n" + "'1' Load previously saved data from database.\n"
                + "'2' Reset database and start from scratch.");
        try {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    boolean success = dbm.populateData();
                    if (success) {
                        takeInput(sc);
                    } else {
                        System.err.println("Problem occurred while loading database.");
                    }
                    break;
                case 2:
                    takeInput(sc);
                    break;
                default:
                    System.err.println("Wrong input!");
                    initialize();
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Wrong input");
            initialize();
        }
    }

    private static void takeInput(Scanner sc) {
        System.out.println("What do you want to do?\n"
                + "'1' for adding a Student\n"
                + "'2' for removing a Student\n"
                + "'3' for modifying a Student's info\n"
                + "'4' for creating new Course\n"
                + "'5' for showing info of a student\n"
                + "'6' for showing course info\n"
                + "'0' for exit.");
        try {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    removeStudent(sc);
                    break;
                case 3:
                    modifyStudent(sc);
                    break;
                case 4:
                    createCourse(sc);
                    break;
                case 5:
                    showStudentInfo(sc);
                    break;
                case 6:
                    showCourseInfo(sc);
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Wrong input. Try again.");
                    takeInput(sc);
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Try again.");
            takeInput(new Scanner(System.in));
        }
    }

    private static void addStudent(Scanner sc) {
        try {
            System.out.println("'1' for manual input\n'2' for automated bulk input form input.txt file.");
            int input = sc.nextInt();
            sc.nextLine();
            if (input == 2) {
                automatedInput();
            } else if (input == 1) {

                System.out.println("----------Enter the details of the Student----------\n"
                        + "'1' for CSE Student.\n"
                        + "'2' for BBA Student.\n"
                        + "'3' for MNS Student.");

                int type = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");

                String name = sc.nextLine();

                System.out.print("ID: ");

                String id = sc.nextLine();

                System.out.println(type + " " + name + " " + id);
                switch (type) {
                    case 1:
                        studentManager.addStudent(new CSEStudent(name, id));
                        break;
                    case 2:
                        studentManager.addStudent(new BBAStudent(name, id));
                        break;
                    case 3:
                        studentManager.addStudent(new MNSStudent(name, id));
                        break;
                    default:
                        System.err.println("Unidentified type of student : " + type);
                        break;
                }

                //System.out.println("CALLING TAKE INPUT");
            } else {
                System.err.println("Wrong input.");
            }
            takeInput(sc);
        } catch (NoSuchElementException e) {
            System.err.println("Wrong input");
            takeInput(sc);
        }
    }

    public static void automatedInput() {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (!line.startsWith("#") && !line.equals("")) {
                    StringTokenizer tokenizer = new StringTokenizer(line, " ");

                    String department = tokenizer.nextToken();
                    String id = tokenizer.nextToken();
                    String name = tokenizer.nextToken();

                    if (!department.equals("") && !name.equals("") && !id.equals("")) {
                        switch (department) {
                            case "CSE":
                                studentManager.addStudent(new CSEStudent(name, id));
                                break;
                            case "BBA":
                                studentManager.addStudent(new BBAStudent(name, id));
                                break;
                            case "MNS":
                                studentManager.addStudent(new MNSStudent(name, id));
                                break;
                            default:
                                System.out.println();
                                break;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("input.txt not found");
        } catch (NoSuchElementException e) {
            System.err.println("input.txt is corrupted");
        }
    }

    private static void removeStudent(Scanner sc) {
        try {
            System.out.print("Enter the id of the Student you want to get rid of: ");

            sc.nextLine();
            String id = sc.nextLine();
            System.out.println(id);

            studentManager.removeStudent(studentManager.getStudentById(id));

            takeInput(sc);
        } catch (NoSuchElementException e) {
            System.err.println("Wrong input");
            takeInput(new Scanner(System.in));
        }
    }

    private static void modifyStudent(Scanner sc) {
        try {
            System.out.print("Enter the id of the Student you want modify: ");

            sc.nextLine();
            String id = sc.nextLine();

            System.out.println("----------Select the type of modification----------\n"
                    + "'1' for assigning course\n"
                    + "'2' for completing course\n"
                    + "'3' for dropping course.");

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    assignCourse(sc, studentManager.getStudentById(id));
                    break;
                case 2:
                    completeCourse(sc, studentManager.getStudentById(id));
                    break;
                case 3:
                    removeCourse(sc, studentManager.getStudentById(id));
                    break;
                default:
                    System.err.println("Wrong input");
                    takeInput(sc);
                    break;
            }

        } catch (NoSuchElementException e) {
            System.err.println("Wrong input");
            takeInput(sc);
        }
    }

    private static void assignCourse(Scanner sc, Student student) throws NoSuchElementException {
        if (student != null) {
            System.out.println("'1' for assigning a course to " + student.getId() + "\n"
                    + "'2' for stop assigning course.");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Enter Course Name: ");

                    Course course = studentManager.isExistingCourse(sc.nextLine());
                    if (course != null) {
                        studentManager.assignCourse(student, course);
                    } else {
                        System.err.println("Course not found");
                    }
                    assignCourse(sc, student);
                    break;
                case 2:
                    takeInput(sc);
                    break;
                default:
                    System.err.println("Wrong input");
                    takeInput(sc);
                    break;
            }
        } else {
            System.err.println("Student not found.");
            takeInput(sc);
        }
    }

    private static void completeCourse(Scanner sc, Student student) throws NoSuchElementException {
        if (student != null) {
            System.out.println("'1' for completing a course for " + student.getId() + "\n"
                    + "'2' for stop completing course.");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Enter Course Name: ");
                    String courseName = sc.nextLine();

                    Course course = studentManager.isExistingCourse(courseName);

                    System.out.print("Enter cgpa of this course: ");
                    double cgpa = sc.nextDouble();
                    sc.nextLine();

                    if (course != null) {
                        studentManager.finishCourse(student, course, cgpa);
                    } else {
                        System.err.println("Course not found");
                    }
                    completeCourse(sc, student);
                    break;
                case 2:
                    takeInput(sc);
                    break;
                default:
                    System.err.println("Wrong input");
                    takeInput(sc);
                    break;
            }
        } else {
            System.err.println("Student not found.");
            takeInput(sc);
        }
    }

    private static void removeCourse(Scanner sc, Student student) throws NoSuchElementException {
        if (student != null) {
            System.out.println("'1' for removing a course from " + student.getId() + "\n"
                    + "'2' for stop removing course.");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Enter Course Name: ");

                    Course course = studentManager.isExistingCourse(sc.nextLine());
                    if (course != null) {
                        studentManager.dropCourse(student, course);
                    } else {
                        System.err.println("Course not found");
                    }
                    removeCourse(sc, student);
                    break;
                case 2:
                    takeInput(sc);
                    break;
                default:
                    System.err.println("Wrong input");
                    takeInput(sc);
                    break;
            }
        } else {
            System.err.println("Student not found.");
        }
    }

    private static void createCourse(Scanner sc) {
        try {
            System.out.println("----------Enter the details of the Course----------");
            System.out.print("Course Name: ");
            sc.nextLine();
            String courseName = sc.nextLine();

            System.out.println("Creating Course: " + courseName);
            studentManager.addCourse(courseName);

            takeInput(sc);
        } catch (NoSuchElementException e) {
            System.err.println("Wrong input");
            takeInput(sc);
        }
    }

    public static void showStudentInfo(Scanner sc) {
        System.out.print("Enter the id of the student who's info you want to see:");
        sc.nextLine();
        String id = sc.nextLine();

        Student student = studentManager.getStudentById(id);
        if (student != null) {
            System.out.println(student.toString());
        } else {
            System.err.println("Student not found");
        }
        takeInput(sc);
    }

    public static void showCourseInfo(Scanner sc) {
        System.out.print("Enter the name of the Course:");
        sc.nextLine();
        String courseName = sc.nextLine();

        Course course = studentManager.isExistingCourse(courseName);
        if (course != null) {
            System.out.println(course.toString());
        } else {
            System.err.println("Course not found");
        }
        takeInput(sc);
    }
}
