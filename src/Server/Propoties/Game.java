package Server.Propoties;

import java.util.Scanner;

// Klassen Game hanterar spelets logik
public class Game {

    // Inställningar hämtade från Properties
    private final GameConfig config;

    // Spelet får sin konfiguration när det skapas
    public Game(GameConfig config) {
        this.config = config;
    }

    // Startar spelet och visar antal ronder och frågor
    public void start() {
        System.out.println("Startar spel med " + config.getRoundsPerGame() + " ronder och "
                + config.getQuestionsPerRound() + " frågor per rond.");

        // ---EXEMPEL SPEL---

        Scanner scanner = new Scanner(System.in);
        int totalPoäng = 0;

        for (int rond = 1; rond <= config.getRoundsPerGame(); rond++) {
            System.out.println("\n--- Rond " + rond + " ---");

            for (int fråga = 1; fråga <= config.getQuestionsPerRound(); fråga++) {

                System.out.println("Fråga " + fråga + ": Vad är 2 + 2?");
                System.out.print("Svar: ");
                String input = scanner.nextLine().trim();

                if (input.equals("4")) {
                    System.out.println("Rätt!");
                    totalPoäng++;
                } else {
                    System.out.println("Fel, rätt svar är 4.");
                }
            }
        }

        System.out.println("\nSpelet är slut!");
        System.out.println("Du fick totalt " + totalPoäng + " poäng.");
    }
}
