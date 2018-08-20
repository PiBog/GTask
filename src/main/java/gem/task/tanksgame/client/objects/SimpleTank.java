package gem.task.tanksgame.client.objects;

import java.awt.*;

public class SimpleTank extends Machine implements Movable {


    public SimpleTank(int xPos, int yPos) {
        setPositionX(xPos);
        setPositionY(yPos);
        this.setArmor(5);
        this.setFirePower(2);
        this.setSpeed(3);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0xff0000ff));
        g.fillRect(getPositionX(), getPositionY(), 40, 40);
    }
}
