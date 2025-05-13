import static utils.Constants.*;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private double vx;
    private double vy;

    public Ball() {
        super(BALL_IMAGE_PATH, 0, 0, BALL_SIZE, BALL_SIZE);
        reset();
    }

    public void reset() {
        // Reset the ball's position to the center
        pos.setLocation(BOARD_WIDTH / 2 - BALL_SIZE / 2, BOARD_HEIGHT / 2 - BALL_SIZE / 2);

        // Assign random direction to the ball (up-left, up-right, down-left, down-right)
        Random rand = new Random();
        vx = rand.nextBoolean() ? 1 : -1; // Random horizontal direction (1 or -1)
        vy = rand.nextBoolean() ? 1 : -1; // Random vertical direction (1 or -1)

        // Set random speed
        vx *= BALL_SPEED;
        vy *= BALL_SPEED;
    }

    @Override
    public void tick() {
        // Update the ball's position based on velocity
        pos.translate((int)vx, (int)vy);

        // Ball collision with top/bottom walls
        if (pos.y <= 0 || pos.y + size.height >= BOARD_HEIGHT) {
            vy *= -1; // Reverse vertical direction
        }
    }
}