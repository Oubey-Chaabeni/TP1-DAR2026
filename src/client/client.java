package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client{

    public static void main (String[] args) throws IOException{

        Scanner intScanner = new Scanner(System.in);
        Scanner stScanner = new Scanner(System.in);


        System.out.println("Client is Trying to connect to the server...");
        
        Socket socket = new Socket("127.0.0.1",1234);
        System.out.println("Client is connected to the server !");

        DataOutputStream STS = new DataOutputStream(socket.getOutputStream());
        DataInputStream RFS = new DataInputStream(socket.getInputStream());
        int cont = 1;

        while(cont == 1){
            System.out.println("================== CALCULATOR SERVICE =====================");
            //Sending the first number
            System.out.print("Enter the first number to be sent to the server : ");
            Integer x = intScanner.nextInt();
            STS.writeInt(x);

            //Sending the operator
            System.out.print("Enter one of the following operators ( + | - | * | / ): ");
            String op = stScanner.next();
            STS.writeUTF(op);

            //Sending the second number
            System.out.print("Enter the second number to be sent to the server : ");
            Integer y = intScanner.nextInt();
            STS.writeInt(y);


            Double product = RFS.readDouble();

            System.out.println("The result of the sent operation = "+product);
            System.out.println("\n===========================================================");


            System.out.print("\nDo you want to continue (1:yes/0:no) : ");
            cont = intScanner.nextInt();
            STS.writeInt(cont);
        }
        socket.close();
        intScanner.close();
        stScanner.close();
    }
    
}
