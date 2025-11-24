package Category_Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
// TEST
public class Question implements Serializable {
    private  int id;
    private  Category category;
    private  String text;
    private  List<String> options;
    private  int correctIndex;

    public Question(int id, Category category, String text, List<String> options, int correctIndex) {
        Objects.requireNonNull(category, "Kategori får inte vara null.");
        Objects.requireNonNull(text, "Frågetext får inte vara null.");
        Objects.requireNonNull(options, "Listan med svarsalternativ får inte vara null.");

        if (options.size() != 4) {
            throw new IllegalArgumentException("Listan med svarsalternativ måste innehålla exakt fyra element.");
        }
        if (correctIndex < 0 || correctIndex >= options.size()) {
            throw new IllegalArgumentException("Index för rätt svar måste vara mellan 0 och 3.");
        }

        this.id = id;
        this.category = category;
        this.text = text;
        this.options = List.copyOf(new ArrayList<>(options));
        this.correctIndex = correctIndex;
    }

    public Question() {

    }

    public int getId() { return id; }
    public Category getCategory() { return category; }
    public String getText() { return text; }
    public List<String> getOptions() { return options; }
    public int getCorrectIndex() { return correctIndex; }


    public PresentedQuestion presentedVersion() {
        List<String> shuffled = new ArrayList<>(options);
        Collections.shuffle(shuffled);
        int newCorrect = shuffled.indexOf(options.get(correctIndex));
        return new PresentedQuestion(id, category, text, List.copyOf(shuffled), newCorrect);
    }

    @Override
    public String toString() {
        return "Category: " + category + "\n" + text +
                "options: " + options;


    }

    public static class PresentedQuestion {
        private final int id;
        private final Category category;
        private final String text;
        private final List<String> options;
        private final int correctIndex;

        public PresentedQuestion(int id, Category category, String text, List<String> options, int correctIndex) {
            this.id = id;
            this.category = category;
            this.text = text;
            this.options = options;
            this.correctIndex = correctIndex;
        }

        public int getId() { return id; }
        public Category getCategory() { return category; }
        public String getText() { return text; }
        public List<String> getOptions() { return options; }
        public int getCorrectIndex() { return correctIndex; }
    }
}