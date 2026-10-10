package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    
    public static void main (String[] args) throws IOException{

        ServerSocket serversocket = new ServerSocket(1234);
        System.out.println("Socket is onlin. Waiting fort clients on port 1234...");

        Socket socket = serversocket.accept();
        System.out.println("Client is finally connected ! ");

        DataOutputStream STC = new DataOutputStream(socket.getOutputStream());
        DataInputStream RFC = new DataInputStream(socket.getInputStream());

        int cont = 1;

        while(cont == 1){
            Integer recieved  = RFC.readInt();
            System.out.println("Client sent: "+recieved+"\nCalculating its product by 5...");
            Integer product = recieved * 5 ;

            STC.writeInt(product);

            System.out.println(product+" Has been sent to the client as a result.");

            cont = RFC.readInt();

        }

        serversocket.close();
        socket.close();
    }
}
