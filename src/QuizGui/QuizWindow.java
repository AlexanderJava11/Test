package QuizGui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizWindow extends JFrame implements ActionListener {
    JPanel quizWindow = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    JLabel quizLabel = new JLabel("Quizkampen");

    JButton startButton = new JButton("Starta nytt spel");

    public QuizWindow() {
        setTitle("Quizkampen");
        this.add(quizWindow);
        quizWindow.setLayout(new BorderLayout());
        quizWindow.add(southPanel, BorderLayout.SOUTH);
        quizWindow.add(northPanel, BorderLayout.NORTH);
        quizWindow.add(centerPanel, BorderLayout.CENTER);
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());
        southPanel.setLayout(new FlowLayout());
        southPanel.add(startButton);
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(quizLabel);
        quizLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        quizLabel.setForeground(Color.BLUE);



        setSize(450, 750);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    void main(){}
}
