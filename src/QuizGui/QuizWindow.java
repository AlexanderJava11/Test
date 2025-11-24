package QuizGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizWindow extends JFrame implements ActionListener {
    JPanel quizWindow = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    JLabel quizLabel = new JLabel("Quizkampen");

    JButton start = new JButton("Starta nytt spel");

    public QuizWindow(String s, String bild) {
        setTitle("Quizkampen");

        this.add(quizWindow);
        quizWindow.setLayout(new BorderLayout());
        quizWindow.add(southPanel, BorderLayout.SOUTH);
        quizWindow.add(northPanel, BorderLayout.NORTH);
        quizWindow.add(centerPanel, BorderLayout.CENTER);




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
