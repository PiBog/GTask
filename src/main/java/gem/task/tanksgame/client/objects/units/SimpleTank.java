package gem.task.tanksgame.client.objects.units;

import java.awt.*;

public class SimpleTank extends Machine {


    public SimpleTank(int xPos, int yPos) {
        setPosX(xPos);
        setPosY(yPos);
        this.setArmor(5);
        this.setFirePower(2);
        this.setSpeed(3);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getPosX(), getPosY(), 50, 50);
    }
}
