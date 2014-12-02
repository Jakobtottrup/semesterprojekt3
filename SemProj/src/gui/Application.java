package gui;

import javax.swing.*;

/**
 * Created by Jakob on 04-11-2014.
 */
public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGui();
            }
        });
    }
}
