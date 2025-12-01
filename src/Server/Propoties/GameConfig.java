package Server.Propoties;

// Spelets inställningar (antal frågor och ronder)
public class GameConfig {

    // Hur många frågor per Rond
    private final int questionsPerRound;

    // Hur många ronder spelet har
    private final int roundsPerGame;

    // Tar emot inställningarna nör objektet skapas
    public GameConfig(int questionsPerRound, int roundsPerGame) {
        this.questionsPerRound = questionsPerRound;
        this.roundsPerGame = roundsPerGame;
    }

    // Hämtar antal frågor per rond
    public int getQuestionsPerRound() { return questionsPerRound; }

    // Hämtar antal ronder i spelet
    public int getRoundsPerGame() { return roundsPerGame; }
}
