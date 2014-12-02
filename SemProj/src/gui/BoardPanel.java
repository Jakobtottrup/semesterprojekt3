package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Jakob on 06-11-2014.
 */
public class BoardPanel extends JPanel {
    public BoardPanel() {

        Dimension dim = getPreferredSize();
        dim.height = 420;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Board Panel");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
}
