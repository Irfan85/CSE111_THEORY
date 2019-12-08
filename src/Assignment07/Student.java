package Assignment07;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Student {
    private static int numberOfStudents = 0;
    private String name;
    private String id;
    private String department;
    private double cgpa;
    private ArrayList<Course> currentCourses;
    private HashMap<Course, Double> completedCourses;
    private int credits;

    public Student() {
        this.name = "Default Student";
        this.id = "0000000" + (numberOfStudents++);
        this.department = "No Department";
        this.cgpa = 0.0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
        this.credits = 0;
    }

    public Student(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.cgpa = 0.0;
        this.credits = 0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
    }

    public Student(String name, String id, String department, double cgpa, int credits) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.cgpa = cgpa;
        this.credits = credits;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
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

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    public HashMap<Course, Double> getCompletedCourses() {
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
            for (Course course : this.currentCourses) {
                output = output.concat(course.getCourseName() + "\n");
            }
        }

        output = output.concat("Completed Courses: " + "\n");

        if (this.completedCourses.size() == 0) {
            output = output.concat("None" + "\n");
        } else {
            for (Course course : this.completedCourses.keySet()) {
                output = output.concat(course.getCourseName() + "\n");
            }
        }

        return output;
    }
}
