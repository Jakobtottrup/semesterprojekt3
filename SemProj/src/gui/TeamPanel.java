package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Jakob on 06-11-2014.
 */
public class TeamPanel extends JPanel {
    private JPanel pendingPanel;
    private JPanel ongoingPanel;
    private JPanel finishedPanel;
    private JLabel pendingLabel;
    private JLabel ongoingLabel;
    private JLabel finishedLabel;

    public TeamPanel() {
        this.setLayout(new GridLayout(1, 3));


        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);


        pendingPanel = new JPanel();
        ongoingPanel = new JPanel();
        finishedPanel = new JPanel();
        Border pendingBorder = BorderFactory.createTitledBorder("Pending");
        pendingPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, pendingBorder));
        Border ongoingBorder = BorderFactory.createTitledBorder("On-going");
        ongoingPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, ongoingBorder));
        Border finishedBorder = BorderFactory.createTitledBorder("Finished");
        finishedPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, finishedBorder));

        pendingPanel.setVisible(true);
        ongoingPanel.setVisible(true);
        finishedPanel.setVisible(true);
        pendingLabel = new JLabel("TEST");
        pendingPanel.add(pendingLabel);

        this.add(pendingPanel);
        this.add(ongoingPanel);
        this.add(finishedPanel);




    }

    public JPanel getPendingPanel() {
        return pendingPanel;
    }

    public void setPendingPanel(JPanel pendingPanel) {
        this.pendingPanel = pendingPanel;
    }

    public JPanel getOngoingPanel() {
        return ongoingPanel;
    }

    public void setOngoingPanel(JPanel ongoingPanel) {
        this.ongoingPanel = ongoingPanel;
    }

    public JPanel getFinishedPanel() {
        return finishedPanel;
    }

    public void setFinishedPanel(JPanel finishedPanel) {
        this.finishedPanel = finishedPanel;
    }
}

