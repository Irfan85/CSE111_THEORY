package Assignment07And08;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!isExistingStudent(student)) {
            students.add(student);
        } else {
            System.out.println("Student with ID: " + student.getId() + " already exists.");
        }
    }

    public void removeStudent(Student student) {
        if (student != null) {
            if (isExistingStudent(student)) {
                students.remove(student);

                // Remove student with each and every section he/she's assigned with
                for (Course course : student.getCurrentCourses()) {
                    course.getSection(course.getSectionOfStudent(student)).removeStudent(student);
                }

                student.getCurrentCourses().clear();
            } else {
                System.out.println("Student with ID: " + student.getId() + " not found.");
            }
        } else {
            System.out.println("Student does not exist.");
        }
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        return null;
    }

    public void assignCourse(Student student, Course course) {
        if (isExistingStudent(student)) {
            if (course.isRegistered(student)) {
                student.getCompletedCourses().remove(course);

                course.getSection(course.getSectionOfStudent(student)).removeStudent(student);
            }

            if (!student.getCurrentCourses().contains(course)) {
                Section section;
                if (course.getSectionNumber() == 0) {
                    section = course.createNewSection();
                } else {
                    section = course.getSection(course.getSectionNumber());
                    if (section.numberOfRegisteredStudents() == section.getPreferredStudentLimit()) {
                        section = course.createNewSection();
                    }
                }

                student.getCurrentCourses().add(course);
                section.registerStudent(student);
            } else {
                System.out.println("Student with ID: " + student.getId() + " is already assigned with this course.");
            }
        } else {
            System.out.println("Student with ID: " + student.getId() + " does not exist");
        }
    }

    public void finishCourse(Student student, Course course, double cgpa) {
        if (dropCourse(student, course)) {
            student.getCompletedCourses().put(course, cgpa);

            updateCredits(student, student.getCredits() + 3);

            int completed = student.getCompletedCourses().size();
            int x = 1;
            if (completed == 1) {
                x = 0;
            }

            double newCGPA = (1.0 * ((completed - x) * student.getCgpa()) + cgpa) / completed;
            updateCGPA(student, newCGPA);
        }
    }

    public boolean dropCourse(Student student, Course course) {
        if (isExistingStudent(student)) {
            if (course.isRegistered(student)) {
                student.getCurrentCourses().remove(course);
                course.getSection(course.getSectionOfStudent(student)).removeStudent(student);
                return true;
            } else {
                System.out.println("Student with ID: " + student.getId() + " has not taken " + course.getCourseName() + " yet.");
                return false;
            }
        } else {
            System.out.println("Student with ID: " + student.getId() + " does not exist");
            return false;
        }
    }

    public void updateCredits(Student student, int credits) {
        if (isExistingStudent(student)) {
            student.setCredits(credits);
        } else {
            System.out.println("Student with ID: " + student.getId() + " does not exist");
        }
    }

    public void updateCGPA(Student student, double cgpa) {
        if (isExistingStudent(student)) {
            student.setCgpa(cgpa);
        } else {
            System.out.println("Student with ID: " + student.getId() + " does not exist");
        }
    }

    public boolean isExistingStudent(Student student) {
        boolean studentStatus = false;
        for (Student st : students) {
            if (st.getId().equals(student.getId())) {
                studentStatus = true;
                break;
            }
        }
        return studentStatus;
    }

    public ArrayList<Student> getStudentList() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(String courseName) {
        if (isExistingCourse(courseName) == null) {
            courses.add(new Course(courseName));
        } else {
            System.err.println(courseName + " course already exists");
        }
    }


    public Course isExistingCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "\n";

        if (this.students.size() != 0) {
            for (Student student : this.students) {
                output = output.concat(student.toString() + "\n");
            }
        } else {
            output = output.concat("It's very lonely here. No Students. :'(" + "\n");
        }

        return output;
    }
}
