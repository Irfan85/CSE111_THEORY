package Assignment07And08.Layouts;

import Assignment07And08.BBAStudent;
import Assignment07And08.CSEStudent;
import Assignment07And08.MNSStudent;
import Assignment07And08.StudentManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrom extends JPanel {
    private final String[] DEPARTMENTS = {"CSE", "MNS", "BBA"};
    private JLabel nameLabel, idLabel, departmentLabel;
    private JTextField name, id;
    private JComboBox<String> departmentBox;
    private JButton submitButton;
    private StudentManager studentManager;

    public StudentFrom(StudentManager studentManager) {
        setBorder(new TitledBorder("Student Form"));
        setLayout(new GridBagLayout());

        this.studentManager = studentManager;
        nameLabel = new JLabel("Name:");
        idLabel = new JLabel("ID:");
        departmentLabel = new JLabel("Department:");
        name = new JTextField(10);
        id = new JTextField(10);
        departmentBox = new JComboBox<>(DEPARTMENTS);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent(name.getText(), id.getText(), (String) departmentBox.getSelectedItem());
                StudentTablePanel.getStudentDataModel().fireTableDataChanged();
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

        gc.insets = new Insets(0, 0, 0, 5);
        add(idLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(id, gc);

        // Row 3
        gc.gridx = 0;
        gc.gridy = 2;

        gc.insets = new Insets(0, 0, 0, 5);
        add(departmentLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(departmentBox, gc);

        // Row 4
        gc.weighty = 8;

        gc.gridx = 0;
        gc.gridy = 3;

        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton, gc);

        setVisible(true);
    }

    private void addStudent(String name, String id, String department) {
        if (!name.equals("") && !id.equals("")) {
            switch (department) {
                case "CSE":
                    studentManager.addStudent(new CSEStudent(name, id));
                    break;
                case "BBA":
                    studentManager.addStudent(new BBAStudent(name, id));
                    break;
                case "MNS":
                    studentManager.addStudent(new MNSStudent(name, id));
                    break;
            }

        } else {
            System.err.println("Input cannot be empty");
        }
    }


}
