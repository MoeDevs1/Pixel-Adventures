package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

    }

     public void paintComponent(Graphics g) {  // ALLOWS US TO DRAW. ITS NEVER CALLED DIRECTLY IS STARTS WHEN THE GAME STARTS.
        super.paintComponent(g);// CALLS JCOMPONENT SUPER CLASS TO CLEAN THE SURFACE ELSE GLITCHES, PREVIOUS IMG, ETC.

        g.fillRect(100, 100, 200, 50);

    }
}
