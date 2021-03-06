import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jakob on 03-11-2014.
 */
public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private JButton btn;
    private Toolbar toolbar;


    public MainFrame() {
        super("Hello World");


        setLayout(new BorderLayout());
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        btn = new JButton("Click me!");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textPanel.appendText("Hello\n");
            }
        });


        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
