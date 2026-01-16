package nave2d.model;

import java.awt.*;

public class Tiro {
    private int x, y;
    private final int velocidade = 8;

    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        y -= velocidade;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 4, 10);
    }

    public int getY() {
        return y;
    }
}
