/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.EntryPoint;
import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.common.objects.units.AverageJoe;
import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.Unit;
import com.gemicle.tanksgame.common.objects.weapons.Bullet;
import com.gemicle.tanksgame.common.objects.weapons.CrazyBullet;
import com.sun.istack.internal.NotNull;
import lombok.extern.log4j.Log4j;

import java.util.*;

/**
 * Class contains information about active game session,
 * and methods for working with game objects
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j

public class GameSession {


    private final HashMap<Player, Unit> activePlayers;
    private final HashMap<ID, LinkedList<GameObject>> gameObjects;

    public GameSession(HashMap<ID, LinkedList<GameObject>> map) {
        this.gameObjects = map;
        this.gameObjects.put(ID.BULLET, new LinkedList<>());
        this.activePlayers = new HashMap<>();
    }

    /**
     * Method return game unit for concrete player
     *
     * @param player whose unit will be returned
     * @return player's unit(tank)
     */
    public Unit getPlayersTank(Player player) {
        return activePlayers.get(player);
    }

    /**
     * Method updates information about player's unit
     *
     * @param player whose unit is updating
     * @param unit   which is being update
     */
    public void updPlayersTank(Player player, Unit unit) {
        activePlayers.put(player, unit);
    }

    /**
     * Method adds new player to game and create new unit for him
     *
     * @param player who will appended to game
     */
    public void addNewPlayer(Player player) {
        Unit tank = new AverageJoe(EntryPoint.getRndLocation());
        this.activePlayers.put(player, tank);
        log.info("player: <" + player + "> connected to game with unit: <" + tank + ">");
    }

    /**
     * Method adds new bullet to game scene after fire
     *
     * @param bullet recently fired
     */
    public void addBullet(Bullet bullet) {
        gameObjects.get(ID.BULLET).add(bullet);
    }

    /**
     * Method return list with all game object placed on the field
     *
     * @return arrayList with all objects
     */
    public List<GameObject> getAllGameObjects() {
        List<GameObject> gameObjectList = new ArrayList<>();
        gameObjectList.addAll(Optional
                .ofNullable(activePlayers.values())
                .orElse(new LinkedList<>()));
        gameObjectList.addAll(Optional
                .ofNullable(gameObjects.get(ID.WALL))
                .orElse(new LinkedList<>()));
        gameObjectList.addAll(Optional
                .ofNullable(gameObjects.get(ID.BULLET))
                .orElse(new LinkedList<>()));
        log.info("packed " + gameObjectList.size() + " objects");
        return gameObjectList;
    }


    /**
     * Method checks game session and deletes disconnected players
     *
     * @param players - set of connected players
     */
    public void updatePlayers(Set<Player> players) {

        List<Player> tmpPlayersList = new ArrayList<>(this.activePlayers.keySet());
        for (Player item : tmpPlayersList) {
            if (!players.contains(item)) {
                activePlayers.remove(item);
            }
        }
    }


}
