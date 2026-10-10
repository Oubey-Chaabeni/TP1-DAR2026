package client;

import java.io.IOException;
import java.net.Socket;

public class client{

    public static void main (String[] args) throws IOException{

        System.out.println("Client is Trying to connect to the server...");
        
        Socket socket = new Socket("127.0.0.1",1234);
        System.out.println("Client is connected to the server !");

        socket.close();
    }
    
}
