public class Rapport {
    private String contenu;

    public Rapport(String contenu) {
        this.contenu = contenu;
    }
    @Override
    public String toString() {
        return this.contenu;
    }
}

