package Assignment07And08;

public class MNSStudent extends Student {
//    public MNSStudent() {
//        super();
//        super.setName("Default MNS Student");
//        super.setDepartment("MNS");
//    }

    public MNSStudent(String name, String id) {
        super(name, id, "MNS");
    }

    public MNSStudent(String name, String id, double cgpa, int credits) {
        super(name, id, "MNS", cgpa, credits);
    }
}
