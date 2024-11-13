public class Rapport {
    private String idExamen;
    private String contenu;

    public Rapport(String idExamen, String contenu) {
        this.idExamen = idExamen;
        this.contenu = contenu;
    }

    public void afficherRapport() {
        System.out.println("ID de l'Examen: " + idExamen);
        System.out.println("Contenu du Rapport: " + contenu);
    }
}

