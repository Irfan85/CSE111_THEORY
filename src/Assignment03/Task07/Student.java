package Assignment03.Task07;

public class Student {
    public static int numberOfStudents = 0;
    private String name;

    public Student(){
        this.name = "Default Student";
        numberOfStudents++;
    }

    public Student(String name){
        this.name = name;
        numberOfStudents++;
    }

    public String getName() {
        return name;
    }
}
