/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.Unit;
import com.gemicle.tanksgame.common.objects.weapons.Bullet;
import com.gemicle.tanksgame.common.objects.weapons.CrazyBullet;
import com.gemicle.tanksgame.server.config.Settings;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
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
     * It will use for counting of speed the game units.
     */
    private long timeStamp;

    public Game() {

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

    }

    public void processAction(@NotNull Player player, String command) {
        try {
            if (command.equalsIgnoreCase("fire")) {
                makeFire(player);
            } else {
                tryMovePlayer(player, getDirection(command));
            }
        } catch (IllegalArgumentException e) {
            log.error(e);
        }
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
                throw new IllegalArgumentException("*****Unknown command!***** <" + command + ">");
        }
    }

    /**
     * Method create new object Bullet and adds to current game scene
     */
    private void makeFire(Player player) {
        Unit tmpTank = gameSession.getPlayersTank(player);
        Optional.ofNullable(creatBullet(tmpTank))
                .ifPresent(gameSession::addBullet);

    }

    private Bullet creatBullet(Unit tank) {
        Direction tankDirection = tank.getDirection();
        int dX = 0;
        int dY = 0;
        if (tankDirection == Direction.NORD) {
            dX = 15;
            dY = -10;
        } else if (tankDirection == Direction.EAST) {
            dX = 40;
            dY = 15;
        } else if (tankDirection == Direction.SOUTH) {
            dX = 15;
            dY = 40;
        } else if (tankDirection == Direction.WEST) {
            dX = -10;
            dY = 15;
        } else return null;
        return new CrazyBullet(tank.getPosX() + dX, tank.getPosY() + dY, tankDirection);
    }

    private void tryMovePlayer(Player player, Direction newDirection) {
        Unit unit = gameSession.getPlayersTank(player);
        if (unit.getDirection() == newDirection) {
            gameSession.updPlayersTank(player, moveUnit(unit));
        } else {
            gameSession.updPlayersTank(player, turnUnit(unit, newDirection));
        }
    }

    private static Unit moveUnit(Unit playerUnit) {
        Unit unit = playerUnit;
        log.info("move unit");
        return unit;
    }

    private static Unit turnUnit(Unit playerUnit, Direction direction) {
        Unit unit = playerUnit;
        unit.setDirection(direction);
        return unit;
    }

}
