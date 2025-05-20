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

    // Cooldown to avoid multiple rally increments per paddle collision
    private boolean paddleCollisionCooldown = false;

    public Main() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Initialize players, ball, scoreboard, and walls
        player1 = new Player(10, 250, KeyEvent.VK_W, KeyEvent.VK_S);
        player2 = new Player(770, 250, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ball = new Ball();
        scoreboard = new Scoreboard(player1, player2);
        topWall = new Wall(0, 0, 800, 20);
        bottomWall = new Wall(0, 580, 800, 20);

        // Add key listener to handle paddle controls
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player1.keyPressed(e);
                player2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player1.keyReleased(e);
                player2.keyReleased(e);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
        topWall.draw(g);
        bottomWall.draw(g);

        scoreboard.draw(g);

        // Optionally display rally info on screen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Current Rally: " + currentRally, 20, 60);
        g.drawString("Highest Rally: " + highestRally, 20, 90);
    }

    public void update() {
        ball.update();
        player1.update();
        player2.update();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), Ball.SIZE, Ball.SIZE);
        Rectangle topWallRect = new Rectangle(topWall.getX(), topWall.getY(), topWall.getWidth(), topWall.getHeight());
        Rectangle bottomWallRect = new Rectangle(bottomWall.getX(), bottomWall.getY(), bottomWall.getWidth(), bottomWall.getHeight());

        // Ball-wall collision
        if (ballRect.intersects(topWallRect) || ballRect.intersects(bottomWallRect)) {
            ball.reverseVerticalDirection();
        }

        // Ball-paddle collision
        boolean collidedWithPaddle = false;
        if (ball.collidesWith(player1.getPaddle())) {
            ball.reverseHorizontalDirection();
            collidedWithPaddle = true;
        } else if (ball.collidesWith(player2.getPaddle())) {
            ball.reverseHorizontalDirection();
            collidedWithPaddle = true;
        }

        if (collidedWithPaddle && !paddleCollisionCooldown) {
            currentRally++;
            ball.increaseSpeed();
            paddleCollisionCooldown = true;
        }

        // Reset cooldown when ball is no longer colliding with paddles
        if (!ball.collidesWith(player1.getPaddle()) && !ball.collidesWith(player2.getPaddle())) {
            paddleCollisionCooldown = false;
        }

        // Ball out of bounds (scoring)
        if (ball.getX() <= 0) {
            player2.incrementScore();
            resetGame();
        } else if (ball.getX() >= getWidth()) {
            player1.incrementScore();
            resetGame();
        }

        // Update highest rally
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
        player1 = new Player(10, 250, KeyEvent.VK_W, KeyEvent.VK_S);
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