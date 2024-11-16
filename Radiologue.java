public class Radiologue extends Personne{
    private String idR;
    private Categorie specialite;//can be paired with categorie class
    //pass the categorie in constructor and get its  name to the specialite
    public Radiologue(String nom, String prenom, int numTelephone, Categorie specialite, String idR) {
        super(nom, prenom, numTelephone);
        this.specialite = specialite;
        this.idR = idR;
    }

    public Rapport Rapporter(String contenu) {
        return new Rapport(contenu);
    }
}
