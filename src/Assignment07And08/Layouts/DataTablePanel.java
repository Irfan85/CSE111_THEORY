package Assignment07And08.Layouts;

import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;

public class DataTablePanel extends JPanel {
    private JTabbedPane tabbedPane;
    private StudentTablePanel studentTablePanel;
    private CourseTablePanel courseTablePanel;

    public DataTablePanel(StudentManager studentManager, StudentInfoPanel studentInfoPanel, CourseInfoPanel courseInfoPanel) {
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();
        studentTablePanel = new StudentTablePanel(studentManager, studentInfoPanel);
        courseTablePanel = new CourseTablePanel(studentManager, courseInfoPanel);

        tabbedPane.addTab("Students", studentTablePanel);
        tabbedPane.addTab("Courses", courseTablePanel);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
