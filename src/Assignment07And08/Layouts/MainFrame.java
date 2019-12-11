package Assignment07And08.Layouts;

import Assignment07And08.Main;
import Assignment07And08.StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private FormPanel formPanel;
    private DataTablePanel dataTablePanel;
    private StudentInfoPanel studentInfoPanel;
    private CourseInfoPanel courseInfoPanel;

    public MainFrame(String title, StudentManager studentManager, BottomBar bottomBar) {
        super(title);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.saveData();
            }
        });


        formPanel = new FormPanel(studentManager);
        add(formPanel, BorderLayout.WEST);

        studentInfoPanel = new StudentInfoPanel(studentManager);
        courseInfoPanel = new CourseInfoPanel();

        add(new InfoPanel(studentInfoPanel, courseInfoPanel), BorderLayout.EAST);

        dataTablePanel = new DataTablePanel(studentManager, studentInfoPanel, courseInfoPanel);
        add(dataTablePanel, BorderLayout.CENTER);

        add(bottomBar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
