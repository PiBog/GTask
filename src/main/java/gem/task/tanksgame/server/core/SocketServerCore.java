package gem.task.tanksgame.server.core;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Getter
public class SocketServerCore {

    /*static ServerSocket variable*/
    private static ServerSocket server = null;
    private Socket clientSocket = null;

    /*socket server port on which it will listen*/
    private static int port;

    /*I/O streams*/
    PrintWriter out;
    BufferedReader in;

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

    private void startServer() throws IOException {
        /*Listen to client*/
        clientSocket = server.accept();

        //create the in and out
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        runServer();
    }

    private void runServer() throws IOException {
        String inputLine;
        int outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Input received from " + clientSocket.getRemoteSocketAddress().toString() + ": " + inputLine);
            outputLine = Integer.parseInt(inputLine)+1;
            System.out.println("DATA = "+outputLine);
            out.println(outputLine);
        }

        out.close();
        in.close();
        clientSocket.close();
        server.close();
    }

}
