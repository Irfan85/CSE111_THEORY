package Assignment07And08.Layouts;

import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    private JTabbedPane formTabPane;

    public FormPanel(StudentManager studentManager) {
        super.setLayout(new BorderLayout());
        Dimension dimension = super.getPreferredSize();
        dimension.width = 200;
        super.setPreferredSize(dimension);

        formTabPane = new JTabbedPane();
        formTabPane.addTab("Add Student", new StudentFrom(studentManager));
        formTabPane.addTab("Add Course", new CourseForm(studentManager));
        super.add(formTabPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
