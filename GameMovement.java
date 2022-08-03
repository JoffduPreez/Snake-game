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
    public static String direction = "not set";
    public static int snakeLength = 5;

    public void initializeGame (JLabel[][] grid, LinkedList<SnakeNode> snake) {
        snake.addFirst(new SnakeNode(2, 10));
        snake.addFirst(new SnakeNode(3, 10));
        snake.addFirst(new SnakeNode(4, 10));
        snake.addFirst(new SnakeNode(5, 10));
        snake.addFirst(new SnakeNode(6, 10));

        grid[10][2].setBackground(Color.red);
        grid[10][3].setBackground(Color.red);
        grid[10][4].setBackground(Color.red);
        grid[10][5].setBackground(Color.red);
        grid[10][6].setBackground(Color.red);
    
        GameMovement.moveSnake(grid, snake);
    }

    public static void checkGameOver (JLabel[][] grid, SnakeNode node) {
        // check if it hit board boundries
        if (node.x >= 20 || node.x <= 0) {
            System.out.println("game over");
        }
        if (node.y >= 20 || node.y <= 0) {
            System.out.println("game over");
        }

        if (grid[node.y][node.x].getBackground() == Color.red) {
            System.out.println("game over");
        }
    }

    public static void moveSnake (JLabel[][] grid, LinkedList<SnakeNode> snake) {
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            int x1, y1, x2, y2, x3, y3;
            
            @Override
            public void run() {
                SnakeNode node;
                SnakeNode node1;
                SnakeNode node2;

                if (GameMovement.direction != "not set") {
                    node = snake.getFirst();
                    node1 = node; // save location 1
                    x1 = node1.x; 
                    y1 = node1.y;

                    if (GameMovement.direction == "north") {
                        grid[node.y][node.x].setBackground(Color.white);
                        node.y--;
                        snake.set(0, node);
                        node = snake.getFirst();
                        grid[node.y][node.x].setBackground(Color.red);
                    } else if (GameMovement.direction == "east") {
                        grid[node.y][node.x].setBackground(Color.white);
                        node.x++;

                        GameMovement.checkGameOver(grid, node);
                        snake.set(0, node);
                        node = snake.getFirst();
                        grid[node.y][node.x].setBackground(Color.red);
                    } else if (GameMovement.direction == "south") {
                        grid[node.y][node.x].setBackground(Color.white);
                        node.y++;
                        snake.set(0, node);
                        node = snake.getFirst();
                        grid[node.y][node.x].setBackground(Color.red);
                    } else if (GameMovement.direction == "west") {
                        grid[node.y][node.x].setBackground(Color.white);
                        node.x--;
                        snake.set(0, node);
                        node = snake.getFirst();
                        grid[node.y][node.x].setBackground(Color.red);
                    }
                    
                    int i, j;
                    i = 1;
                    j = 2;
                    while (i < GameMovement.snakeLength && j < GameMovement.snakeLength) {
                        node2 = snake.get(i);
                        x2 = node2.x;
                        y2 = node2.y;
    
                        node2.x = x1;
                        node2.y = y1; 
                        snake.set(i, node2);
                        if (i == GameMovement.snakeLength - 1) {
                            grid[y2][x2].setBackground(Color.white);
                        }
                        grid[y1][x1].setBackground(Color.red);
    
    
                        
                        node1 = snake.get(j);
                        x1 = node1.x;
                        y1 = node1.y;
    
                        node1.x = x2;
                        node1.y = y2; 
                        snake.set(j, node1);
                        if (j == GameMovement.snakeLength - 1) {
                            grid[y1][x1].setBackground(Color.white);
                        }
                        grid[y2][x2].setBackground(Color.red);

                        i += 2;
                        j += 2;
                    }
                }
            }
        };
        
        timer.schedule(myTask, 0, 150);
    }
}
