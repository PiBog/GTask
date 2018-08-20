package gem.task.tanksgame.client.controls;

import gem.task.tanksgame.client.core.Handler;
import gem.task.tanksgame.client.objects.GameObject;
import gem.task.tanksgame.client.objects.Machine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    public Handler handler;
    public int xPos = 0, yPos = 0;

    public Keyboard(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        for (int i = 0; i < handler.getObjList().size(); i++) {
            Machine temp = handler.getObjList().get(i);
            int keyCode = event.getKeyCode();
            int speed = temp.getSpeed();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    yPos = -speed;
                    break;
                case KeyEvent.VK_S:
                    yPos = speed;
                    break;
                case KeyEvent.VK_A:
                    xPos = -speed;
                    break;
                case KeyEvent.VK_D:
                    xPos = speed;
                    break;
                default:
                    break;
            }
            temp.moveX(xPos);
            temp.moveY(yPos);
        }
    }
}
