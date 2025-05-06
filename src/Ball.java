import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;

    public Ball() {
        super(BALL_IMAGE_PATH, 0, 0, BALL_SIZE, BALL_SIZE);
        reset();
    }

    public void reset() {
        // Move the ball to the center of the screen
        // Look at how this is done to Wall in Board.java for inspiration

        // Reset the ball's velocity
        // It should randomly move up left, up right, down left, or down right
        // At first, make it move in one direction and add randomness later
    }

    @Override
    public void tick() {
        // Move the ball based on vx and vy
        // Look at Player.java for inspiration
    }
}

