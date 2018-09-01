/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.landscape.RebirthPlace;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import com.gemicle.tanksgame.common.objects.game.Player;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class contains information about active game session
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class GameSession {

//    public static AtomicInteger counter = new AtomicInteger();

    public static final int MAX_ACTIVE_PLAYERS = 4;

    //    private final int sessionId;
    private final HashMap<Player, SimpleTank> activePlayers;

    public GameSession() {
        this.activePlayers = new HashMap<>();
//        sessionId = counter.getAndIncrement();
    }

    public boolean canStart() {
        if (activePlayers.size() < 2) {
            return false;
        } else return true;
    }

    public void addPlayer(Player player) {
        this.activePlayers.put(player, new SimpleTank(RebirthPlace.FIRST));
    }

    private RebirthPlace applyPosition() {
        RebirthPlace position = null;
        switch (activePlayers.size()) {
            case 0:
                position = RebirthPlace.FIRST;
                break;
            case 1:
                position = RebirthPlace.SECOND;
                break;
            case 2:
                position = RebirthPlace.THIRD;
                break;
            case 3:
                position = RebirthPlace.FOURTH;
                break;

        }
        return position;
    }

    void toDoAction(Player player, String command) {

        SimpleTank tmpTank = activePlayers.get(player);
        int location;
        switch (command) {

            case "up":
                tmpTank.setPosY(tmpTank.getPosY() - tmpTank.getSpeed());
                activePlayers.put(player, tmpTank);
                break;
            case "down":
                tmpTank.setPosY(tmpTank.getPosY() + tmpTank.getSpeed());
                activePlayers.put(player, tmpTank);
                break;
            case "left":
                tmpTank.setPosX(tmpTank.getPosX() - tmpTank.getSpeed());
                activePlayers.put(player, tmpTank);
                break;
            case "right":
                tmpTank.setPosX(tmpTank.getPosX() + tmpTank.getSpeed());
                activePlayers.put(player, tmpTank);
                break;
        }


    }

}
