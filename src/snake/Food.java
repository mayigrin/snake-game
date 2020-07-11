package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Food {
    private static final int WIDTH = 20, HEIGHT = 20;
    private Game game;
    private int x, y;

    public Food(Game game) {
        this.game = game;
        this.randomizePosition();
    }
    
    public void randomizePosition() {
        this.x = (int)(Math.random() * (game.getWidth()/WIDTH - 1))*WIDTH;
        this.y = (int)(Math.random() * (game.getHeight()/HEIGHT - 1))*HEIGHT;
    }

    public void update() {
        ;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}