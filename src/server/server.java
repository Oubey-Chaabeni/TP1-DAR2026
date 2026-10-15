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
            Integer x  = RFC.readInt();
            String op  = RFC.readUTF();
            Integer y = RFC.readInt();
            double result = 0;

            switch (op) {
                case "+":
                    result = x+y;
                    break;
                case "-":
                    result = x-y;
                    break;
                case "*":
                    result = x*y;
                    break;
                case "/":
                    result = x/y;
                    break;
                default:
                    break;
            }

            System.out.println("Client sent The operation "+ x +" "+ op+ " " + y + " Doing the necessairy calculations...");

            STC.writeDouble(result);

            System.out.println(result+" Has been sent to the client as a result.");

            cont = RFC.readInt();

        }

        serversocket.close();
        socket.close();
    }
}
