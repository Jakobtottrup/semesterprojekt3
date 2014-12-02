package gui;

import controller.Controller;
import model.Project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

/**
 * Created by Jakob on 11-11-2014.
 */
public class AddProjectDialog extends JDialog{
    private JLabel nameLabel, descLabel;
    private JTextField nameTextField;
    private JTextArea descTextArea;
    private JButton createButton, cancelButton;
    private Controller controller;


    public AddProjectDialog(JFrame parent) {
        super(parent, "Create Project", true);
        controller = new Controller();

        JPanel controlPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        Border innerBorder = BorderFactory.createTitledBorder("Create New Project");
        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        controlPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        nameLabel = new JLabel("Project Name: ");
        descLabel = new JLabel("Project Description: ");
        nameTextField = new JTextField(10);
        descTextArea = new JTextArea();
        createButton = new JButton("Create");
        cancelButton = new JButton("Cancel");

        setSize(500, 400);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        //////////////////// First Row //////////
        gc.gridy = 0;

        gc.weightx = 0.15;
        gc.weighty = 0.05;
        gc.gridx = 0;

        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(0, 0, 0, 5);

        controlPanel.add(nameLabel, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        controlPanel.add(nameTextField, gc);


        //////////////////// Next Row //////////
        gc.gridy++;

        gc.weightx = 0.15;
        gc.weighty = 4;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.NORTHEAST;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.fill = GridBagConstraints.BOTH;
        controlPanel.add(descLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        controlPanel.add(new JScrollPane(descTextArea), gc);


        //////////////////// Next Row //////////
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(createButton);
        buttonsPanel.add(cancelButton);
        createButton.setMnemonic(KeyEvent.VK_A);
        cancelButton.setMnemonic(KeyEvent.VK_C);

        Dimension btnSize = cancelButton.getPreferredSize();
        createButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        //////////////////// Action Listeners //////////////////

        // Add button
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project project = new Project(nameTextField.getText(), descTextArea.getText());
                project.setProjectID(1);
                try {
                    controller.addProject(project);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });



//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Task task = new Task(nameTextField.getText(), descTextArea.getText());
//                task.setCurrentProject(1);
//                try {
//                    controller.addTask(task);
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });


        // Cancel Button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
