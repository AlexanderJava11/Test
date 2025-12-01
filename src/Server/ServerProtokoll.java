package Server;

import Category_Question.QuestionsDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerProtokoll implements ActionListener {
    // logiken för spelet
    private int points = 0;
    private int rounds = 0;
    private int currentQuestion = 0;

    private String name;
    QuestionsDatabase questionDatabase = new QuestionsDatabase();


    // få fram logiken för 1 kategori runna igenom all frågorna efter svaret är givet.
    // få en fråga svara på den skicka rätt/fel till klienten + ny fråga
    // idag förbestämd kategori djur.


    public Object gameLogic(Object input) {
        Object theOutput = null;

        if (rounds == 0) {

            theOutput = "Spel Startat";
            rounds++;

        } else if (rounds == 1) {
            System.out.println(rounds);
            System.out.println(input);
            theOutput = questionDatabase.dJquestionList().get(0);
            rounds++;

        }else if (rounds == 2) {
            System.out.println(rounds);
            Object answerFromUser = getCorrectAnswer(input);
            if (answerFromUser != null){
                theOutput = answerFromUser + "\n" + questionDatabase.dJquestionList().get(1);
                rounds++;
            }

        } else if (rounds == 3) {
            System.out.println(rounds);
            Object answerFromUser = getCorrectAnswer(input);
            if (answerFromUser != null){
                theOutput = answerFromUser + "\n" + questionDatabase.dJquestionList().get(2);
                rounds++;

            }

        } else if (rounds == 4) {
            System.out.println(rounds);
            theOutput = "Runda Slut";
        }

        return theOutput;
    }

        public Object getCorrectAnswer(Object input) {
           Object answer;
                if (input.equals(Integer.toString(questionDatabase.getCorrectIndex()))) {

                   answer = "Korrekt";
                   return answer;

                } else {
                 answer = "Fel";
                 return answer;
                }
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    }



