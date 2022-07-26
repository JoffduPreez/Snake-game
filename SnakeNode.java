import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/*
 * this class represents each block of the snake
 */

public class SnakeNode {
    public int x;
    public int y;

    public SnakeNode (int xCoordinate, int yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
    }
}
