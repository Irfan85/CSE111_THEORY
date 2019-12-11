package Assignment07And08;

public class BBAStudent extends Student {
//    public BBAStudent() {
//        super();
//        super.setName("Default BBA Student");
//        super.setDepartment("BBA");
//    }

    public BBAStudent(String name, String id) {
        super(name, id, "BBA");
    }

    public BBAStudent(String name, String id, double cgpa, int credits) {
        super(name, id, "BBA", cgpa, credits);
    }
}
