package QuizGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizWindow extends JFrame implements ActionListener {
    JPanel quizWindow = new JPanel(new BorderLayout());
    JPanel southPanel = new JPanel(new FlowLayout());
    JPanel northPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new BorderLayout());

    JLabel quizLabel = new JLabel("Quizkampen");
    JButton startButton = new JButton("Starta nytt spel");

    private final String imagePath;

    public QuizWindow(String title, String bild) {
        super(title);
        this.imagePath = bild;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 750);
        setLocationRelativeTo(null);

        // NORTH
        quizLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        quizLabel.setForeground(Color.BLUE);
        northPanel.add(quizLabel);

        // CENTER (startinnehåll)
        showWelcomeCenter();

        // SOUTH (startknapp)
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        startButton.addActionListener(this);
        southPanel.add(startButton);

        // sätt ihop
        quizWindow.add(northPanel, BorderLayout.NORTH);
        quizWindow.add(centerPanel, BorderLayout.CENTER);
        quizWindow.add(southPanel, BorderLayout.SOUTH);
        add(quizWindow);
    }

    private void showWelcomeCenter() {
        centerPanel.removeAll();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(80, 160, 220));
        panel.setBorder(BorderFactory.createLineBorder(new Color(30, 100, 160), 6));
        JLabel Q = new JLabel("Q");
        Q.setFont(Q.getFont().deriveFont(Font.BOLD, 64f));
        Q.setForeground(Color.WHITE);
        panel.add(Q);
        centerPanel.add(panel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void showGameCenter() {
        centerPanel.removeAll();

        JPanel gamePanel = new JPanel(new BorderLayout());
        gamePanel.setBackground(Color.WHITE);

        // använd HTML för radbrytning i JLabel
        JLabel message = new JLabel("<html><center>Spelet är igång!<br>Här kan du lägga frågor senare.</center></html>", SwingConstants.CENTER);
        message.setFont(message.getFont().deriveFont(18f));
        gamePanel.add(message, BorderLayout.CENTER);

        // Tillbaka-knapp
        JButton back = new JButton("Tillbaka");
        back.addActionListener(e -> showWelcomeCenter());
        JPanel south = new JPanel(new FlowLayout());
        south.add(back);
        gamePanel.add(south, BorderLayout.SOUTH);

        centerPanel.add(gamePanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            showGameCenter();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizWindow w = new QuizWindow("Quizkampen", "/QuizGui/img.png");
            w.setVisible(true);
        });
    }
}
