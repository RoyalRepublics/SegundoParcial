package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
class Ball {
    private int x;
    private int y;
    private int width = 20;
    private int height = 20;
    private int dx = 2;
    private int dy = 2;
    private Color color;
    private Random random;

    private int initialX;
    private int initialY;
    private int initialDX;
    private int initialDY;

    public Ball(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.random = new Random();

        this.initialX = x;
        this.initialY = y;
        this.initialDX = dx;
        this.initialDY = dy;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    public void reverseXDirection() {
        dx = -dx;
    }

    public void reverseYDirection() {
        dy = -dy;
    }

    public void reset() {
        x = initialX;
        y = initialY;
        dx = initialDX;
        dy = initialDY;
        randomizeDirection();
    }

    public void increaseSpeed() {
        if (dx > 0) {
            dx++;
        } else {
            dx--;
        }

        if (dy > 0) {
            dy++;
        } else {
            dy--;
        }
    }

    private void randomizeDirection() {
        int direction = random.nextInt(4);

        switch (direction) {
            case 0:
                dx = Math.abs(dx);
                dy = Math.abs(dy);
                break;
            case 1:
                dx = -Math.abs(dx);
                dy = Math.abs(dy);
                break;
            case 2:
                dx = Math.abs(dx);
                dy = -Math.abs(dy);
                break;
            case 3:
                dx = -Math.abs(dx);
                dy = -Math.abs(dy);
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}