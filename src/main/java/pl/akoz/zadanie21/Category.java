package pl.akoz.zadanie21;

public enum Category {
    HOUSEHOLD("Artykuły gosp. domowego"),
    GROCERIES("Artykuły spożywcze"),
    OTHER("Pozostałe");

    private String polishCategory;

    Category(String polishCategory) {
        this.polishCategory = polishCategory;
    }
}
