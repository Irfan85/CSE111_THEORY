package Assignment07And08.Layouts;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private static JTabbedPane infoTabPane;

    public InfoPanel(StudentInfoPanel studentInfoPanel, CourseInfoPanel courseInfoPanel) {
        Dimension dimension = this.getPreferredSize();
        dimension.width = 250;
        this.setPreferredSize(dimension);
        this.setLayout(new BorderLayout());
        infoTabPane = new JTabbedPane();
        infoTabPane.addTab("Student Info", studentInfoPanel);
        infoTabPane.addTab("Course Info", courseInfoPanel);

        infoTabPane.setSelectedIndex(0);

        add(infoTabPane, BorderLayout.CENTER);
    }

    public static JTabbedPane getInfotab() {
        return infoTabPane;
    }
}
