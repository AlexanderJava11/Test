package Server.Propoties;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Hämtar sökvägen
        String path = System.getenv("GAME_PROPERTIES_PATH");

        // Använder utav min egna standard sökväg
        path = (path == null || path.isBlank())
                ? "src\\Server\\Propoties\\config\\game.properties"
                : path;

        // Gör om sökvägen till ett Path objekt.
        Path paths = Paths.get(path).toAbsolutePath();

        // Visa vilken fil programmet försöker läsa.
        System.out.println("Sökväg som programmet försöker läsa: " + paths);

        // Kontrollera om filen finns.
        System.out.println("Finns filen? " + Files.exists(paths));

        // Om filen finns: skriv ut innehållet rad för rad.
        if (Files.exists(paths)) {
            try {
                List<String> lines = Files.readAllLines(paths);
                System.out.println("\n--- Innehåll i filen (radnummer : text) ---");

                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + ": " + lines.get(i));
                }

                System.out.println("--- slut på filen ---\n");

            } catch (IOException e) {
                System.out.println("Kunde inte läsa filens innehåll: " + e.getMessage());
            }

        } else {
            // Om filen saknas.
            System.out.println("Filen finns inte (programmet kan skapa en default om du kör PropertiesLoader).");
        }

        // Läs in inställningarna från properties-filen.
        GameConfig config = PropertiesLoader.loadFromPath(path);

        // Starta spelet med inställningarna.
        Game game = new Game(config);
        game.start();
    }
}