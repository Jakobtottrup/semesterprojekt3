import javax.swing.*;
import java.awt.*;

/**
 * Created by Jakob on 03-11-2014.
 */
public class Toolbar extends JPanel {

    private JButton helloButton;
    private JButton goodbyeButton;
    public Toolbar() {

        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodbyeButton);

    }
}
