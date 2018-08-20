package gem.task.tanksgame.server.core;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

@Getter
public class SocketServerCore {

    /*static ServerSocket variable*/
    private static ServerSocket server = null;
    private Socket clientSocket = null;
    private boolean isListen = true;


    /*socket server port on which it will listen*/
    private static int port;

    /*connection id*/
    static int idCounter = 0;

    public SocketServerCore() throws IOException {
        this(8080);
    }

    public SocketServerCore(int port) throws IOException {
        this.port = port;

        /*Creates the socket*/
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Error creating socket: " + e.getMessage());
            e.printStackTrace();
            throw (e);
        }
        startServer();
    }

    private void startServer() {
        /*Listen to client*/
        while (isListen) {
            try {
                clientSocket = server.accept();
                ClientConnHandler clientThread = new ClientConnHandler(clientSocket, idCounter++);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
