package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SnakeSquare {
    private int x, y, size;

    public SnakeSquare(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void update() {
        ;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }
    
    public String toString() {
        return "("+x+", "+y+")";
    }
}