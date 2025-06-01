import java.awt.*;

public class Scoreboard {
    private Player player1, player2;
    private int currentRally = 0;
    private int highestRally = 0;

    public Scoreboard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setRallyData(int current, int highest) {
        this.currentRally = current;
        this.highestRally = highest;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Player 1: " + player1.getScore(), 20, 30);
        g.drawString("Player 2: " + player2.getScore(), 600, 30);
    }
}