package main;

import javax.swing.*;

public class GameWindow extends JFrame {

   public GameWindow (GamePanel gamePanel){ // PASS GAME PANEL AS A PARAMATER
    JFrame jFrame = new JFrame();
     jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.add(gamePanel);// ADDS THE GAME PANEL INSIDE THE FRAME
    jFrame.setLocationRelativeTo(null);
    jFrame.setResizable(false);
    jFrame.pack();//FIT SIZE OF THE WINDOW TO THE PREFERRED SIZE OF ITS COMPONENT AKA SETPANELSIZE() METHOD
    jFrame.setVisible(true);
}
    }
