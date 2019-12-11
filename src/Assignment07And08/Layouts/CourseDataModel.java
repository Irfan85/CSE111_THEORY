package Assignment07And08.Layouts;

import Assignment07And08.Course;
import Assignment07And08.Section;
import Assignment07And08.Student;
import Assignment07And08.StudentManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CourseDataModel extends AbstractTableModel {
    private StudentManager studentManager;

    public CourseDataModel(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    public String getColumnName(int column) {
        return studentManager.getCourses().get(column).getCourseName();
    }

    @Override
    public int getRowCount() {
        return studentManager.getStudentList().size();
    }

    @Override
    public int getColumnCount() {
        return studentManager.getCourses().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = studentManager.getCourses().get(columnIndex);

        ArrayList<Student> allRegisteredStudents = new ArrayList<>();
        for (Section section : course.getSections()) {
            allRegisteredStudents.addAll(section.getStudents());
        }

        if (rowIndex < allRegisteredStudents.size()) {
            return allRegisteredStudents.get(rowIndex).getId();
        }

        return "";
    }
}
