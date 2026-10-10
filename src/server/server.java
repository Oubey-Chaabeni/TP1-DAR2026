package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    
    public static void main (String[] args) throws IOException{

        ServerSocket serversocket = new ServerSocket(1234);
        System.out.println("Socket is online. Waiting fort clients on port 1234...");

        Socket socket = serversocket.accept();
        System.out.println("Client is finally connected ! ");

        serversocket.close();
        socket.close();
    }
}
