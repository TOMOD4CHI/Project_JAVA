public class Categorie {
    private String nom;
    private String description;

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public void afficherCategorie() {
        System.out.println( "Catégorie: " + nom + ", Description: " + description);
    }
}
