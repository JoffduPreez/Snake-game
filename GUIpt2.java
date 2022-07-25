import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GUIpt2 extends JPanel implements ActionListener, KeyListener {
    Timer tm = new Timer(5, this);
    int x = 0, velX = 1, y = 0, velY = 1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);

        // tm.start();
    }

    public static void main(String[] args) {
        GUIpt2 gameBoard = new GUIpt2();
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // frame.setLayout(null);
        frame.add(gameBoard);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += velX;
        // y += velY;
        repaint();
    }
    
}
