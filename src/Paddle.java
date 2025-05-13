import java.awt.*;
import java.util.Set;

import static utils.Constants.*;

public class Paddle {
    private final int upKey;
    private final int downKey;
    private double dy; // Vertical speed for the paddle
    private Rectangle pos; // Paddle position

    public Paddle(int upKey, int downKey, int x) {
        this.upKey = upKey;
        this.downKey = downKey;
        this.pos = new Rectangle(x, BOARD_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void handleActiveKeys(Set<Integer> activeKeys) {
        dy = 0;

        // Handle movement based on key input
        if (activeKeys.contains(upKey)) {
            dy -= PADDLE_SPEED;
        }
        if (activeKeys.contains(downKey)) {
            dy += PADDLE_SPEED;
        }
    }

    public void tick() {
        pos.y += (int)dy;

        // Prevent the paddle from moving out of bounds
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE_HEIGHT);
    }

    public Rectangle getBounds() {
        return pos;
    }

}

