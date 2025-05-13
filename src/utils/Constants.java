package utils;

public final class Constants {
    private Constants() {
        // prevents instantiation
    }

    // Board constants
    public static final int BOARD_WIDTH = 640;
    public static final int BOARD_HEIGHT = 480;
    public static final int TICK_DELAY = 25; // 45 FPS

    // Player constants
    public static final String PLAYER_IMAGE_PATH = "resources/amogus.png";
    public static final int PLAYER_WIDTH = 60;
    public static final int PLAYER_HEIGHT = 80;
    public static final int PLAYER_SPEED = 10;

    // Wall constants
    public static final String WALL_IMAGE_PATH = "resources/wall.png";
    public static final int WALL_WIDTH = 150;
    public static final int WALL_HEIGHT = 150;

    // Ball constants
    public static final String BALL_IMAGE_PATH = "resources/ball.png";
    public static final int BALL_SIZE = 20;
    public static final double BALL_SPEED = 5.0; // Adjust ball speed

    // Paddle constants
    public static final String PADDLE_IMAGE_PATH = "resources/paddle.png";
    public static final int PADDLE_WIDTH = 15;
    public static final int PADDLE_HEIGHT = 80;
    public static final int PADDLE_SPEED = 8; // Adjust paddle speed

    // Rally constants
    public static final int MAX_SCORE = 11; // Winning score for the match
}
