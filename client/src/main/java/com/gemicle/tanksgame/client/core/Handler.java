/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.common.objects.GameObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.awt.*;
import java.util.LinkedList;

@Log4j
@Getter
@Setter
public class Handler  {

    private Connector connector;

    public static LinkedList<GameObject> objects = new LinkedList<>();


    public Handler() {
    }


    public void addObj(GameObject machine) {
        objects.add(machine);
    }

    public void render(Graphics g){
        for (int i=0; i< objects.size(); i++){
            objects.get(i).render(g);
        }
    }

    public void handleAction(String keyCode){
        log.info("handle action");
         getConnector().sendMsg(keyCode);
    }


}
