package Server.Propoties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

// Laddar eller skapar en properties-fil med defaultvärden
public class PropertiesLoader {
    private static final int DEFAULT_QUESTIONS = 1;
    private static final int DEFAULT_ROUNDS = 1;

    // Läser properties från sökväg. Skapar fil med defaults om den saknas.
    public static GameConfig loadFromPath(String pathStr) {
        Path path = Paths.get(pathStr);
        Properties Properties = new Properties();

        // Skapa fil med defaultvärden om den inte finns
        if (!Files.exists(path)) {
            try {
                Path parent = path.getParent();
                if (parent != null && !Files.exists(parent)) {
                    Files.createDirectories(parent);
                    System.out.println("Skapade katalog: " + parent.toAbsolutePath());
                }

                Properties.setProperty("questions.per.round", String.valueOf(DEFAULT_QUESTIONS));
                Properties.setProperty("rounds.per.game", String.valueOf(DEFAULT_ROUNDS));

                try (FileOutputStream out = new FileOutputStream(path.toFile())) {
                    Properties.store(out, "Game properties (default) - redigera efter behov");
                }

                System.out.println("Default properties-fil skapad: " + path.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("Kunde inte skapa default properties-fil: " + e.getMessage());
                System.out.println("Arbetskatalog: " + Paths.get("").toAbsolutePath());
                return new GameConfig(DEFAULT_QUESTIONS, DEFAULT_ROUNDS);
            }
        }

        // Läs värden från filen
        int questions = DEFAULT_QUESTIONS;
        int rounds = DEFAULT_ROUNDS;

        try (FileInputStream in = new FileInputStream(path.toFile())) {
            Properties.load(in);
            String q = Properties.getProperty("questions.per.round");
            String r = Properties.getProperty("rounds.per.game");
            if (q != null) questions = parseOrDefault(q, DEFAULT_QUESTIONS);
            if (r != null) rounds = parseOrDefault(r, DEFAULT_ROUNDS);
        } catch (IOException e) {
            System.out.println("Properties-fil kunde inte läsas, använder defaultvärden: " + path.toAbsolutePath());
            System.out.println("Fel: " + e.getMessage());
            System.out.println("Arbetskatalog: " + Paths.get(" ").toAbsolutePath());
            return new GameConfig(DEFAULT_QUESTIONS, DEFAULT_ROUNDS);
        }

        return new GameConfig(questions, rounds);
    }

    private static int parseOrDefault(String s, int defaultValue) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}