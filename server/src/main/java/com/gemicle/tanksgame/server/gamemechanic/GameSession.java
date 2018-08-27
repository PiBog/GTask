/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.landscape.RebirthPlace;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import com.gemicle.tanksgame.server.frontend.Player;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static AtomicInteger counter = new AtomicInteger();

    public static final int MAX_ACTIVE_PLAYERS = 4;

    private final int sessionId;
    private final Map<Player, SimpleTank> activePlayers;

    public GameSession() {
        this.activePlayers = new HashMap<>(MAX_ACTIVE_PLAYERS);
        sessionId = counter.getAndIncrement();
    }

    public boolean canStart() {
        if (activePlayers.size() < 2) {
            return false;
        } else return true;
    }

    public boolean addPlayer(Player player) {
        if (this.getActivePlayers().size() > 4) {
            return false;
        }
        this.getActivePlayers().put(player, new SimpleTank(applyPosition()));
        return true;
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
}
