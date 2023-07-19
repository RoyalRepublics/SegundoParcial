
package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
class Paddle {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int upKey;
    private int downKey;
    private boolean upPressed;
    private boolean downPressed;
    private boolean isAIEnabled;
    private double aiDifficulty;
    public Paddle(int x, int y, int width, int height, Color color, int upKey, int downKey) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.upKey = upKey;
        this.downKey = downKey;
        this.upPressed = false;
        this.downPressed = false;
        this.isAIEnabled = false;
        this.aiDifficulty = 1.0;
    }

    public void setAIDifficulty(double difficulty) {
        this.aiDifficulty = difficulty;
    }

    public void setAIEnabled(boolean enabled) {
        isAIEnabled = enabled;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == upKey) {
            upPressed = true;
        }
        if (e.getKeyCode() == downKey) {
            downPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == upKey) {
            upPressed = false;
        }
        if (e.getKeyCode() == downKey) {
            downPressed = false;
        }
    }
public void update(int ballY) {
    if (isAIEnabled) {
        // Lógica del movimiento del jugador automático
        if (y + height / 2 < ballY && y + height < Pong.HEIGHT) {
            y += Pong.paddleSpeed;
        } else if (y + height / 2 > ballY && y > 0) {
            y -= Pong.paddleSpeed;
        }
    } else {
        // Lógica del movimiento controlado por teclas
        if (upPressed && y > 0) {
            y -= Pong.paddleSpeed;
        }
        if (downPressed && y + height < Pong.HEIGHT) {
            y += Pong.paddleSpeed;
        }
    }
}

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void reset() {
        y = Pong.HEIGHT / 2 - height / 2;
    }
}