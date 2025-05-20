import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle {
    public static final int WIDTH = 20, HEIGHT = 100;
    private int x, y;
    private int upKey, downKey;
    private boolean movingUp, movingDown;
    private Image paddleImage;

    public Paddle(int x, int y, int upKey, int downKey) {
        this.x = x;
        this.y = y;
        this.upKey = upKey;
        this.downKey = downKey;
        paddleImage = new ImageIcon(getClass().getResource("/paddle.png")).getImage();  // Load the paddle image
    }

    public void update() {
        if (movingUp && y > 0) {
            y -= 5;
        }
        if (movingDown && y < 600 - HEIGHT) {
            y += 5;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(paddleImage, x, y, WIDTH, HEIGHT, null);  // Draw the paddle image
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == upKey) {
            movingUp = true;
        } else if (e.getKeyCode() == downKey) {
            movingDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == upKey) {
            movingUp = false;
        } else if (e.getKeyCode() == downKey) {
            movingDown = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset() {
        y = 250; // Reset paddles to center position
    }
}
