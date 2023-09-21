package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel; // Declaring a reference to the GamePanel instance
    private Thread gameThread;


    private int frames = 0;
    private final int FPS_SET = 120;

    public Game (){

        gamePanel = new GamePanel();

        gameWindow = new GameWindow(gamePanel); // Creating a new GameWindow instance with the provided GamePanel
        gamePanel.requestFocus();// GIVE THE GAME PANEL INPUT FOCUS TO MOVE ETC.
        startGameLoop();

     }


    private void startGameLoop() {
        // CREATING A NEW THREAD OBJECT AND ASSIGNING IT TO gameThread.
        // "this" REFERS TO THE CURRENT INSTANCE OF THE Game CLASS WHICH IMPLEMENTS THE RUNNABLE INTERFACE,
        // MEANING IT HAS A run METHOD THAT DEFINES THE CODE TO BE EXECUTED IN THE NEW THREAD.
        gameThread = new Thread(this);

        // STARTING THE NEW THREAD, WHICH WILL CAUSE THE run METHOD OF THE CURRENT Game INSTANCE
        // (SPECIFIED BY "this") TO BE CALLED IN THAT NEW THREAD, INITIATING THE GAME LOOP.
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1_000_000_000.0 / FPS_SET; // 1/120
        long lastFrame = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true){ // AN INFINITE LOOP, WHICH WILL KEEP RUNNING AS LONG AS THE THREAD EXECUTING THE LOOP

            if (System.nanoTime() - lastFrame >= timePerFrame){ // CHECK IF ENOUGH TIME HAS ELAPSED TO RENDER THE NEXT FRAME (Has 8.33 million nanoseconds (or more) passed since we drew the last frame?"
                lastFrame = System.nanoTime();
                gamePanel.repaint(); // CALLS THE PAINT COMPONENT

                frames++;

            }
            if (System.currentTimeMillis() - lastCheck >= 1000) { // CHECK IF A SECOND HAS PASSED TO REPORT THE FPS
                System.out.println("Fps: " + frames);

                lastCheck = System.currentTimeMillis();

                frames = 0;

            }
        }

    }
}
