package Category_Question;/*
Enum som innehåller alla kategorier som spelet använder
Varje kategori har ett visningsnamn som används mot användaren
 */

public enum Category {
    // De olika kategorierna i spelet
    HISTORIA("Historia"),
    GEOGRAFI("Geografi"),
    DJUR("Djur"),
    SPORT("Sport"),
    FILM_TV("Film & TV"),
    VETENSKAP("Vetenskap");

    // Namnet som ska visas för användaren
    private final String displayName;

    // Konstruktorn
    Category(String displayName) {
        this.displayName = displayName;
    }

    // Returnerar namnet som ska visas för användaren
    @Override
    public String toString() {
        return displayName;
    }
}