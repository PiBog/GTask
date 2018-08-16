package gem.task.tanksgame.server;

import gem.task.tanksgame.server.core.SocketServerCore;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TanksgameApplicationServer {
    private static final Logger logger = Logger.getLogger(TanksgameApplicationServer.class.getName());

    public static void main(String[] args) throws IOException {

        System.out.println("Starting socket server ...");
        SocketServerCore server = new SocketServerCore(8888);

        System.out.println("Server shutdown");
    }


}
