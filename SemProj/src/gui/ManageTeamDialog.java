package gui;

/**
 * Created by Jakob on 24-11-2014.
 */


import controller.Controller;
import model.Team;
import model.User;
import model.UserList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ManageTeamDialog extends JDialog {

    private JList listMembers;
    private JPanel contentPane;
    private JTextField textTeamName;
    private JComboBox comboTeamLeader;
    private JComboBox comboSelectMember;
    private DefaultListModel selectedMembers;
    private Controller controller;
    private UserList userList;
    private Team teamList;
    private int teamID;


    public ManageTeamDialog(JFrame parent){
        super(parent, "Manage Team", true);
        controller = new Controller();
        teamList = new Team();
        selectedMembers = new DefaultListModel();


        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{82, 355, 355, 0};
        gbl_contentPane.rowHeights = new int[]{41, 40, -6, 94, 28, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblName = new JLabel("Team Name:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        contentPane.add(lblName, gbc_lblName);

        textTeamName = new JTextField();
        GridBagConstraints gbc_textTeamName = new GridBagConstraints();
        gbc_textTeamName.gridwidth = 2;
        gbc_textTeamName.insets = new Insets(0, 0, 5, 0);
        gbc_textTeamName.fill = GridBagConstraints.HORIZONTAL;
        gbc_textTeamName.gridx = 1;
        gbc_textTeamName.gridy = 0;
        contentPane.add(textTeamName, gbc_textTeamName);
        textTeamName.setColumns(10);

        JLabel lblTeamLeader = new JLabel("Team Leader:");
        GridBagConstraints gbc_lblTeamLeader = new GridBagConstraints();
        gbc_lblTeamLeader.anchor = GridBagConstraints.EAST;
        gbc_lblTeamLeader.insets = new Insets(0, 0, 5, 5);
        gbc_lblTeamLeader.gridx = 0;
        gbc_lblTeamLeader.gridy = 1;
        contentPane.add(lblTeamLeader, gbc_lblTeamLeader);

        String tempTeamLeader = "Choose Team Leader";
        JComboBox comboTeamLeader = new JComboBox();

        //todo: --- Add update method --- //
        comboTeamLeader.addItem(tempTeamLeader);
        userList = controller.getUserList();
        for (int l = 0; l <= userList.getLength() - 1; l++) {
            if (userList.getUser(l).getTitle() == 1) {
                comboTeamLeader.addItem(userList.getUser(l).getFullName());
            }
        }

        GridBagConstraints gbc_comboTeamLeader = new GridBagConstraints();
        gbc_comboTeamLeader.gridwidth = 2;
        gbc_comboTeamLeader.insets = new Insets(0, 0, 5, 0);
        gbc_comboTeamLeader.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboTeamLeader.gridx = 1;
        gbc_comboTeamLeader.gridy = 1;
        contentPane.add(comboTeamLeader, gbc_comboTeamLeader);

        JLabel lblSelectMember = new JLabel("Select Member:");
        GridBagConstraints gbc_lblSelectMember = new GridBagConstraints();
        gbc_lblSelectMember.insets = new Insets(0, 0, 5, 5);
        gbc_lblSelectMember.anchor = GridBagConstraints.EAST;
        gbc_lblSelectMember.gridx = 0;
        gbc_lblSelectMember.gridy = 2;
        contentPane.add(lblSelectMember, gbc_lblSelectMember);


        String tempSelectMember = "Add members";
        JComboBox comboSelectMember = new JComboBox();
        comboSelectMember.addItem(tempSelectMember);

        for (int i = 0; i <= userList.getLength() - 1; i++) {
            if (userList.getUser(i).getTitle() != 1)

                comboSelectMember.addItem(userList.getUser(i).getFullName());
        }


        GridBagConstraints gbc_comboSelectMember = new GridBagConstraints();
        gbc_comboSelectMember.insets = new Insets(0, 0, 5, 5);
        gbc_comboSelectMember.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboSelectMember.gridx = 1;
        gbc_comboSelectMember.gridy = 2;
        contentPane.add(comboSelectMember, gbc_comboSelectMember);

        JButton btnAddMember = new JButton("Add");
        btnAddMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String selectedTeamMember = (String) comboSelectMember.getSelectedItem();

                if (comboSelectMember.getSelectedItem() == tempSelectMember) {
                    JOptionPane.showMessageDialog(ManageTeamDialog.this, "Please select a member.");
                } else {
                    if (selectedMembers.contains(comboSelectMember.getSelectedItem()) == true) {
                        JOptionPane.showMessageDialog(ManageTeamDialog.this, "Member already in team.");
                    } else {
                        selectedMembers.addElement(selectedTeamMember);
                        teamList.addUser(userList.getUserbyString(selectedTeamMember));
                    }
                }
            }
        });
        GridBagConstraints gbc_btnAddMember = new GridBagConstraints();
        gbc_btnAddMember.insets = new Insets(0, 0, 5, 0);
        gbc_btnAddMember.gridx = 2;
        gbc_btnAddMember.gridy = 2;
        contentPane.add(btnAddMember, gbc_btnAddMember);

        JLabel lblMembers = new JLabel("Members:");
        GridBagConstraints gbc_lblMembers = new GridBagConstraints();
        gbc_lblMembers.anchor = GridBagConstraints.EAST;
        gbc_lblMembers.insets = new Insets(0, 0, 5, 5);
        gbc_lblMembers.gridx = 0;
        gbc_lblMembers.gridy = 3;
        contentPane.add(lblMembers, gbc_lblMembers);

        JButton btnRemoveMembers = new JButton("Remove");
        btnRemoveMembers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = listMembers.getSelectedIndex();
                if (listMembers.isSelectedIndex(index) == true)
                    selectedMembers.removeElementAt(index);

            }
        });

        listMembers = new JList(selectedMembers);
        GridBagConstraints gbc_listMembers = new GridBagConstraints();
        gbc_listMembers.insets = new Insets(0, 0, 5, 5);
        gbc_listMembers.fill = GridBagConstraints.BOTH;
        gbc_listMembers.gridx = 1;
        gbc_listMembers.gridy = 3;
        contentPane.add(new JScrollPane(listMembers), gbc_listMembers);
        GridBagConstraints gbc_btnRemoveMembers = new GridBagConstraints();
        gbc_btnRemoveMembers.insets = new Insets(0, 0, 5, 0);
        gbc_btnRemoveMembers.gridx = 2;
        gbc_btnRemoveMembers.gridy = 3;
        contentPane.add(btnRemoveMembers, gbc_btnRemoveMembers);


        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addTeam(teamList);

            }
        });
        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
        gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
        gbc_btnCreate.gridx = 1;
        gbc_btnCreate.gridy = 4;
        contentPane.add(btnCreate, gbc_btnCreate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnCancel) {
                    dispose();
                }
            }
        });
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.gridx = 2;
        gbc_btnCancel.gridy = 4;
        contentPane.add(btnCancel, gbc_btnCancel);



    }

}

