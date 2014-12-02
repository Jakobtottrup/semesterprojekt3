package gui;

import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jakob on 04-11-2014.
 */
public class MainGui extends JFrame {

    private TeamTabPanel teamTabPanel;
    private BoardPanel boardPanel;
    private AddTaskDialog addTaskDialog;
    private AddProjectDialog addProjectDialog;
    private RemoveTaskDialog removeTaskDialog;
    private ManageTeamDialog manageTeamDialog;


    public MainGui() {
        super("Semester Projekt gruppe7 - ScrumBoard");             // Titel
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(getMaximumSize());                                  // set to max size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             // Close operation
        setVisible(true);                                           // Set to visible
        setLayout(new BorderLayout());


        int initCounter = 0;
        if(initCounter == 0)
        {
            init();
        }


        setJMenuBar(createMenuBar());

       teamTabPanel = new TeamTabPanel();
        boardPanel = new BoardPanel();

        add(boardPanel, BorderLayout.NORTH);
        add(teamTabPanel, BorderLayout.CENTER);


    }

    private void init() {
        addTaskDialog = new AddTaskDialog(this);
        addProjectDialog = new AddProjectDialog(this);
        removeTaskDialog = new RemoveTaskDialog(this);
        manageTeamDialog = new ManageTeamDialog(this);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

//============================================= File Menu ===========================================//
        JMenu fileMenu = new JMenu("File");
        JMenuItem createProjectItem = new JMenuItem("Create Project");
        JMenu openProjectMenu = new JMenu("Open Project");
        JMenuItem openProjectItem = new JMenuItem("SHOW_LIST_OF_AVAILABLE_PROJECTS");
        openProjectMenu.add(openProjectItem);
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(createProjectItem);
        fileMenu.add(openProjectMenu);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        createProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openProjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        // File menu -> Create Project Actionlistener
        createProjectItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProjectDialog.setVisible(true);
            }
        });


        // File menu -> Exit actionlistener
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: remove comment for app exit confirmation
//           int action = JOptionPane.showConfirmDialog(gui.MainGui.this, "Do you really want to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
//           if (action == JOptionPane.OK_OPTION)
                System.exit(0);

            }
        });

//============================================= Project Menu ===========================================//
        JMenu projectMenu = new JMenu("Project");
        JMenuItem manageTeamItem = new JMenuItem("Manage Team");
        JMenuItem addTaskItem = new JMenuItem("Add Task");
        JMenuItem removeTaskItem = new JMenuItem("Remove Task");

        projectMenu.add(manageTeamItem);
        projectMenu.addSeparator();
        projectMenu.add(addTaskItem);
        projectMenu.add(removeTaskItem);

        addTaskItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        removeTaskItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

        // Actionlistener for Project Menu -> Add task
        addTaskItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskDialog.setVisible(true);
            }
        });
        removeTaskItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTaskDialog.setVisible(true);
            }
        });
        manageTeamItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageTeamDialog.setVisible(true);
            }
        });
//============================================= Chat Menu ===========================================//
        JMenu chatMenu = new JMenu("Chat");
        JMenuItem openChatItem = new JMenuItem("Open Chat");
        chatMenu.add(openChatItem);


//============================================ Add menus to menubar ================================//
        menuBar.add(fileMenu);
        menuBar.add(projectMenu);
        menuBar.add(chatMenu);
        return menuBar;
    }
    public void makeFrame(Task task) {
        TeamPanel teamPanel = new TeamPanel();
        ArrayList teamList = teamTabPanel.getTeamList();
        JPanel taskPanel = new JPanel();
        taskPanel.setBackground(new Color(255, 255, 51));
        taskPanel.setLayout(new GridLayout(5, 5, 0, 0));
        int status = task.getStatus();
        JLabel titel = new JLabel(task.getTaskName());
        JLabel description = new JLabel(task.getTaskDescription());
        taskPanel.add(titel);
        taskPanel.add(description);

        JButton editBtn = new JButton("Edit");
        if (status == 1) {
            teamPanel = (TeamPanel) teamList.get(0);
            teamPanel.setPendingPanel(taskPanel);
            //boardPanel.revalidate();
        }
        if (status == 2) {
            teamPanel = (TeamPanel) teamList.get(0);
            teamPanel.setOngoingPanel(taskPanel);
        }
        if (status == 3) {
            teamPanel = (TeamPanel) teamList.get(0);
            teamPanel.setFinishedPanel(taskPanel);
        } else {
            boardPanel.add(taskPanel);
        }
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == editBtn) {
                    EditTaskDialog et = new EditTaskDialog(task, taskPanel);
                    et.setVisible(true);
                }
            }
        });
        taskPanel.add(editBtn);
        boardPanel.revalidate();


    }

}


