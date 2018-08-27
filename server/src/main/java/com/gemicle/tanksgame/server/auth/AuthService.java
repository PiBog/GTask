/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.auth;


import com.gemicle.tanksgame.server.frontend.Player;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;

/**
 * Interface for working with subscribers of {@code AuthService} type
 * inside messaging system
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public interface AuthService extends Subscriber {

    Player auth(String name, String password);

}
