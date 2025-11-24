package Category_Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionsDatabase extends Question implements Serializable {
    public List<Question> questions = new ArrayList<>();

    public QuestionsDatabase() {

        questions.add(new Question(
                1,
                Category.HISTORIA,
                "När började andra världskriget?",
                List.of("1939", "1945", "1914", "1949"),
                0 // 1939
        ));

        questions.add(new Question(
                2,
                Category.HISTORIA,
                "Vem var Sveriges statsminister år 2000?",
                List.of("Göran Persson", "Olof Palme", "Fredrik Reinfeldt", "Carl Bildt"),
                0 // Göran Persson
        ));

        questions.add(new Question(
                3,
                Category.HISTORIA,
                "Vilket år föll Berlinmuren?",
                List.of("1989", "1991", "1975", "1999"),
                0 // 1989
        ));

        questions.add(new Question(
                4,
                Category.GEOGRAFI,
                "Vad heter Sveriges huvudstad?",
                List.of("Stockholm", "Göteborg", "Malmö", "Uppsala"),
                0 // Stockholm
        ));

        questions.add(new Question(
                5,
                Category.GEOGRAFI,
                "Vilket är världens största hav?",
                List.of("Stilla havet", "Atlanten", "Indiska oceanen", "Södra ishavet"),
                0 // Stilla havet
        ));

        questions.add(new Question(
                6,
                Category.GEOGRAFI,
                "Vilken svensk stad ligger längst söderut?",
                List.of("Malmö", "Göteborg", "Helsingborg", "Karlskrona"),
                0 // Malmö
        ));

        questions.add(new Question(
                7,
                Category.DJUR,
                "Vilket djur kan flyga?",
                List.of("Fågel", "Hund", "Katt", "Orm"),
                0 // Fågel
        ));

        questions.add(new Question(
                8,
                Category.DJUR,
                "Vilket är världens största landlevande däggdjur?",
                List.of("Elefant", "Giraff", "Flodhäst", "Isbjörn"),
                0 // Elefant
        ));

        questions.add(new Question(
                9,
                Category.DJUR,
                "Vilket djur säger 'MU'?",
                List.of("Ko", "Häst", "Får", "Kanin"),
                0 // Ko
        ));

        questions.add(new Question(
                10,
                Category.SPORT,
                "Hur många spelare är på plan i ett fotbollsmatch",
                List.of("22", "11", "10", "9"),
                0 // 22 (totalt båda lagen)
        ));

        questions.add(new Question(
                11,
                Category.SPORT,
                "Vilket land har vunnit flest världsmästarskap i fotboll?",
                List.of("Brasilien", "Tyskland", "Argentina", "Italien"),
                0 // Brasilien
        ));

        questions.add(new Question(
                12,
                Category.SPORT,
                "Vilken sport använder en puck?",
                List.of("Ishockey", "Fotboll", "Tennis", "Basket"),
                0 // Ishockey
        ));

        questions.add(new Question(
                13,
                Category.FILM_TV,
                "Vilken film innehåller karaktären Jack Sparrow",
                List.of("Pirates of Caribbean", "Star Wars", "The Matrix", "Avatar"),
                0 // Pirates of Caribbean
        ));

        questions.add(new Question(
                14,
                Category.FILM_TV,
                "Vilken film innehåller figuren 'The Joker'?",
                List.of("The Dark Knight", "Inception", "Gladiator", "Blade Runner"),
                0 // The Dark Knight
        ));

        questions.add(new Question(
                15,
                Category.FILM_TV,
                "Vilket land kommer animeserien 'Naruto' ifrån?",
                List.of("Japan", "Kina", "Sydkorea", "Thailand"),
                0 // Japan
        ));

        questions.add(new Question(
                16,
                Category.VETENSKAP,
                "Vilken gas andas människor in för att överleva?",
                List.of("Syre", "Koldioxid", "Kväve", "Väte"),
                0 // Syre
        ));

        questions.add(new Question(
                17,
                Category.VETENSKAP,
                "Vad heter planeten som kallas 'den röda planeten'?",
                List.of("Mars", "Venus", "Jupiter", "Merkurius"),
                0 // Mars
        ));

        questions.add(new Question(
                18,
                Category.VETENSKAP,
                "Vad är H2O vanligast kallad?",
                List.of("Vatten", "Syre", "Koldioxid", "Salt"),
                0 // Vatten
        ));
    }

    public List<Category> getAllCategories() {
        Set<Category> set = questions.stream()
                .map(Question::getCategory)
                .collect(Collectors.toSet());
        List<Category> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> a.name().compareTo(b.name()));
        return List.copyOf(list);
    }

    public List<Question> getQuestionsByCategory(Category category) {
        return questions.stream()
                .filter(q -> q.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Question> getRandomQuestions(Category category, int amount) {
        List<Question> pool = new ArrayList<>(getQuestionsByCategory(category));
        Collections.shuffle(pool);
        if (amount >= pool.size()) {
            return List.copyOf(pool);
        } else {
            return List.copyOf(pool.subList(0, amount));
        }
    }
}