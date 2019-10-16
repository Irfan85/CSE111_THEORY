package Assignment03.Task08;

public class Teacher {
    private String name, department;
    private Course[] courses = new Course[100];

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void printDetail(){
        System.out.println("========================");
        System.out.println("Name = " + getName());
        System.out.println("Department = " + getDepartment());
        System.out.println("List of courses");
        System.out.println("========================");
        for(int i = 0; i < courses.length; i++){
            if(courses[i] != null){
                System.out.println(courses[i].getCourseName());
            }
        }
        System.out.println("========================");
    }

    public void addCourse(Course course){
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == null){
                courses[i] = course;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Course[] getCourses(){
        return courses;
    }

}
