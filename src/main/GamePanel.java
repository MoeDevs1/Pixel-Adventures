package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private float xDelta = 0, yDelta = 0;// STARTING POSTION OF REC
    private float xDir = 0.003f, yDir = 0.003f;
    private long lastCheck = 0;
    private int frames = 0;
    private Color color = new Color(21, 102, 222);
    private Random random;


    private MouseInputs mouseInputs; // SINGLE INSTANCE TO ENSURE MOUSE LISTENER AND MOUSE MOTION LISTENER SHARE THE SAME STATE AND BEHAVIOR

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this)); // INITIALIZING THE KEYBOARD INPUT HANDLER WITH A REFERENCE TO THE CURRENT INSTANCE OF GAMEPANEL ALLOWING IT TO DIRECTLY MODIFY GAMEPANEL'S PROPERTIES BASED ON KEYBOARD INPUTS
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }


    public void changeYDelta(int value) {

        this.yDelta += value;

    }

    public void changeXDelta(int value) {// CHANGE THE RECTANGLE POSITION WITH KEYS

        this.xDelta += value;

    }

    public void changeRectPos(int x, int y) { // CHANGE THE RECTANGLE POSITION WITH MOUSE

        this.xDelta = x;
        this.yDelta = y;

    }

    public void paintComponent(Graphics g) {  // ALLOWS US TO DRAW. ITS NEVER CALLED DIRECTLY IS STARTS WHEN THE GAME STARTS.
        super.paintComponent(g);// CALLS JCOMPONENT SUPER CLASS TO CLEAN THE SURFACE, FIX GLITCHES, REMOVE PREVIOUS IMG, ETC.
        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);
        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("Fps: " + frames);
            frames = 0;

        }

    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndomColor();
        }
        yDelta += yDir;

        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndomColor();

        }


    }

    private Color getRndomColor() {
        int r = random.nextInt(200);
        int g = random.nextInt(200);
        int b = random.nextInt(200);

        return new Color(r, g ,b);

    }


}