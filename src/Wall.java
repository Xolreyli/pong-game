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
}
