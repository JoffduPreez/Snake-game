import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;

public class GUI implements KeyListener {
    public JFrame frame = new JFrame();
    public JLabel label = new JLabel();


    public static void main(String[] args) {
        GUI gameBoard = new GUI();
    }


    GUI () {
        frame.setSize(800, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		frame.setLayout(null);
        frame.addKeyListener(this);

        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);

        frame.add(label);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
        switch(e.getKeyCode()) {
            case 37: label.setLocation(label.getX()-10, label.getY());
            break;
            case 38: label.setLocation(label.getX(), label.getY()-10);
            break;
            case 39: label.setLocation(label.getX()+10, label.getY());
            break;
            case 40: label.setLocation(label.getX(), label.getY()+10);
            break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        switch(e.getKeyChar()) {
            case 'a': label.setLocation(label.getX()-10, label.getY());
            break;
            case 'w': label.setLocation(label.getX(), label.getY()-10);
            break;
            case 's': label.setLocation(label.getX(), label.getY()+10);
            break;
            case 'd': label.setLocation(label.getX()+10, label.getY());
            break;
        }
    }
}

