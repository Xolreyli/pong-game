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
        wallImage = new ImageIcon("wall.png").getImage();  // Load the wall image
    }

    public void draw(Graphics g) {
        g.drawImage(wallImage, x, y, width, height, null);  // Draw the wall image
    }
}
