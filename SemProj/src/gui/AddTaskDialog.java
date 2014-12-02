package gui;

import controller.Controller;
import model.Task;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

/**
 * Created by Jakob on 07-11-2014.
 */
public class AddTaskDialog extends JDialog {
    private JLabel taskLabel, descLabel;
    private JTextField nameTextField;
    private JTextArea descTextArea;
    private Controller controller;
    private JButton addButton, cancelButton;


    public AddTaskDialog(JFrame parent) {
        super(parent, "Add Task", true);
        controller = new Controller();

        JPanel controlPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        Border innerBorder = BorderFactory.createTitledBorder("Create New Task");
        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        controlPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        taskLabel = new JLabel("Task Name: ");
        descLabel = new JLabel("Task Description: ");
        nameTextField = new JTextField(10);
        descTextArea = new JTextArea();
        addButton = new JButton("Add");
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

        controlPanel.add(taskLabel, gc);
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
        buttonsPanel.add(addButton);
        buttonsPanel.add(cancelButton);
        addButton.setMnemonic(KeyEvent.VK_A);
        cancelButton.setMnemonic(KeyEvent.VK_C);

        Dimension btnSize = cancelButton.getPreferredSize();
        addButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);


        //////////////////// Action Listeners //////////////////
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task(nameTextField.getText(), descTextArea.getText());
                task.setCurrentProject(1);
                try {
                    controller.addTask(task);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
//    public void createTaskFrame(Task task){
//        JPanel taskPanel = new JPanel();
//            taskPanel.setBackground(new Color(255, 255, 51));
//            taskPanel.setLayout(new GridLayout(5, 5, 0, 0));
//            JLabel titel = new JLabel(task.getTaskName());
//
//            JLabel description = new JLabel(task.getTaskDescription());
//            taskPanel.add(titel);
//            taskPanel.add(description);
////            frameMap.put(task, taskPanel);
//            JButton editBtn = new JButton("Edit");
//            if(task.getStatus() == 1){
//
//                JPanel pendingPanel = taskPanel;
//                panel_10.add(taskPanel);
//                boardPanel.revalidate();
//            }
//            else{
//                boardPanel.add(taskPanel);
//            }
//            editBtn.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e){
//                    if (e.getSource() == editBtn) {
//                        EditTask et = new EditTask(task, taskPanel);
//                        et.setVisible(true);
//                    }
//                }
//            });
//            taskPanel.add(editBtn);
//            frmScrumboard.revalidate();
//









//        {
//            JPanel taskPanel = new JPanel();
//            taskPanel.setBackground(new Color(255, 255, 51));
//            taskPanel.setLayout(new GridLayout(5, 5, 0, 0));
//            int status = task.getStatus();
//            int taskId = task.getId();
//            JLabel titel = new JLabel(task.getTaskName());
//            JLabel description = new JLabel(task.getDescription());
//            taskPanel.add(titel);
//            taskPanel.add(description);
//            frameMap.put(task, taskPanel);
//            JButton editBtn = new JButton("Edit");
//            if(status == 1){
//
//                JPanel pendingPanel = taskPanel;
//                panel_10.add(taskPanel);
//                boardPanel.revalidate();
//            }
//            else{
//                boardPanel.add(taskPanel);
//            }
//            editBtn.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e){
//                    if (e.getSource() == editBtn) {
//                        EditTask et = new EditTask(task, taskPanel);
//                        et.setVisible(true);
//                    }
//                }
//            });
//            taskPanel.add(editBtn);
//            frmScrumboard.revalidate();
//
//
//        }
