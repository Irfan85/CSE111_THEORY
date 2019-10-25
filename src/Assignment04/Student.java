package Assignment04;

import java.util.ArrayList;

public class Student {
    private static int numberOfStudents = 0;
    private String name, typeOfStudent;
    public String university;
    private int ID;
    public boolean isNsu = false;
    public ArrayList<Course> course = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        this.typeOfStudent = "Regular Student";
        ID = numberOfStudents;
        numberOfStudents++;
    }

    public Student(String name, String typeOfStudent) {
        this.name = name;
        this.typeOfStudent = typeOfStudent;
        ID = numberOfStudents;
        numberOfStudents++;
    }

    public void addCourse(Course c1, Course c2, Course c3){
        course.add(c1);
        course.add(c2);
        course.add(c3);
    }

    public void addCourse(Course c1, Course c2, Course c3, Course c4){
        course.add(c1);
        course.add(c2);
        course.add(c3);
        course.add(c4);
    }

    public boolean isNSU(){
        return !isNsu;
    }

    public boolean isPreUni(){
        if (this.typeOfStudent.equals("Pre-Uni")){
            return true;
        }else{
            return false;
        }
    }

    public void completePreUni(){
        this.typeOfStudent = "Regular Student";
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        String output = "Name: " + name + "\n" + "ID: " + ID + "\n" + typeOfStudent + "\n" + "University: " + university + "\n";
        output = output.concat("List of Courses:");

        for(Course c : course){
            output = output.concat(" " + c.name + " ");
        }

        output = output.concat("\n");

        return output;
    }
}
