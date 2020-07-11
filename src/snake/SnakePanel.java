package snake;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {
    private Game game;
    private Snake snake;
    private Food food;
    private int score;

    public SnakePanel(Game game) {
        setBackground(Color.BLACK);
        this.game = game;
        food = new Food(game);
        snake = new Snake(game);
        
        addKeyListener(this);
        setFocusable(true);
    }
    
    public void start() {
        Timer timer = new Timer(100, this);
        timer.start();
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public Food getFood() {
        return food;
    }

    private void update() {
        food.update();
        snake.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        snake.pressed(e.getKeyCode());
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Score: "+game.getPanel().getScore(), game.getWidth() / 2, 10);
        food.paint(g);
        snake.paint(g);
    }
}