package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client{

    public static void main (String[] args) throws IOException{

        Scanner intScanner = new Scanner(System.in);


        System.out.println("Client is Trying to connect to the server...");
        
        Socket socket = new Socket("127.0.0.1",1234);
        System.out.println("Client is connected to the server !");

        DataOutputStream STS = new DataOutputStream(socket.getOutputStream());
        DataInputStream RFS = new DataInputStream(socket.getInputStream());
        Integer x = 0;
        int cont = 1;

        while(cont == 1){
            System.out.println("================== MULYIPLY BY 5 =====================");
            System.out.print("Enter a number to be sent to the server :");
            x = intScanner.nextInt();

            STS.writeInt(x);
            Integer product = RFS.readInt();

            System.out.println("The product of the number sent = "+product);

            System.out.print("Do you want to continue (1:yes/0:no) : ");
            cont = intScanner.nextInt();
            STS.writeInt(cont);
            System.out.println("=======================================================");

        }
        socket.close();
        intScanner.close();
    }
    
}
