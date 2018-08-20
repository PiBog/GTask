package gem.task.tanksgame.client.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Machine extends GameObject{

    /**machine features*/
    private int speed;
    private int armor;
    private int firePower;

    /**current position*/
    private int positionX;
    private int positionY;

    public void moveX(int xSpeedDirection){
        int posX = getPositionX();
        setPositionX(posX+xSpeedDirection);
    }
    public void moveY(int ySpeedDirection){
        int posY = getPositionY();
        setPositionY(posY+ySpeedDirection);
    }
}
