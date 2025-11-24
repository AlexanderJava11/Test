package Server;



import Category_Question.Category;
import Category_Question.QuestionsDatabase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket serverSocket;


    public Server() throws IOException {
        this.serverSocket = new ServerSocket(8888);
    }

    @Override
    public void run() {

        try (
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream())
        ) {

            QuestionsDatabase questionsDatabase = new QuestionsDatabase();
            Object input;
            Object output; // ska hämta frågorna från protokoll/databas
            out.flush();
            out.writeObject("Välkommen till Quiz" + "\n" + "Välj Kategori\n" + questionsDatabase.getRandomQuestions(Category.DJUR, 1).toString());
            out.flush();



            while ((input = inFromClient.readObject()) != null) {
                System.out.println("Server received: " + input);

                if (input.equals(Integer.toString(questionsDatabase.getCorrectIndex()))) {
                    out.writeObject("Korrekt");
                } else {
                    out.writeObject("Inkorrekt");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void main() throws IOException {

        Server server = new Server();
        server.start();
    }
}

