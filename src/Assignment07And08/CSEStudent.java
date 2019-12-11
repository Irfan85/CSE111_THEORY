package Assignment07And08;

public class CSEStudent extends Student {
//    public CSEStudent() {
//        super();
//        super.setName("Default CSE Student");
//        super.setDepartment("CSE");
//    }

    public CSEStudent(String name, String id) {
        super(name, id, "CSE");
    }

    public CSEStudent(String name, String id, double cgpa, int credits) {
        super(name, id, "CSE", cgpa, credits);
    }
}
