package QuizGui;

import javax.swing.*;
import java.awt.*;

public class MainMenu {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }

    public MainMenu() {
        JFrame frame = new JFrame("Quizkampen - Huvudmeny");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Bakgrundspanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0xF3F4F6));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Titel
        JLabel title = new JLabel("QUIZKAMPEN");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel subtitle = new JLabel("Huvudmeny");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(10));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(40));

        // Knapp: Starta spel
        JButton btnStart = new JButton("Starta spelet");
        styleButton(btnStart);

        btnStart.addActionListener(e ->
                JOptionPane.showMessageDialog(frame,
                        "Här startar spelet.\n(Koppla spelet hit när det är klart.)")
        );

        // Slumpmässig spelare knapp (nu utan funktion)
        JButton btnRandomPlayer = new JButton("Slumpmässig spelare");
        styleButton(btnRandomPlayer);

        btnRandomPlayer.addActionListener(e ->
                JOptionPane.showMessageDialog(frame,
                        "Här kommer du få välja slumpmässiga personer.")
        );

        // Knapp: Inställningar
        JButton btnSettings = new JButton("Inställningar");
        styleButton(btnSettings);

        btnSettings.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Inställningsmenyn kommer här!")
        );

        // Knapp: Avsluta
        JButton btnExit = new JButton("Avsluta");
        styleButton(btnExit);
        btnExit.addActionListener(e -> System.exit(0));

        // Lägg till alla knappar
        panel.add(btnStart);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnRandomPlayer);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnSettings);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnExit);

        frame.add(panel, BorderLayout.CENTER);

        JLabel credits = new JLabel("Gjordes av: Den ljusblåa gruppen - Alexander, Alessandro, Boris, Daniel och Emil Drougge");
        credits.setFont(new Font("Arial", Font.PLAIN, 12));
        credits.setForeground(Color.DARK_GRAY);

        JPanel creditPanel = new JPanel(new BorderLayout());
        creditPanel.setBackground(new Color(0xF3F4F6));
        creditPanel.add(credits, BorderLayout.EAST);
        creditPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        frame.add(creditPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // Styling för knappar
    private void styleButton(JButton button) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBackground(new Color(0x3B82F6));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(260, 50));
        button.setMaximumSize(new Dimension(260, 50));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
