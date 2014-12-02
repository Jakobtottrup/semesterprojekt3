package gui;

import controller.Controller;
import db.DBRead;
import model.Task;
import model.TaskList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Jakob on 17-11-2014.
 */
public class RemoveTaskDialog extends JDialog {
    private JLabel nameLabel;
    private JButton removeButton;
    private JButton cancelButton;
    private JComboBox comboBox;
    private Controller controller;
    private DBRead dbReader;
    private String tempString = "Select task";
    private TaskList taskList;

    public RemoveTaskDialog(JFrame parent) {
        super(parent, "Remove Task", true);
        controller = new Controller();
        dbReader = new DBRead();
        taskList = dbReader.getTasks();

        JPanel controlPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Border innerBorder = BorderFactory.createTitledBorder("Remove Task");
        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        controlPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        nameLabel = new JLabel("Task:");
        removeButton = new JButton("Remove");
        cancelButton = new JButton("Cancel");
        comboBox = new JComboBox();
        update();


        setSize(350, 150);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;


        //////////////////// First Row //////////
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 1;


        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(0, 0, 0, 5);
        controlPanel.add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.NORTH;
        gc.fill = GridBagConstraints.HORIZONTAL;
        controlPanel.add(comboBox, gc);
        gc.gridy++;
        gc.weighty = 2;
        //////////////////// Next Row //////////
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(removeButton);
        buttonsPanel.add(cancelButton);
        removeButton.setMnemonic(KeyEvent.VK_R);
        cancelButton.setMnemonic(KeyEvent.VK_C);

        Dimension btnSize = cancelButton.getPreferredSize();
        removeButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task();
                task.setTaskName(comboBox.getSelectedItem().toString());
                controller.removeTask(task);
                update();
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    private void update() {
        comboBox.removeAllItems();
        comboBox.addItem(tempString);
        for (int i = 0; i <= taskList.getLength() - 1; i++) {
            comboBox.addItem(taskList.getTask(i).getTaskName());
        }

    }
}


