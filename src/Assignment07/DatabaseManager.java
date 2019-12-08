package Assignment07;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class DatabaseManager {
    private final String STUDENT_DATABASE_FILE_NAME = "student_database.txt";
    private final String COURSE_DATABASE_FILE_NAME = "course_database.txt";
    private final String STUDENT_PROGRESS_DATABASE_FILE_NAME = "student_progress_database.txt";

    private File studentDatabase;
    private File courseDatabase;
    private File studentProgressDatabase;
    private StudentManager studentManager;

    public DatabaseManager(StudentManager studentManager) {
        this.studentManager = studentManager;
        studentDatabase = new File(STUDENT_DATABASE_FILE_NAME);
        courseDatabase = new File(COURSE_DATABASE_FILE_NAME);
        studentProgressDatabase = new File(STUDENT_PROGRESS_DATABASE_FILE_NAME);
    }

    public void populateData() {
        try {
            // Populate students
            Scanner studentScanner = new Scanner(studentDatabase);
            while (studentScanner.hasNext()) {
                String line = studentScanner.nextLine();
                if (!line.equals("") && !line.startsWith("#")) {
                    StringTokenizer tk = new StringTokenizer(line, " ");

                    String department = tk.nextToken();
                    String id = tk.nextToken();
                    String name = tk.nextToken();
                    double cgpa = Double.parseDouble(tk.nextToken());
                    int credits = Integer.parseInt(tk.nextToken());

                    //System.out.println(department + "\t" + id + "\t" + name + "\t" + cgpa + "\t" + credits);

                    switch (department) {
                        case "CSE":
                            studentManager.addStudent(new CSEStudent(name, id, cgpa, credits));
                            break;
                        case "BBA":
                            studentManager.addStudent(new MNSStudent(name, id, cgpa, credits));
                            break;
                        case "MNS":
                            studentManager.addStudent(new BBAStudent(name, id, cgpa, credits));
                            break;
                    }
                }
            }


            // Populate Courses and Sections
            Scanner courseScanner = new Scanner(courseDatabase);
            while (courseScanner.hasNext()) {
                String line = courseScanner.nextLine();
                if (!line.equals("") && !line.startsWith("#")) {
                    StringTokenizer st = new StringTokenizer(line, " ");

                    String courseName = st.nextToken();
                    st.nextToken(); // Skipping section number

                    Course course = studentManager.isExistingCourse(courseName);
                    if (course == null) {
                        studentManager.addCourse(courseName);
                        course = studentManager.isExistingCourse(courseName);
                    }

                    course.createNewSection();

                    while (st.hasMoreTokens()) {
                        String studentId = st.nextToken();
                        studentManager.assignCourse(studentManager.getStudentById(studentId), course);
                    }

                }
            }

            // Populate Student Progress
            Scanner studentProgressScanner = new Scanner(studentProgressDatabase);
            while (studentProgressScanner.hasNext()) {
                String line = studentProgressScanner.nextLine();
                if (!line.equals("") && !line.startsWith("#")) {
                    StringTokenizer st = new StringTokenizer(line, " ");

                    String id = st.nextToken();

                    while (st.hasMoreTokens()) {
                        String courseName = st.nextToken();
                        double cgpa = Double.parseDouble(st.nextToken());
                        Student student = studentManager.getStudentById(id);
                        Course course = studentManager.isExistingCourse(courseName);
                        if (student != null && course != null) {
                            student.getCompletedCourses().put(course, cgpa);
                        } else {
                            System.err.println("Database is corrupted.");
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (NoSuchElementException e) {
            System.err.println("Database is corrupted.");
        } catch (NumberFormatException e){
            System.err.println("Wrong number format.");
        }
    }

    public void writeData() {
        // Writing student data
        for (Student student : studentManager.getStudentList()) {
            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter(studentDatabase, true));
                String line = student.getDepartment() + " " + student.getId() + " " + student.getName() + " " + student.getCgpa() + " " + student.getCredits() + "\n";
                bf.write(line);
                bf.flush();
                bf.close();

                // Writing student progress data
                BufferedWriter bf2 = new BufferedWriter(new FileWriter(studentProgressDatabase, true));
                String spdLine = student.getId();
                for (Course course : student.getCompletedCourses().keySet()) {
                    spdLine = spdLine.concat(" " + course.getCourseName() + " " + student.getCompletedCourses().get(course));
                }
                bf2.write(spdLine + "\n");
                bf2.flush();
                bf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Writing course data
        String line = "";
        for (Course course : studentManager.getCourses()) {
            for (Section section : course.getSections()) {
                //System.out.println(studentManager.getCourses());
                line = line.concat(course.getCourseName().trim() + " " + section.getSectionID());
                for (Student student : section.getStudents()) {
                    line = line.concat(" " + student.getId());
                }
                line = line.concat("\n");
            }
        }

        try {
            BufferedWriter bf3 = new BufferedWriter(new FileWriter(courseDatabase, true));
            bf3.write(line);
            bf3.flush();
            bf3.close();
        } catch (IOException e) {
            System.err.println("An error occurred.");
        }
    }

    public void clearDatabase() {
        try {
            FileOutputStream fileOutputStream1 = new FileOutputStream(studentDatabase);
            FileOutputStream fileOutputStream2 = new FileOutputStream(courseDatabase);
            FileOutputStream fileOutputStream3 = new FileOutputStream(studentProgressDatabase);

            fileOutputStream1.write("".getBytes());
            fileOutputStream2.write("".getBytes());
            fileOutputStream3.write("".getBytes());

            fileOutputStream1.flush();
            fileOutputStream2.flush();
            fileOutputStream3.flush();

            fileOutputStream1.close();
            fileOutputStream2.close();
            fileOutputStream3.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("An error occurred");
        }
    }
}
