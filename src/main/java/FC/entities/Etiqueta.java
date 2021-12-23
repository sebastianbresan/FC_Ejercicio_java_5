package FC.entities;


public class Etiqueta {

    private String language;

    public Etiqueta(String language) {
        this.language = language;
    }

    public Etiqueta() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                ", language='" + language + '\'' +
                '}';
    }
}
