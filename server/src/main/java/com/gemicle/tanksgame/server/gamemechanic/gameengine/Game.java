/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.game.Player;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.units.Unit;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.weapons.Bullet;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.weapons.CrazyBullet;
import com.gemicle.tanksgame.server.config.Settings;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * A class responsible for the game process. It contains game session.
 * Starts game, makes calculation and iterations.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
@Setter
public class Game {

    /**
     * Field contains information about current game session
     */
    private GameSession gameSession;

    /**
     * Mark if game is active;
     */
    private boolean isActive = false;

    /**
     * Field contains information about end time of previous iteration.
     * It will use for counting of speed of game units.
     */
    private long timeStamp;

    public Game() {

    }

    /**
     * Values in this method had been calculated experimentally based on the
     * objects size 40x40px for units and walls  and 10x10px for bullets.
     * One pixel multiplies to 1000.
     *
     * @param playerUnit witch try fire
     * @return new instance of bullet
     */
    @Nullable
    private Bullet createBullet(@NotNull Unit playerUnit) {
        Direction tankDirection = playerUnit.getDirection();
        int dX = 0;
        int dY = 0;
        if (tankDirection == Direction.NORD) {
            dX = 15000;
            dY = -10000;
        } else if (tankDirection == Direction.EAST) {
            dX = 40000;
            dY = 15000;
        } else if (tankDirection == Direction.SOUTH) {
            dX = 15000;
            dY = 40000;
        } else if (tankDirection == Direction.WEST) {
            dX = -10000;
            dY = 15000;
        } else return null;
        return new CrazyBullet(playerUnit.getPosX() / 1000 + dX,
                playerUnit.getPosY() / 1000 + dY, tankDirection);
    }

    private Unit tryMovePlayer(Unit playerUnit, Direction newDirection) {
        Unit updUnit;
        if (isSameDirection(playerUnit, newDirection)) {
            updUnit = moveUnit(playerUnit);
        } else {
            updUnit = turnUnit(playerUnit, newDirection);
        }
        return updUnit;
    }

    /**
     * May be in future needs to compare radial moving or moving in 3D area
     */
    private boolean isSameDirection(@NotNull Unit unit, Direction direction) {
        return unit.getDirection() == direction;
    }

    private Unit turnUnit(Unit playerUnit, Direction direction) {
        Unit updUnit = playerUnit;
        updUnit.setDirection(direction);
        return updUnit;
    }

    private Unit moveUnit(Unit playerUnit) {

        log.info("move unit");
        long timescale = Instant.now().toEpochMilli() - this.timeStamp;
        int maxDistance = playerUnit.getSpeed() * (int) timescale / 1000;
        int xShift = playerUnit.getPosX() + maxDistance * playerUnit.getDirection().getDX();
        int yShift = playerUnit.getPosY() + maxDistance * playerUnit.getDirection().getDY();

        Unit updUnit = playerUnit.of(xShift, yShift);

        int minDistance = maxDistance;

        List<GameObject> list = gameSession.getAllGameObjects();

        for (GameObject item : list) {
            if (playerUnit != item) {
                if (GameRulesAsserts.isIntersecting(updUnit, item)) {
                    if(GameRulesAsserts.checkIsCollision(updUnit, item)){
                        int distanceX = Math.abs(playerUnit.getPosX()-item.getPosX())
                                - playerUnit.getSize()*Math.abs(playerUnit.getDirection().getDX());
                        int distanceY = Math.abs(playerUnit.getPosY()-item.getPosY())
                                - playerUnit.getSize()*Math.abs(playerUnit.getDirection().getDY());
                        
                    }
                }
            }

        }


        return updUnit;

    }


    private HashMap<ID, LinkedList<GameObject>> loadLandscape() throws FileNotFoundException {
        MapFromXmlReader reader = new MapFromXmlReader();
        HashMap<ID, LinkedList<GameObject>> landscape = new HashMap<>();
        landscape.put(ID.WALL, reader.loadMapFromResources(Settings.MAP_LANDSCAPE_FILE_NAME));
        return landscape;
    }

    /**
     * Method creates new game session and start new game
     */
    public void startGame() throws FileNotFoundException {
        this.gameSession = new GameSession(loadLandscape());
        this.isActive = true;
    }

    /**
     * Method count next iteration
     */
    public void countIteration() {


    }

    /**
     * Method creates new game session and start new game
     */
    public void finishGame() {
        int x = 0;
        int speed = 3;

        for (int i = 0; i < 1021; i = i + 25) {
            int dx = (speed * 1000) * 25 / 1000;
            x = x + dx;
            log.info("position = " + (x / 1000) + " " + Instant.now().toEpochMilli());
        }
    }

    public void processAction(@NotNull Player player, String command) {
        Unit playerUnit = gameSession.getPlayersTank(player);
        try {
            if (command.equalsIgnoreCase("fire")) {
                makeFire(playerUnit);
            } else {
                tryMovePlayer(playerUnit, getDirection(command));
            }
        } catch (IllegalArgumentException e) {
            log.error(e);
        }
        gameSession.updPlayersTank(player, playerUnit);
    }

    private Direction getDirection(String command) throws IllegalArgumentException {

        switch (command) {

            case "up":
                return Direction.NORD;
            case "down":
                return Direction.SOUTH;
            case "left":
                return Direction.WEST;
            case "right":
                return Direction.EAST;
            default:
                throw new IllegalArgumentException("*****Unknown command!***** <"
                        + command + ">. Needs to be one of \"up/down/left/right\" in lowercase");
        }
    }

    /**
     * Method create new object Bullet and adds to current game scene
     */
    private void makeFire(Unit playerUnit) {
        Optional.ofNullable(createBullet(playerUnit))
                .ifPresent(gameSession::addBullet);

    }

}
