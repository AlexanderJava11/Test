package QuizGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuizStart extends JPanel {
    public QuizStart(String titleText, String buttonText, ActionListener button) {
        setLayout(new BorderLayout());
        setBackground(new Color(190, 230, 255));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel(titleText, SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        add(title, BorderLayout.NORTH);

        add(blueQ(), BorderLayout.CENTER);

        JButton btn = new JButton(buttonText);
        btn.addActionListener(button);
        JPanel south = new JPanel();
        south.setBackground(getBackground());
        south.add(btn);
        add(south, BorderLayout.SOUTH);
    }

    private JPanel blueQ() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(80, 160, 220));
        panel.setPreferredSize(new Dimension(120, 120));
        JLabel Q = new JLabel("Q");
        Q.setFont(Q.getFont().deriveFont(Font.BOLD, 64f));
        Q.setForeground(Color.white);
        panel.add(Q);
        panel.setBorder(BorderFactory.createLineBorder(new Color(30, 100, 160), 6));
        return panel;
    }
}
