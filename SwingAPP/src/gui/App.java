package gui;

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

/*NOTES
MVC architecture = Model-View-Controller
View is the actual GUI
Controller is the thing binding everything together with the logic (mainframe)
Model is the database layer
gui.FormPanel has detailed notes on components



* Swing7&8 - Communication:
* Components should know as little as possible about each other
* All communication should go through the controller
* Set the listeners in the components. Controllers act as a central communications switchboard and listens for messages.
*
* Swing10 -  Borders:
*See gui.FormPanel
*
* Swing11 - Text fields and labels
* text fields should have a default size of 10 new JTextField(10);
*
*
* Swing12 - GridBagLayout (see gui.FormPanel)
* Components are added from top left corner
* Main important things to write:
         setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
setting new layout to variable gc opens crapload of methods..


Swing13 - Custom events and Form Submission
VERY COMPLEX. may need extra revision

Swing14 - List boxes


Swing16 - Combo boxes


NEVER IMPORT GUI STUFF INTO THE MODEL PACKAGE
*
* */