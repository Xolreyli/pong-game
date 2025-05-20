package utils;

import java.awt.event.KeyEvent;

public class Constants {

    // Screen Dimensions
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    // Ball Constants
    public static final int BALL_SIZE = 20;
    public static final int BALL_INITIAL_SPEED_X = 4;
    public static final int BALL_INITIAL_SPEED_Y = 4;

    // Paddle Constants
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 100;
    public static final int PADDLE_SPEED = 5;

    // Wall Constants
    public static final int WALL_HEIGHT = 20; // For both top and bottom walls
    public static final int WALL_WIDTH = SCREEN_WIDTH;  // Full screen width for top and bottom walls

    // Score Constants
    public static final int WINNING_SCORE = 11;

    // Rally Counter Constants
    public static final int MAX_RALLY_DISPLAY = 1000; // Optional max rally display if you choose to store it

    // FPS (frames per second) Constants
    public static final int FPS = 60;  // Game updates at ~60 FPS

    // Paddle Movement Keys
    public static final int PLAYER_1_UP_KEY = 'w';
    public static final int PLAYER_1_DOWN_KEY = 's';
    public static final int PLAYER_2_UP_KEY = KeyEvent.VK_UP;
    public static final int PLAYER_2_DOWN_KEY = KeyEvent.VK_DOWN;

}
