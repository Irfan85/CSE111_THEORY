package Assignment06;

import java.util.ArrayList;

public class Student {
    private static int numberOfStudents = 0;
    private String name;
    private String id;
    private String department;
    private double cgpa;
    private ArrayList<String> currentCourses;
    private ArrayList<String> completedCourses;
    private int credits;

    public Student() {
        this.name = "Default Student";
        this.id = "0000000" + (numberOfStudents++);
        this.department = "No Department";
        this.cgpa = 0.0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.credits = 0;
    }

    public Student(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.cgpa = 0.0;
        this.credits = 0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
    }

    public Student(String name, String id, String department, double cgpa, int credits) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.cgpa = cgpa;
        this.credits = credits;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
    }

    public void assignCourse(String courseName) {
        if (!getCurrentCourses().contains(courseName)) {
            getCurrentCourses().add(courseName);
        } else {
            System.out.println(this.getId() + " is already assigned with this course.");
        }
    }

    public void finishCourse(String courseName) {
        if (getCurrentCourses().contains(courseName)) {
            getCompletedCourses().add(courseName);
            getCurrentCourses().remove(courseName);
        }else{
            System.out.println(this.getId() + " hasn't taken or already completed this course yet.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<String> getCurrentCourses() {
        return currentCourses;
    }

    public ArrayList<String> getCompletedCourses() {
        return completedCourses;
    }

    @Override
    public String toString() {
        String output = "Name: " + this.getName() + "\n" +
                "ID: " + this.getId() + "\n" +
                "Department: " + this.getDepartment() + "\n" +
                "Credits: " + this.getCredits() + "\n" +
                "CGPA: " + this.getCgpa() + "\n" +
                "Current Courses: " + "\n";

        if (this.currentCourses.size() == 0) {
            output = output.concat("None" + "\n");
        } else {
            for (String course : this.currentCourses) {
                output = output.concat(course + "\n");
            }
        }

        output = output.concat("Completed Courses: " + "\n");

        if (this.completedCourses.size() == 0) {
            output = output.concat("None" + "\n");
        } else {
            for (String course : this.completedCourses) {
                output = output.concat(course + "\n");
            }
        }

        return output;
    }
}
