package Assignment07And08.Layouts;

import Assignment07And08.Course;
import Assignment07And08.Student;
import Assignment07And08.StudentManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentInfoPanel extends JPanel implements Hidable {
    private JLabel nameLabel, idLabel, departmentLabel, cgpaLabel, creditsLabel, currentLabel, completedLabel;
    private JTextField name, id, department, cgpa, credits;
    private JList<String> currentCourses;
    private JList<String> completedCourses;
    private JButton completeButton, dropButton, assignButton, removeButton;
    private AssignCourseDialog assignCourseDialog;
    private StudentManager studentManager;
    private Student student;

    public StudentInfoPanel(StudentManager studentManager) {
        setBorder(new TitledBorder("Student Information"));
        Dimension dimension = this.getPreferredSize();
        dimension.width = 250;
        this.setPreferredSize(dimension);
        setLayout(new GridBagLayout());

        this.studentManager = studentManager;
        nameLabel = new JLabel("Name:");
        idLabel = new JLabel("ID:");
        departmentLabel = new JLabel("Department:");
        cgpaLabel = new JLabel("CGPA:");
        creditsLabel = new JLabel("Credits:");
        currentLabel = new JLabel("Current Courses");
        completedLabel = new JLabel("Completed Courses");

        name = new JTextField();
        id = new JTextField();
        department = new JTextField();
        cgpa = new JTextField();
        credits = new JTextField();

        name.setEditable(false);
        id.setEditable(false);
        department.setEditable(false);
        cgpa.setEditable(false);
        credits.setEditable(false);

        currentCourses = new JList<>();
        completedCourses = new JList<>();

        completeButton = new JButton("Complete");
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                completeCourse(currentCourses.getSelectedValue());
            }
        });

        dropButton = new JButton("Drop");
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dropCourse(currentCourses.getSelectedValue());
            }
        });

        assignButton = new JButton("Assingn Course");
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (student != null) {
                    assignCourseDialog = new AssignCourseDialog(getInfoPanel(), studentManager, student);
                    assignCourseDialog.setVisible(true);
                }
            }
        });

        removeButton = new JButton("Remove Student");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
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
        add(department, gc);

        // Row 4
        gc.gridx = 0;
        gc.gridy = 3;

        gc.insets = new Insets(0, 0, 0, 5);
        add(cgpaLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(cgpa, gc);
        // Row 5
        gc.gridx = 0;
        gc.gridy = 4;

        gc.insets = new Insets(0, 0, 0, 5);
        add(creditsLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(credits, gc);

        // Row 6
        gc.gridx = 0;
        gc.gridy = 5;

        gc.insets = new Insets(0, 0, 0, 5);
        add(currentLabel, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(completedLabel, gc);

        // Row 7
        gc.weighty = 5;
        gc.gridx = 0;
        gc.gridy = 6;

        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(0, 0, 0, 5);
        add(currentCourses, gc);

        gc.gridx = 1;

        gc.insets = new Insets(0, 0, 0, 0);
        add(completedCourses, gc);

        // Row 8
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 7;

        gc.anchor = GridBagConstraints.CENTER;
        add(completeButton, gc);

        gc.gridx = 1;

        add(dropButton, gc);

        // Row 9
        gc.gridwidth = 2;

        gc.gridx = 0;
        gc.gridy = 8;

        add(assignButton, gc);

        // Row 10
        gc.gridx = 0;
        gc.gridy = 9;

        add(removeButton, gc);
    }

    private void completeCourse(String courseName) {
        Course course = studentManager.isExistingCourse(courseName);
        if (course != null && student != null) {
            String input = JOptionPane.showInputDialog(this, "Enter CGPA for " + courseName);
            try {
                double cgpa = Double.parseDouble(input);
                if (cgpa >= 0 && cgpa <= 4.0) {
                    studentManager.finishCourse(student, course, cgpa);
                    assignData();
                    StudentTablePanel.getStudentDataModel().fireTableDataChanged();
                    CourseTablePanel.getCourseDataModel().fireTableDataChanged();

                    BottomBar.showMessage(courseName + " marked completed for Student: " + student.getId());
                }
            } catch (NumberFormatException e) {
                BottomBar.showMessage("Casting error");
            } catch (NullPointerException e) {
                // Just Chill
            }
        }
    }

    private void dropCourse(String courseName) {
        Course course = studentManager.isExistingCourse(courseName);
        if (course != null) {
            boolean success = studentManager.dropCourse(this.student, studentManager.isExistingCourse(courseName));
            if (success) {
                assignData();
                StudentTablePanel.getStudentDataModel().fireTableDataChanged();
                CourseTablePanel.getCourseDataModel().fireTableDataChanged();

                BottomBar.showMessage("Successfully dropped " + courseName + " from Student: " + student.getId());
            }
        }
    }

    public void assignData() {
        name.setText(this.student.getName());
        id.setText(this.student.getId());
        department.setText(this.student.getDepartment());
        cgpa.setText(this.student.getCgpa() + "");
        credits.setText(this.student.getCredits() + "");

        currentCourses.setListData(getCourseNames(this.student.getCurrentCourses()));
        completedCourses.setListData(getCourseNames(new ArrayList<>(this.student.getCompletedCourses().keySet())));
    }

    public String[] getCourseNames(ArrayList<Course> courses) {
        String[] courseNames = new String[courses.size()];
        int i = 0;
        for (Course course : courses) {
            courseNames[i++] = course.getCourseName();
        }

        return courseNames;
    }

    private void removeStudent() {
        if (student != null) {
            studentManager.removeStudent(studentManager.getStudentById(student.getId()));
            BottomBar.showMessage("Successfully removed Student");
            StudentTablePanel.getStudentDataModel().fireTableDataChanged();
            CourseTablePanel.getCourseDataModel().fireTableStructureChanged();
        }
    }

    public StudentInfoPanel getInfoPanel() {
        return this;
    }

    public void setStudent(Student student) {
        this.student = student;
        assignData();
        InfoPanel.getInfotab().setSelectedIndex(0);
    }

    @Override
    public boolean isCurrentlyVisible() {
        return isVisible();
    }

    @Override
    public void makeVisible(boolean visible) {
        setVisible(visible);
    }
}
