package snake;

import java.awt.Color;

import javax.swing.JFrame;

public class Game extends JFrame {
    private final static int WIDTH = 700, HEIGHT = 460;
    private SnakePanel panel;

    public Game() {
        setSize(WIDTH, HEIGHT);
        setTitle("Snake");
        setBackground(Color.WHITE);
        
        setResizable(false);
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new SnakePanel(this);
        add(panel);
        addKeyListener(panel);
    }

    public SnakePanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.panel.start();
    }
}