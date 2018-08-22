package com.gemicle.tanksgame.client.controls;

import com.gemicle.tanksgame.client.core.Handler;
import com.gemicle.tanksgame.common.objects.units.Machine;
import org.apache.log4j.Logger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    public Handler handler;

    public Keyboard(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        for (int i = 0; i < handler.getObjList().size(); i++) {
            if (handler.getObjList().get(i) instanceof Machine) {
                Machine temp = (Machine) handler.getObjList().get(i);
                int keyCode = event.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_W:
                        temp.moveY(-1);
//                        handler.sendKeyAction(event);
                        break;
                    case KeyEvent.VK_S:
                        temp.moveY(1);
                        break;
                    case KeyEvent.VK_A:
                        temp.moveX(-1);
                        break;
                    case KeyEvent.VK_D:
                        temp.moveX(1);
                        break;
                    default:
                        break;
                }
            }
        }
    }


}
