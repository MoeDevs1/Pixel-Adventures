package main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel; // Declaring a reference to the GamePanel instance

    public Game (){
        gamePanel = new GamePanel();

        gameWindow = new GameWindow(gamePanel); // Creating a new GameWindow instance with the provided GamePanel

     }
 }
