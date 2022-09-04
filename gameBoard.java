import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;
import java.util.Timer;

/*
 * This class is for the GUI, it contains all the visual components of the game
 */

public class GameBoard implements KeyListener {
    public LinkedList<SnakeNode> snake = new LinkedList<SnakeNode>();
    
    public JFrame frame = new JFrame();
    
    public JPanel gridPanel = new JPanel();
    public JLabel[][] grid = new JLabel[20][20];

    public JPanel titlePanel = new JPanel();
    public JLabel titleField = new JLabel();
    public JLabel msgField = new JLabel();

    public static boolean initializeGame = false;
    public static boolean foodExists = false;
    public static int rand1 = 0;
    public static int rand2 = 0;


    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        GameMovement controller = new GameMovement();
        GameBoard.initializeGame = true;
        boolean runGame = true;

        while (true) {
            controller.initializeGame(board.grid, board.snake);
            board.msgField.setText("Direct snake to start game");
            runGame = true;
            while (runGame) {
                if (controller.moveSnake(board.grid, board.snake, board.msgField)) { // if game is over
                    runGame = false;
                    board.msgField.setText("Game over");
    
                    // wait 2 seconds before reseting game
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Sleep Exception:");
                        e.printStackTrace();
                    }
    
                    controller.resetGame(board.titleField, board.msgField, board.grid, board.snake);
                } else {
                    // delay loop restart by 150 ms
                    try {
                        Thread.sleep(125);
                    } catch (InterruptedException e) {
                        System.out.println("Sleep Exception:");
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public GameBoard () {
        frame.setSize(600, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.black);
        frame.getContentPane().setBackground(Color.BLACK);

		titleField.setBackground(Color.black);
		titleField.setForeground(Color.white);
		titleField.setFont(new Font("Ink Free",Font.BOLD,75));
		titleField.setHorizontalAlignment(JLabel.CENTER);
		titleField.setText("Snake Game");
		titleField.setOpaque(true);

        msgField.setBackground(Color.black);
		msgField.setForeground(Color.white);
		msgField.setFont(new Font("Ink Free",Font.BOLD,35));
		msgField.setHorizontalAlignment(JLabel.CENTER);
		msgField.setText("Direct snake to start game");
		msgField.setOpaque(true);

        titlePanel.setLayout(new GridLayout(2,1));
        titlePanel.setBounds(0,0,600,150);
        titlePanel.add(titleField);
        titlePanel.add(msgField);

        gridPanel.setLayout(new GridLayout(20, 20));
        gridPanel.setBounds(0,150,600,600);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setOpaque(true);
                grid[i][j].setBackground(Color.black);
                gridPanel.add(grid[i][j]);
            }
        }

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(gridPanel);
        frame.setVisible(true);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
    }


    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
        // System.out.println("You released key char: " + e.getKeyChar());
        // System.out.println("You released key code: " + e.getKeyCode());
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        if (GameMovement.direction == "north" || GameMovement.direction == "not set") {
            if (e.getKeyChar() == 'a') {
                GameMovement.direction = "west";
            }
            if (e.getKeyChar() == 'd') {
                GameMovement.direction = "east";
            }
        } else if (GameMovement.direction == "east" || GameMovement.direction == "not set") {
            if (e.getKeyChar() == 'w') {
                GameMovement.direction = "north";
            }
            if (e.getKeyChar() == 's') {
                GameMovement.direction = "south";
            }
        } else if (GameMovement.direction == "south" || GameMovement.direction == "not set") {
            if (e.getKeyChar() == 'a') {
                GameMovement.direction = "west";
            }
            if (e.getKeyChar() == 'd') {
                GameMovement.direction = "east";
            }
        } else if (GameMovement.direction == "west" || GameMovement.direction == "not set") {
            if (e.getKeyChar() == 'w') {
                GameMovement.direction = "north";
            }
            if (e.getKeyChar() == 's') {
                GameMovement.direction = "south";
            }
        }

        // System.out.println(GameMovement.direction);
    }
}

