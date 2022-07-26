import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.LineBorder;

/*
 * This class contain the methodes used to controll the snake linked list
 */

public class GameMovement {
    public static String direction = "east";

    public void initializeGame (JLabel[][] grid, LinkedList<SnakeNode> snake) {
        snake.addFirst(new SnakeNode(10, 2));
        snake.addFirst(new SnakeNode(10, 3));
        snake.addFirst(new SnakeNode(10, 4));
        snake.addFirst(new SnakeNode(10, 5));
        snake.addFirst(new SnakeNode(10, 6));

        grid[10][2].setBackground(Color.red);
        grid[10][3].setBackground(Color.red);
        grid[10][4].setBackground(Color.red);
        grid[10][5].setBackground(Color.red);
        grid[10][6].setBackground(Color.red);
    }

    public static void moveSnake (JLabel[][] grid, LinkedList<SnakeNode> snake) {
        SnakeNode node = snake.getFirst();
        System.out.println(node.x + ", " + node.y);

        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("noice");
            }
        };
        
        timer.schedule(myTask, 0, 500);
    }
}