//    public static ManageTeamGUI getInstance() {
//
//        if (manageTeamGUI != null) {
//            return manageTeamGUI;
//        }
//        return (manageTeamGUI = new ManageTeamGUI());
//    }
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ManageTeamGUI frame;
//                    frame = ManageTeamGUI.getInstance();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public void initialize() {
//        DBRead dbReader = new DBRead();
//        UserList userList = dbReader.GetUsers();
//        selectedMembers = new DefaultListModel();
//        setTitle("Manage Team");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        GridBagLayout gbl_contentPane = new GridBagLayout();
//        gbl_contentPane.columnWidths = new int[]{82, 355, 355, 0};
//        gbl_contentPane.rowHeights = new int[]{41, 40, -6, 94, 28, 0};
//        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
//        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
//        contentPane.setLayout(gbl_contentPane);
//
//        JLabel lblName = new JLabel("Team Name:");
//        GridBagConstraints gbc_lblName = new GridBagConstraints();
//        gbc_lblName.anchor = GridBagConstraints.EAST;
//        gbc_lblName.insets = new Insets(0, 0, 5, 5);
//        gbc_lblName.gridx = 0;
//        gbc_lblName.gridy = 0;
//        contentPane.add(lblName, gbc_lblName);
//
//        textTeamName = new JTextField();
//        GridBagConstraints gbc_textTeamName = new GridBagConstraints();
//        gbc_textTeamName.gridwidth = 2;
//        gbc_textTeamName.insets = new Insets(0, 0, 5, 0);
//        gbc_textTeamName.fill = GridBagConstraints.HORIZONTAL;
//        gbc_textTeamName.gridx = 1;
//        gbc_textTeamName.gridy = 0;
//        contentPane.add(textTeamName, gbc_textTeamName);
//        textTeamName.setColumns(10);
//
//        JLabel lblTeamLeader = new JLabel("Team Leader:");
//        GridBagConstraints gbc_lblTeamLeader = new GridBagConstraints();
//        gbc_lblTeamLeader.anchor = GridBagConstraints.EAST;
//        gbc_lblTeamLeader.insets = new Insets(0, 0, 5, 5);
//        gbc_lblTeamLeader.gridx = 0;
//        gbc_lblTeamLeader.gridy = 1;
//        contentPane.add(lblTeamLeader, gbc_lblTeamLeader);
//
//        String tempTeamLeader = "Choose Team Leader";
//        JComboBox comboTeamLeader = new JComboBox();
//        comboTeamLeader.addItem(tempTeamLeader);
//
//        for (int l = 0; l <= userList.getLength() - 1; l++) {
//            if (userList.getUser(l).getTitle() == 1) {
//                comboTeamLeader.addItem(userList.getUser(l).getFullName());
//            }
//        }
//
//        GridBagConstraints gbc_comboTeamLeader = new GridBagConstraints();
//        gbc_comboTeamLeader.gridwidth = 2;
//        gbc_comboTeamLeader.insets = new Insets(0, 0, 5, 0);
//        gbc_comboTeamLeader.fill = GridBagConstraints.HORIZONTAL;
//        gbc_comboTeamLeader.gridx = 1;
//        gbc_comboTeamLeader.gridy = 1;
//        contentPane.add(comboTeamLeader, gbc_comboTeamLeader);
//
//        JLabel lblSelectMember = new JLabel("Select Member:");
//        GridBagConstraints gbc_lblSelectMember = new GridBagConstraints();
//        gbc_lblSelectMember.insets = new Insets(0, 0, 5, 5);
//        gbc_lblSelectMember.anchor = GridBagConstraints.EAST;
//        gbc_lblSelectMember.gridx = 0;
//        gbc_lblSelectMember.gridy = 2;
//        contentPane.add(lblSelectMember, gbc_lblSelectMember);
//
//
//        String tempSelectMember = "Add members";
//        JComboBox comboSelectMember = new JComboBox();
//        comboSelectMember.addItem(tempSelectMember);
//
//        for (int i = 0; i <= userList.getLength() - 1; i++) {
//            if (userList.getUser(i).getTitle() != 1)
//
//                comboSelectMember.addItem(userList.getUser(i).getFullName());
//        }
//
//
//        GridBagConstraints gbc_comboSelectMember = new GridBagConstraints();
//        gbc_comboSelectMember.insets = new Insets(0, 0, 5, 5);
//        gbc_comboSelectMember.fill = GridBagConstraints.HORIZONTAL;
//        gbc_comboSelectMember.gridx = 1;
//        gbc_comboSelectMember.gridy = 2;
//        contentPane.add(comboSelectMember, gbc_comboSelectMember);
//
//        JButton btnAddMember = new JButton("Add");
//        btnAddMember.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//
//                String selectedTeamMember = (String) comboSelectMember.getSelectedItem();
//
//                if (comboSelectMember.getSelectedItem() == tempSelectMember) {
//                    JOptionPane.showMessageDialog(frame, "Please select a member.");
//                } else {
//                    if (selectedMembers.contains(comboSelectMember.getSelectedItem()) == true) {
//                        JOptionPane.showMessageDialog(frame, "Member already in team.");
//                    } else {
//                        selectedMembers.addElement(selectedTeamMember);
//
//                    }
//                }
//            }
//        });
//        GridBagConstraints gbc_btnAddMember = new GridBagConstraints();
//        gbc_btnAddMember.insets = new Insets(0, 0, 5, 0);
//        gbc_btnAddMember.gridx = 2;
//        gbc_btnAddMember.gridy = 2;
//        contentPane.add(btnAddMember, gbc_btnAddMember);
//
//        JLabel lblMembers = new JLabel("Members:");
//        GridBagConstraints gbc_lblMembers = new GridBagConstraints();
//        gbc_lblMembers.anchor = GridBagConstraints.EAST;
//        gbc_lblMembers.insets = new Insets(0, 0, 5, 5);
//        gbc_lblMembers.gridx = 0;
//        gbc_lblMembers.gridy = 3;
//        contentPane.add(lblMembers, gbc_lblMembers);
//
//        JButton btnRemoveMembers = new JButton("Remove");
//        btnRemoveMembers.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int index = listMembers.getSelectedIndex();
//                if (listMembers.isSelectedIndex(index) == true)
//                    selectedMembers.removeElementAt(index);
//
//            }
//        });
//
//        listMembers = new JList(selectedMembers);
//        GridBagConstraints gbc_listMembers = new GridBagConstraints();
//        gbc_listMembers.insets = new Insets(0, 0, 5, 5);
//        gbc_listMembers.fill = GridBagConstraints.BOTH;
//        gbc_listMembers.gridx = 1;
//        gbc_listMembers.gridy = 3;
//        contentPane.add(new JScrollPane(listMembers), gbc_listMembers);
//        GridBagConstraints gbc_btnRemoveMembers = new GridBagConstraints();
//        gbc_btnRemoveMembers.insets = new Insets(0, 0, 5, 0);
//        gbc_btnRemoveMembers.gridx = 2;
//        gbc_btnRemoveMembers.gridy = 3;
//        contentPane.add(btnRemoveMembers, gbc_btnRemoveMembers);
//
//
//        JButton btnCreate = new JButton("Create");
//        btnCreate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                DBWrite dbWriter = new DBWrite();
//                CreateTeam createTeam = new CreateTeam();
//                createTeam.setTeamName(textTeamName.getText());
//
//            }
//        });
//        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
//        gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
//        gbc_btnCreate.gridx = 1;
//        gbc_btnCreate.gridy = 4;
//        contentPane.add(btnCreate, gbc_btnCreate);
//
//        JButton btnCancel = new JButton("Cancel");
//        btnCancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == btnCancel) {
//                    dispose();
//                }
//            }
//        });
//        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
//        gbc_btnCancel.gridx = 2;
//        gbc_btnCancel.gridy = 4;
//        contentPane.add(btnCancel, gbc_btnCancel);
//    }
//
//}

