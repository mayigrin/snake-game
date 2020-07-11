package snake;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Snake {
    private Game game;
    private int headX;
    private int headY;
    private char dir = 'R';
    private ArrayList<SnakeSquare> body;
    private static final int SQUARE_SIDE = 20;
    

    public Snake(Game game) {
        this.game = game;
        this.headX = 0;
        this.headY = 0;
        this.body = new ArrayList<SnakeSquare>();
        this.addSquare();
    }
    
    public void addSquare() {
        switch(dir) {
            case 'R':
                headX+=SQUARE_SIDE;
                break;
            case 'L':
                headX-=SQUARE_SIDE;
                break;
            case 'U':
                headY-=SQUARE_SIDE;
                break;
            case 'D':
                headY+=SQUARE_SIDE;
                break;
        }
        body.add(new SnakeSquare(headX, headY, SQUARE_SIDE));
        
    }
    
    public void move() {
        
        switch(dir) {
            case 'R':
                headX+=SQUARE_SIDE;
                break;
            case 'L':
                headX-=SQUARE_SIDE;
                break;
            case 'U':
                headY-=SQUARE_SIDE;
                break;
            case 'D':
                headY+=SQUARE_SIDE;
                break;
        }
        body.add(new SnakeSquare(headX, headY, SQUARE_SIDE));
        body.remove(0);
        
    }
    
    public boolean selfCollision() {
        SnakeSquare head = body.get(body.size()-1);
        for ( int i = 0; i < body.size()-1; i++) {
            SnakeSquare square = body.get(i);
            if(square.getBounds().intersects(head.getBounds())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean outOfBounds() {
        Rectangle gameBounds = new Rectangle(0,0,game.getWidth(), game.getHeight());
        SnakeSquare head = this.body.get(body.size()-1);
        if (!gameBounds.contains(head.getBounds())) {
            return true;
        }
        return false;
    }

    public void update() {
        if (checkCollision()) {
            this.game.getPanel().increaseScore();
            this.addSquare();
            this.move();
            this.game.getPanel().getFood().randomizePosition();
        }
        else if(!outOfBounds() && !selfCollision()) {
            this.move();
            if(outOfBounds() || selfCollision()) {
                JOptionPane.showMessageDialog(null, "Game Over\nScore: "+this.game.getPanel().getScore(), "Snake", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Game Over\nScore: "+this.game.getPanel().getScore(), "Snake", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        
    }
    
    public boolean checkCollision() {
        for (SnakeSquare square : body) {
            if(square.getBounds().intersects(this.game.getPanel().getFood().getBounds())) {
                return true;
            }
        }
        return false;
    }

    public void pressed(int keyCode) {
        if (keyCode == KeyEvent.VK_UP)
            dir = 'U';
        if (keyCode == KeyEvent.VK_DOWN)
            dir = 'D';
        if (keyCode == KeyEvent.VK_RIGHT)
            dir = 'R';
        if (keyCode == KeyEvent.VK_LEFT)
            dir = 'L';
           
    }

    public void released(int keyCode) {
        ;
    }

    public void paint(Graphics g) {
        for (SnakeSquare square : body) {
            square.paint(g);
        }
    }
    
    public String toString() {
        return "headX: "+headX + "\nheadX: "+headY+"\ndir: "+dir+"\nbody:"+body;
    }
}