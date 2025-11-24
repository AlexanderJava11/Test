package ClientMap;

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

        try(Socket socketToServer = new Socket(ip, 8888)) {

            ObjectOutputStream ous = new ObjectOutputStream(socketToServer.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socketToServer.getInputStream());

            Scanner sc = new Scanner(System.in);

            Object obj;

            while((obj = ois.readObject()) != null) {
                System.out.println(obj);
                String input = sc.nextLine();
                ous.writeObject(input);
                ous.flush();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void main(){

    }
}
