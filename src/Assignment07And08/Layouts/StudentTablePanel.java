package Assignment07And08.Layouts;

import Assignment07And08.Student;
import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentTablePanel extends JPanel {
    private JTable studentTable;
    private static StudentDataModel studentDataModel;

    public StudentTablePanel(StudentManager studentManager, StudentInfoPanel studentInfoPanel) {
        setLayout(new BorderLayout());

        studentTable = new JTable();
        studentDataModel = new StudentDataModel(studentManager);
        studentTable.setModel(studentDataModel);
        studentTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Point point = e.getPoint();
                    int row = studentTable.rowAtPoint(point);
                    showInfo(studentManager.getStudentList().get(row), studentInfoPanel);
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
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        setVisible(true);
    }

    public static StudentDataModel getStudentDataModel() {
        return studentDataModel;
    }

    public void showInfo(Student student, StudentInfoPanel studentInfoPanel) {
        studentInfoPanel.setStudent(student);
    }
}
