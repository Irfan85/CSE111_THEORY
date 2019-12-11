package Assignment07And08.Layouts;

import Assignment07And08.Course;
import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CourseTablePanel extends JPanel {
    private JTable courseTable;
    private static CourseDataModel courseDataModel;

    public CourseTablePanel(StudentManager studentManager, CourseInfoPanel courseInfoPanel) {
        setLayout(new BorderLayout());

        courseTable = new JTable();
        courseDataModel = new CourseDataModel(studentManager);
        courseTable.setModel(courseDataModel);
        courseTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Point point = e.getPoint();
                    int column = courseTable.columnAtPoint(point);
                    showInfo(studentManager.getCourses().get(column), courseInfoPanel);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(new JScrollPane(courseTable), BorderLayout.CENTER);
        setVisible(true);
    }

    public static CourseDataModel getCourseDataModel() {
        return courseDataModel;
    }

    public void showInfo(Course course, CourseInfoPanel courseInfoPanel) {
        courseInfoPanel.setCourse(course);
    }
}
