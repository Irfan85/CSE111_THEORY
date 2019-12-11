package Assignment07And08.Layouts;

import Assignment07And08.StudentManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseForm extends JPanel {
    private JLabel nameLabel;
    private JTextField name;
    private JButton submitButton;
    private StudentManager studentManager;

    public CourseForm(StudentManager studentManager) {
        super.setBorder(new TitledBorder("Course Form"));
        super.setLayout(new GridBagLayout());

        this.studentManager = studentManager;
        nameLabel = new JLabel("Name:");
        name = new JTextField(10);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCourse(name.getText());
                CourseTablePanel.getCourseDataModel().fireTableStructureChanged();
            }
        });

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.5;

        // Row 1
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(name, gc);

        // Row 2
        gc.gridx = 0;
        gc.gridy = 1;

        gc.weighty = 8;

        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton, gc);

        setVisible(true);
    }

    private void createCourse(String courseName) {
        if (!courseName.equals("")) {
            studentManager.addCourse(courseName);
            BottomBar.showMessage("Added Course: " + courseName + ". Add at least 1 Student to this course to make it permanent.");
        } else {
            BottomBar.showMessage("Course name cannot be empty.");
        }
    }
}

