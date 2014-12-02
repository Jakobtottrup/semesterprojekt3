package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jakob on 01-12-2014.
 */
public class TeamTabPanel extends JPanel {
    private JTabbedPane tabbedPane;
    private ArrayList teamList;


    public TeamTabPanel() {

        teamList = new ArrayList<TeamPanel>();

        Dimension dim = getPreferredSize();
        dim.height = 300;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Team Panel");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        this.setLayout(new GridLayout(1, 10));


        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Team1", createTeamPanel());
        tabbedPane.addTab("Team2", createTeamPanel());
        tabbedPane.addTab("Team3", createTeamPanel());
        tabbedPane.addTab("Team4", createTeamPanel());
        tabbedPane.setVisible(true);
        add(tabbedPane);



    }
    public TeamPanel createTeamPanel(){
        TeamPanel teamPanel = new TeamPanel();
        teamList.add(teamPanel);
        return teamPanel;
    }
    public ArrayList getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList teamList) {
        this.teamList = teamList;
    }
}
