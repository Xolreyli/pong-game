import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Ball {
    public static final int SIZE = 20;
    private int x, y, xSpeed, ySpeed;
    private Image ballImage;

    public Ball() {
        reset();
        ballImage = new ImageIcon(getClass().getResource("/ball.png")).getImage();
    }

    public void reset() {
        x = 390;
        y = 290;
        Random rand = new Random();
        xSpeed = rand.nextInt(2) == 0 ? 4 : -4;
        ySpeed = rand.nextInt(2) == 0 ? 4 : -4;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
    }

    public void draw(Graphics g) {
        g.drawImage(ballImage, x, y, SIZE, SIZE, null);
    }

    public void reverseVerticalDirection() {
        ySpeed = -ySpeed;
    }

    public void reverseHorizontalDirection() {
        xSpeed = -xSpeed;
    }

    public void increaseSpeed() {
        if (xSpeed > 0) xSpeed++;
        else xSpeed--;
    }

    public boolean collidesWith(Paddle paddle) {
        return x + SIZE >= paddle.getX() && x <= paddle.getX() + Paddle.WIDTH && y + SIZE >= paddle.getY() && y <= paddle.getY() + Paddle.HEIGHT;
    }

    public void stop() {
        xSpeed = 0;
        ySpeed = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXSpeed(int speed) {
        this.xSpeed = speed;
    }

    public void setYSpeed(int speed) {
        this.ySpeed = speed;
    }
}