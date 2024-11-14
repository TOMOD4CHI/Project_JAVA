public class Radiologue {
    private String idR;
    private String nom;
    private String specialite;//can be paired with categorie class
    //pass the categorie in constructor and get its  name to the specialite
    public Radiologue(String idR, String nom, String specialite) {
        this.idR = idR;
        this.nom = nom;
        this.specialite = specialite;
    }

    public Rapport Rapporter(String idExamen, String contenu) {
        return new Rapport(idExamen, contenu);
    }
}
