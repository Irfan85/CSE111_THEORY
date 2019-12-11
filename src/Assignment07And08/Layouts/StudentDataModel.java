package Assignment07And08.Layouts;

import Assignment07And08.Student;
import Assignment07And08.StudentManager;

import javax.swing.table.AbstractTableModel;

public class StudentDataModel extends AbstractTableModel {
    private final String[] HEADINGS = {"ID", "Name", "Department", "CGPA", "Credits", "Current Courses", "Completed Courses"};
    private StudentManager studentManager;

    public StudentDataModel(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    public String getColumnName(int column) {
        return HEADINGS[column];
    }

    @Override
    public int getRowCount() {
        return studentManager.getStudentList().size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = studentManager.getStudentList().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getDepartment();
            case 3:
                return student.getCgpa();
            case 4:
                return student.getCredits();
            case 5:
                return student.getCurrentCourses().size();
            case 6:
                return student.getCompletedCourses().size();
        }

        return "";
    }
}
