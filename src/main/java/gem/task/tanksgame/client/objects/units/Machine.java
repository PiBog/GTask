package gem.task.tanksgame.client.objects.units;

import gem.task.tanksgame.client.objects.GameObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Machine extends GameObject {

    /**machine features*/
    private int speed;
    private int armor;
    private int firePower;



    public void moveX(int direction){
        int posX = this.getPosX();
        int newPosX = posX+this.getSpeed()*direction;
        this.setPosX(newPosX);
    }
    public void moveY(int direction){
        int posY = this.getPosY();
        int newPosY = posY+this.getSpeed()*direction;
        this.setPosY(newPosY);
    }


}
