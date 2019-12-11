package Assignment07And08;

import java.util.ArrayList;

public class Section {
    private int sectionID;
    private int preferredStudentLimit = 40;
    //private int maxStudentLimit = 45;
    private ArrayList<Student> students;

    public Section(int sectionID) {
        students = new ArrayList<>();
        this.sectionID = sectionID;
    }

//    public Section(int sectionID, int preferredStudentLimit, int maxStudentLimit) {
//        this.preferredStudentLimit = preferredStudentLimit;
//        this.maxStudentLimit = maxStudentLimit;
//        students = new ArrayList<>();
//        this.sectionID = sectionID;
//    }

    public void registerStudent(Student student) {
        if (numberOfRegisteredStudents() <= preferredStudentLimit) {
            students.add(student);
        } else {
            System.out.println("Preferred student limit exceeded.");
        }
    }

    public void removeStudent(Student student) {
        if (isRegistered(student)) {
            students.remove(student);
        } else {
            System.out.println(student.getId() + " is not registered in Section: " + this.sectionID);
        }
    }

    public boolean isRegistered(Student student) {
        for (Student st : students) {
            if (st.getId().equals(student.getId())) {
                return true;
            }
        }
        return false;
    }

    public int numberOfRegisteredStudents() {
        return students.size();
    }

    public int getSectionID() {
        return sectionID;
    }

    public int getPreferredStudentLimit() {
        return preferredStudentLimit;
    }

//    public void setPreferredStudentLimit(int preferredStudentLimit) {
//        this.preferredStudentLimit = preferredStudentLimit;
//    }
//
//    public int getMaxStudentLimit() {
//        return maxStudentLimit;
//    }
//
//    public void setMaxStudentLimit(int maxStudentLimit) {
//        this.maxStudentLimit = maxStudentLimit;
//    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {

        return "Section: " + this.sectionID + "\n" +
                "Students Registered: " + this.numberOfRegisteredStudents() + "/" + this.getPreferredStudentLimit();
    }
}
