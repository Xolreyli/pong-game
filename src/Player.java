import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
    private int score;
    private Paddle paddle;
    private int upKey, downKey;

    public Player(int x, int paddleY, int upKey, int downKey) {
        this.score = 0;
        this.paddle = new Paddle(x, paddleY, upKey, downKey);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void update() {
        paddle.update();
    }

    public void draw(Graphics g) {
        paddle.draw(g);
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        paddle.keyReleased(e);
    }

    public void resetScore() {
        score = 0;
    }
}
