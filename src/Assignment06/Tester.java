package Assignment06;

import java.util.ArrayList;

public class Tester {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        BBAStudent bs01 = new BBAStudent("Akkas Ali Khan", "19103001");
        BBAStudent bs02 = new BBAStudent();

        CSEStudent cs01 = new CSEStudent("Mister Abul", "19101080");
        CSEStudent cs02 = new CSEStudent();

        MNSStudent ms01 = new MNSStudent("Class Er Mota Cheleta", "19104277");
        MNSStudent ms02 = new MNSStudent();

        addStudent(bs01);
        addStudent(bs02);
        addStudent(cs01);
        addStudent(cs02);
        addStudent(ms01);
        addStudent(ms02);

        bs01.assignCourse("BUS101");
        bs01.assignCourse("BUS201");
        bs01.assignCourse("STA201");

        bs01.finishCourse("BUS101");
        bs01.finishCourse("BUS101");

        cs01.assignCourse("CSE110");
        cs01.assignCourse("CSE111");
        cs01.assignCourse("CSE230");
        cs01.assignCourse("CSE260");

        cs01.finishCourse("CSE110");
        cs01.assignCourse("CSE111");

        removeStudent(bs02);

        System.out.println();
        for(Student student : students){
            System.out.println(student);
        }


    }

    private static void addStudent(Student student) {
        students.add(student);
    }

    private static void removeStudent(Student student) {
        students.remove(student);
    }
}
