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
        student.university = this.name;

        if(hasCampus){
            student.isNsu = true;
        }else{
            student.isNsu = false;
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
