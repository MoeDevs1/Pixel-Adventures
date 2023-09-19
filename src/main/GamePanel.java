package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int xDelta = 110, yDelta = 100;
    private MouseInputs mouseInputs; // SINGLE INSTANCE TO ENSURE MOUSE LISTENER AND MOUSE MOTION LISTENER SHARE THE SAME STATE AND BEHAVIOR
    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this)); // INITIALIZING THE KEYBOARD INPUT HANDLER WITH A REFERENCE TO THE CURRENT INSTANCE OF GAMEPANEL ALLOWING IT TO DIRECTLY MODIFY GAMEPANEL'S PROPERTIES BASED ON KEYBOARD INPUTS
        addMouseListener( mouseInputs);
        addMouseMotionListener(mouseInputs);


    }

    public void changeYDelta(int value){
        this.yDelta += value;
        repaint(); // Goes back to paintComponent to repaint new values
    }
    public void changeXDelta(int value){// CHANGE THE RECTANGLE POSITION WITH KEYS
        this.xDelta += value;
        repaint();
    }

    public void changeRectPos(int x, int y){ // CHANGE THE RECTANGLE POSITION WITH MOUSE
        this.xDelta = x;
        this.yDelta = y;
        repaint();

    }

     public void paintComponent(Graphics g) {  // ALLOWS US TO DRAW. ITS NEVER CALLED DIRECTLY IS STARTS WHEN THE GAME STARTS.
        super.paintComponent(g);// CALLS JCOMPONENT SUPER CLASS TO CLEAN THE SURFACE, FIX GLITCHES, REMOVE PREVIOUS IMG, ETC.

        g.fillRect(  xDelta,  yDelta, 200, 50);

    }
}
