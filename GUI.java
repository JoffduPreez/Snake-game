import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;

public class GUI implements KeyListener {
    public JFrame frame = new JFrame();
    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();


    public static void main(String[] args) {
        GUI gameBoard = new GUI();
    }


    GUI () {
        frame.setSize(800, 800);
        frame.getContentPane().setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		frame.setLayout(null);
        frame.addKeyListener(this);

        label.setBounds(0, 0, 50, 50);
        label.setBackground(Color.red);
        label.setOpaque(true);

        panel.setBounds(100, 100, 400, 400);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(null);
        panel.add(label);

        frame.add(panel);
        // frame.add(label);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
        // System.out.println(label.getY());
        if (e.getKeyCode() == 37 && label.getX() > 0) {
            label.setLocation(label.getX()-10, label.getY());
        }
        if (e.getKeyCode() == 38 && label.getY() > 0) {
            label.setLocation(label.getX(), label.getY()-10);
        }
        if (e.getKeyCode() == 39 && label.getX() < 350) {
            label.setLocation(label.getX()+10, label.getY());
        }
        if (e.getKeyCode() == 40 && label.getY() < 350) {
            label.setLocation(label.getX(), label.getY()+10);
        }
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
        if (e.getKeyChar() == 'a' && label.getX() > 0) {
            label.setLocation(label.getX()-10, label.getY());
        }
        if (e.getKeyChar() == 'w' && label.getY() > 0) {
            label.setLocation(label.getX(), label.getY()-10);
        }
        if (e.getKeyChar() == 's' && label.getY() < 350) {
            label.setLocation(label.getX(), label.getY()+10);
        }
        if (e.getKeyChar() == 'd' && label.getX() < 350) {
            label.setLocation(label.getX()+10, label.getY());
        }
    }
}

