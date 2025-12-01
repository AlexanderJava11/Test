package ClientMap;

import Server.ServerProtokoll;

import Server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
// testar
public class Client {

    public Client() {

        InetAddress ip;

        try {
            ip = InetAddress.getLocalHost(); // ska ändras till getByName i skolan
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try(Socket socketToServer = new Socket(ip, 8999);
            ObjectOutputStream ous = new ObjectOutputStream(socketToServer.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socketToServer.getInputStream());) {

            Scanner sc = new Scanner(System.in);

            Object fromServer;
            Object fromClient;


            while((fromServer = ois.readObject()) != null) {

                if(fromServer.equals("Runda Slut")){
                    System.out.println("Server : " + fromServer);
                    break;
                }

                System.out.println("Server : " + fromServer);

                fromClient = sc.nextLine();
                if (fromClient != null) {

                    ous.writeObject(fromClient);
                    ous.flush();

                }

                ous.flush();


            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void main(){

    }
}
