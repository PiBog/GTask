package gem.task.tanksgame.client.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Machine {

    /**machine features*/
    private int speed;
    private int armor;
    private int firePower;

    /**current position*/
    private int positionX;
    private int positionY;

}
