package gem.task.tanksgame.client.objects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class GameObject {

    protected int posX, posY, width, height, placingPrioryty;

    abstract public void render (Graphics g);
}
