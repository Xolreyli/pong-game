import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main extends JPanel {
    private Ball ball;
    private Player player1, player2;
    private Scoreboard scoreboard;
    private Wall topWall, bottomWall;
    private int currentRally = 0;
    private int highestRally = 0;

    public Main() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Initialize players, ball, scoreboard, and walls
        player1 = new Player(10, 250, 'w', 's');
        player2 = new Player(770, 250, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ball = new Ball();
        scoreboard = new Scoreboard(player1, player2);
        topWall = new Wall(0, 0, 800, 20);  // Top wall
        bottomWall = new Wall(0, 580, 800, 20);  // Bottom wall
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
        topWall.draw(g);
        bottomWall.draw(g);

        scoreboard.draw(g);
    }

    public void update() {
        ball.update();
        player1.update();
        player2.update();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        // Ball-wall collision
        if (ball.getY() <= 0 || ball.getY() >= getHeight() - Ball.SIZE) {
            ball.reverseVerticalDirection();
        }

        // Ball-paddle collision
        if (ball.collidesWith(player1.getPaddle())) {
            ball.reverseHorizontalDirection();
            currentRally++;
            ball.increaseSpeed();
        } else if (ball.collidesWith(player2.getPaddle())) {
            ball.reverseHorizontalDirection();
            currentRally++;
            ball.increaseSpeed();
        }

        // Ball out of bounds (scoring)
        if (ball.getX() <= 0) {
            player2.incrementScore();
            resetGame();
        } else if (ball.getX() >= getWidth()) {
            player1.incrementScore();
            resetGame();
        }

        // Update the highest rally
        if (currentRally > highestRally) {
            highestRally = currentRally;
        }

        // Check for match winner
        if (player1.getScore() == 11 || player2.getScore() == 11) {
            resetMatch();
        }
    }

    private void resetGame() {
        ball.reset();
        player1.getPaddle().reset();
        player2.getPaddle().reset();
        currentRally = 0;
    }

    private void resetMatch() {
        player1 = new Player(10, 250, 'w', 's');
        player2 = new Player(770, 250, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        resetGame();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        Main gamePanel = new Main();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Game loop
        while (true) {
            gamePanel.update();
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
