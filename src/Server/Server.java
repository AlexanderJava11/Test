package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {

    Socket s;

    static List<Server> waitingList = new ArrayList<>();

    public void findMatch() {
        synchronized (waitingList) {
            if (waitingList.isEmpty()) {
                waitingList.add(this);
                System.out.println("La till " + this);
            } else {
                Server you = this;
                Server opponent = waitingList.remove(0);
                System.out.println("2 motståndare kopplade");
                System.out.println(you + " vs " + opponent);
            }
        }
    }

    public Server(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        try (
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(s.getInputStream())
        ) {

            Object input;
            Object output;
            ServerProtokoll serverProtokoll = new ServerProtokoll();
            output = serverProtokoll.gameLogic(null);
            out.writeObject(output);
            out.flush();

            //out.writeObject("Välkommen till Quiz" + "\n" + "Välj Kategori\n" + questionsDatabase.getRandomQuestions(Category.DJUR, 1).toString());

            while ((input = inFromClient.readObject()) != null) {
                System.out.println("Server received: " + input);

                output = serverProtokoll.gameLogic(input);
                out.writeObject(output);
                out.flush();

                // eventuellt bye satsen

               /* if (input.toString().toLowerCase().equals("start")) {
                    findMatch();
                    out.writeObject("Söker motståndare");
                }

                if (input.equals(Integer.toString(questionsDatabase.getCorrectIndex()))) {
                    out.writeObject("Korrekt");
                if (input.toString().equals(Integer.toString(questionsDatabase.getCorrectIndex()))) {

                   out.writeObject("Korrekt");
                   out.writeObject(serverProtokoll.gameLogic());


                } else {
                    out.writeObject("Inkorrekt");
                    try {
                        out.writeObject(serverProtokoll.gameLogic());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }*/

            }
            } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }

