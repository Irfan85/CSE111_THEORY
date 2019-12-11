package Assignment07And08.Layouts;

import Assignment07And08.Course;
import Assignment07And08.Student;
import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignCourseDialog extends JDialog {
    private JComboBox<String> courseBox;
    private JLabel courseLabel;
    private JButton saveButton;

    public AssignCourseDialog(StudentInfoPanel infoPanel, StudentManager studentManager, Student student) {
        setTitle("Assign Course");
        setSize(300, 200);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Row 1
        gc.weighty = 5;

        gc.gridx = 0;
        gc.gridy = 0;

        courseLabel = new JLabel("Available Courses for: " + student.getId());
        add(courseLabel, gc);

        // Row 2
        gc.gridx = 0;
        gc.gridy = 1;

        courseBox = new JComboBox<>();
        assignAvailableCourses(studentManager, student);
        add(courseBox, gc);

        // Row 3
        gc.gridx = 0;
        gc.gridy = 2;

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = studentManager.isExistingCourse((String) courseBox.getSelectedItem());
                if (course != null) {
                    studentManager.assignCourse(student, course);
                    infoPanel.assignData();
                    StudentTablePanel.getStudentDataModel().fireTableDataChanged();
                    CourseTablePanel.getCourseDataModel().fireTableDataChanged();
                    BottomBar.showMessage("Assigned " + course.getCourseName() + " to Student: " + student.getId());
                    setVisible(false);
                }
            }
        });

        add(saveButton, gc);
    }

    public void assignAvailableCourses(StudentManager studentManager, Student student) {
        for (Course course : studentManager.getCourses()) {
            if (!student.getCompletedCourses().containsKey(course) && !student.getCurrentCourses().contains(course)) {
                courseBox.addItem(course.getCourseName());
            }
        }
    }
}
