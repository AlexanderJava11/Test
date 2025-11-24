package QuizGui;

import javax.swing.*;

public class QuizApp {
    public static final String BILD = "/QuizGui/img.png";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizWindow w = new QuizWindow("Quizkampen", BILD);
            w.setVisible(true);
        });
    }
}
