/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.controls;

import com.gemicle.tanksgame.client.core.Handler;
import com.gemicle.tanksgame.common.objects.units.Machine;
import lombok.extern.log4j.Log4j;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Log4j
public class Keyboard extends KeyAdapter {

    public Handler handler;

    public Keyboard(Handler handler) {
        this.handler = handler;
        log.info("kb active");
    }

    @Override
    public void keyPressed(KeyEvent event) {
        for (int i = 0; i < Handler.objects.size(); i++) {
            if (Handler.objects.get(i) instanceof Machine) {
                Machine temp = (Machine) Handler.objects.get(i);
                int keyCode = event.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_W:
                        log.info(keyCode + " W pressed");
                        temp.moveY(-1);
                        handler.handleAction("W pressed");
                        break;
                    case KeyEvent.VK_S:
                        temp.moveY(1);
                        handler.handleAction("S pressed");
                        break;
                    case KeyEvent.VK_A:
                        temp.moveX(-1);
                        handler.handleAction("A pressed");
                        break;
                    case KeyEvent.VK_D:
                        temp.moveX(1);
                        handler.handleAction("D pressed");
                        break;
                    case KeyEvent.VK_SPACE:
                        temp.fire();
                        handler.handleAction("Space pressed");
                        break;
                    default:
                        break;
                }
            }
        }
    }


}
