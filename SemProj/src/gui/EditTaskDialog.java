package gui;

import model.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jakob on 02-12-2014.
 */
public class EditTaskDialog extends JDialog {
    private JPanel contentPane;
    private JLabel lblDescription;
    private JTextArea textArea;
    private JLabel lblTeam;
    private JComboBox comboBox;
    private JLabel lblNewLabel;
    private JComboBox comboBox_1;
    private JButton btnOk;
    private JButton btnCancel;


    public EditTaskDialog(Task task, JPanel taskPanel) {
        setTitle(task.getTaskName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        lblDescription = new JLabel("Description:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 0;
        gbc_lblDescription.gridy = 0;
        contentPane.add(lblDescription, gbc_lblDescription);

        textArea = new JTextArea(task.getTaskDescription());
        textArea.setEditable(true);
        textArea.setText(task.getTaskDescription());
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.gridwidth = 2;
        gbc_textArea.gridheight = 3;
        gbc_textArea.insets = new Insets(0, 0, 5, 0);
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 1;
        gbc_textArea.gridy = 0;
        contentPane.add(textArea, gbc_textArea);

        lblTeam = new JLabel("Team:");
        GridBagConstraints gbc_lblTeam = new GridBagConstraints();
        gbc_lblTeam.anchor = GridBagConstraints.EAST;
        gbc_lblTeam.insets = new Insets(0, 0, 5, 5);
        gbc_lblTeam.gridx = 0;
        gbc_lblTeam.gridy = 4;
        contentPane.add(lblTeam, gbc_lblTeam);

        comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 2;
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 4;
        contentPane.add(comboBox, gbc_comboBox);

        lblNewLabel = new JLabel("Status:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 6;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        String pending = "pending";
        String in_progress = "in progress";
        String done = "done";

        comboBox_1 = new JComboBox();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.gridwidth = 2;
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 6;
        comboBox_1.addItem(null);
        comboBox_1.addItem(pending);
        comboBox_1.addItem(in_progress);
        comboBox_1.addItem(done);
        contentPane.add(comboBox_1, gbc_comboBox_1);

        btnOk = new JButton("OK");
        GridBagConstraints gbc_btnOk = new GridBagConstraints();
        gbc_btnOk.insets = new Insets(0, 0, 0, 5);
        gbc_btnOk.gridx = 1;
        gbc_btnOk.gridy = 8;
        btnOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

//                DBWrite writer = new DBWrite();
//                MainGui gui = MainGui.getInstance();
//                task.setDescription(textArea.getText());
//                task.setCurrentProject(gui.getCurrentProject());
//                Object selectedState = comboBox_1.getSelectedItem();
//                if(selectedState == pending){
//                    task.setStatus(1);
//                }
//                if(selectedState == in_progress){
//                    task.setStatus(2);
//                }
//                if(selectedState == done){
//                    task.setStatus(3);
//                }
//                taskPanel.setVisible(false);
//                writer.editTask(task);
//                gui.makeFrame(task);



            }
        });
        contentPane.add(btnOk, gbc_btnOk);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnCancel)
                {
                    dispose();
                }
            }
        });

        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.gridx = 2;
        gbc_btnCancel.gridy = 8;
        contentPane.add(btnCancel, gbc_btnCancel);
    }
}
