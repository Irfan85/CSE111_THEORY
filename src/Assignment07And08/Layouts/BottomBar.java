package Assignment07And08.Layouts;

import Assignment07And08.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomBar extends JPanel {
    private static JTextField messegeField;
    private JButton resetButton;

    public BottomBar(DatabaseManager dbm) {
        Dimension dimension = this.getPreferredSize();
        dimension.height = 40;
        this.setPreferredSize(dimension);
        setLayout(new BorderLayout());

        messegeField = new JTextField();
        messegeField.setEditable(false);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(getSelf(), "Resetting will erase your database. Are you sure?", "Confirm Reset Database", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (input == JOptionPane.OK_OPTION) {
                    dbm.clearDatabase();
                    dbm.populateData();
                    StudentTablePanel.getStudentDataModel().fireTableDataChanged();
                    CourseTablePanel.getCourseDataModel().fireTableStructureChanged();
                    BottomBar.showMessage("Cleared Database. Restart app to see the effect.");
                }
            }
        });

        add(messegeField, BorderLayout.CENTER);
        add(resetButton, BorderLayout.EAST);

    }

    public static void showMessage(String message) {
        messegeField.setText(message);
    }

    public BottomBar getSelf() {
        return this;
    }

}
