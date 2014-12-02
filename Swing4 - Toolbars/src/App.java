
import javax.swing.*;

/**
 * Created by Jakob on 03-11-2014.
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();


            }
        });
    }
}
