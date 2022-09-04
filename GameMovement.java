import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.LineBorder;

/*
 * This class contain the methodes used to control the snake linked list
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

        grid[10][2].setBackground(Color.blue);
        grid[10][3].setBackground(Color.blue);
        grid[10][4].setBackground(Color.blue);
        grid[10][5].setBackground(Color.blue);
        grid[10][6].setBackground(Color.blue);
        
        GameMovement.direction = "not set";
    }

    public void resetGame (JLabel titleField, JLabel msgField, JLabel[][] grid, LinkedList<SnakeNode> snake) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[i][j].setBackground(Color.black);
            }
        }

        snake.clear();
        GameBoard.foodExists = false;
        GameMovement.snakeLength = 5;
    }

    public static boolean checkGameOver (JLabel[][] grid, SnakeNode node) {
        boolean gameOver = false;
        // check if it hit board boundries
        if (node.x == 19 || node.x == 0) {
            gameOver = true;
        }
        if (node.y == 19 || node.y == 0) {
            gameOver = true;
        }

        if (grid[node.y][node.x].getBackground() == Color.blue) {
            gameOver = true;
        }

        // System.out.println("gameover = " + gameOver);
        return gameOver;
    }

    public boolean moveSnake (JLabel[][] grid, LinkedList<SnakeNode> snake, JLabel msgField) {
        SnakeNode node;
        SnakeNode node1;
        SnakeNode node2;
        int x1, y1, x2, y2;
        boolean gameOver = false;
        boolean hitFood = false;
        int max = 18;
        int min = 1;
        int range = max - min + 1;

        // if food doesnt exist, add food
        if (!GameBoard.foodExists) {
            GameBoard.rand1 = (int)(Math.random() * range) + min;
            GameBoard.rand2 = (int)(Math.random() * range) + min;
            grid[GameBoard.rand1][GameBoard.rand2].setBackground(Color.red);
            GameBoard.foodExists = true;
        }

        if (GameMovement.direction != "not set") {
            node = snake.getFirst();
            node1 = node; // save location 1
            x1 = node1.x; 
            y1 = node1.y;
            msgField.setText("Score: " + GameMovement.snakeLength);

            if (GameMovement.direction == "north") {
                grid[node.y][node.x].setBackground(Color.black);
                node.y--;
                gameOver = GameMovement.checkGameOver(grid, node);

                // check if we hit food
                if (node.y == GameBoard.rand1 && node.x == GameBoard.rand2) {
                    hitFood = true;
                }
                
                snake.set(0, node);
                node = snake.getFirst();
                grid[node.y][node.x].setBackground(Color.blue);
            } else if (GameMovement.direction == "east") {
                grid[node.y][node.x].setBackground(Color.black);
                node.x++;
                gameOver = GameMovement.checkGameOver(grid, node);
                
                // check if we hit food
                if (node.y == GameBoard.rand1 && node.x == GameBoard.rand2) {
                    hitFood = true;
                }
                
                snake.set(0, node);
                node = snake.getFirst();
                grid[node.y][node.x].setBackground(Color.blue);
            } else if (GameMovement.direction == "south") {
                grid[node.y][node.x].setBackground(Color.black);
                node.y++;
                gameOver = GameMovement.checkGameOver(grid, node);
                
                // check if we hit food
                if (node.y == GameBoard.rand1 && node.x == GameBoard.rand2) {
                    hitFood = true;
                }
                
                snake.set(0, node);
                node = snake.getFirst();
                grid[node.y][node.x].setBackground(Color.blue);
            } else if (GameMovement.direction == "west") {
                grid[node.y][node.x].setBackground(Color.black);
                node.x--;
                gameOver = GameMovement.checkGameOver(grid, node);
                
                // check if we hit food
                if (node.y == GameBoard.rand1 && node.x == GameBoard.rand2) {
                    hitFood = true;
                }
                
                snake.set(0, node);
                node = snake.getFirst();
                grid[node.y][node.x].setBackground(Color.blue);
            }
            
            // this basically updates the rest of the snake once the head moves
            int i, j;
            i = 1;
            j = 2;
            while (i < GameMovement.snakeLength || j < GameMovement.snakeLength) {
                node2 = snake.get(i);
                x2 = node2.x;
                y2 = node2.y;

                node2.x = x1;
                node2.y = y1; 
                snake.set(i, node2);
                if (i == GameMovement.snakeLength - 1) {
                    if (hitFood) {
                        // add a new node to the snake. New node will be at position [y1][x1]
                        snake.addLast(new SnakeNode(y1, x1));
                        GameBoard.foodExists = false;
                        GameMovement.snakeLength++;
                        hitFood = false;
                    } else {
                        grid[y2][x2].setBackground(Color.black);
                    }
                }
                grid[y1][x1].setBackground(Color.blue);


                if (j < GameMovement.snakeLength) {
                    node1 = snake.get(j);
                    x1 = node1.x;
                    y1 = node1.y;
    
                    node1.x = x2;
                    node1.y = y2; 
                    snake.set(j, node1);
                    if (j == GameMovement.snakeLength - 1) {
                        if (hitFood) {
                            // add a new node to the snake. New node will be at position [y2][x2]
                            snake.addLast(new SnakeNode(y2, x2));
                            GameBoard.foodExists = false;
                            GameMovement.snakeLength++;
                            hitFood = false;
                        } else {
                            grid[y1][x1].setBackground(Color.black);
                        }
                    }
                    grid[y2][x2].setBackground(Color.blue);
                }

                i += 2;
                j += 2;

                // if the boolean saying we hit food is set to true, then set the previous position of the last node to blue, create a new node in the snake with the x/y of the previous position of the last node, and increment snake length
                // if (hitFood) {
                //     foodExists = false;
                //     snake.addLast(new SnakeNode(2, 10));
                // }
            }
        }

        return gameOver;
    }
}
