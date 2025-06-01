import java.awt.*;
import javax.swing.ImageIcon;

public class Wall {
    private int x, y, width, height;
    private Image wallImage;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        wallImage = new ImageIcon(getClass().getResource("/wall.png")).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(wallImage, x, y, width, height, null);
    }

    // Getter methods for collision detection
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}