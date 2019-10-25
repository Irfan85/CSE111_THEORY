package Assignment04;

import java.util.ArrayList;

public class University {
    private String name;
    private boolean hasCampus = false;
    private ArrayList<Student> students = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public University(String name, boolean hasCampus) {
        this.name = name;
        this.hasCampus = hasCampus;
    }

    public void add(Student student){
        if(hasCampus){
            student.isNsu = true;
            student.university = "nsu";
        }else{
            student.isNsu = false;
            student.university = "brac";
        }
        students.add(student);
    }

    public int totalStudents(){
        return students.size();
    }

    public boolean needCampus(){
        return !hasCampus;
    }

    public String toString() {
        return "University{" +
                "name='" + name + "\'" +
                ", hasCampus=" + hasCampus +
                "}";
    }
}
