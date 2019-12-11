package Assignment07And08.Layouts;

import Assignment07And08.Course;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CourseInfoPanel extends JPanel implements Hidable {
    private JTextArea courseInfoArea;
    private Course course;

    public CourseInfoPanel() {
        super.setBorder(new TitledBorder("Course Info"));
        Dimension dimension = this.getPreferredSize();
        dimension.width = 250;
        this.setPreferredSize(dimension);
        setLayout(new BorderLayout());

        courseInfoArea = new JTextArea();
        courseInfoArea.setEditable(false);

        add(new JScrollPane(courseInfoArea), BorderLayout.CENTER);

    }

    public void assignData() {
        this.courseInfoArea.setText(course.toString());
    }

    public void setCourse(Course course) {
        this.course = course;
        assignData();
        InfoPanel.getInfotab().setSelectedIndex(1);
    }

    @Override
    public boolean isCurrentlyVisible() {
        return super.isVisible();
    }

    @Override
    public void makeVisible(boolean visible) {
        super.setVisible(visible);
    }
}
