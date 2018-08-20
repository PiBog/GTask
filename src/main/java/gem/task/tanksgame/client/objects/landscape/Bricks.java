package gem.task.tanksgame.client.objects.landscape;

import java.awt.*;

public class Bricks extends WallMaterial {

    public Bricks(int xPos, int yPos, int width, int height) {
        this.setPosX(xPos);
        this.setPosY(yPos);
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(getPosX(),getPosY(),getWidth(),getHeight());
    }
}
