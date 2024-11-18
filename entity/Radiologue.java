package entity;

public class Radiologue extends Personne{
    private String idR;
    private Categorie specialite;//can be paired with categorie class
    private  static double salaire;
    //pass the categorie in constructor and get its  name to the specialite
    public Radiologue(String nom, String prenom, int numTelephone, String specialite, String idR) {
        super(nom, prenom, numTelephone);
        this.idR = idR;
        getCategorie(specialite);
    }
    public void getCategorie(String specialite) {
        //check if specialite exists in categories and get it to the specialite variable
    }
    public String getIdR() {
        return idR;
    }

    public void setIdR(String idR) {
        this.idR = idR;
    }

    public Categorie getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Categorie specialite) {
        this.specialite = specialite;
    }

    public static double getSalaire() {
        return salaire;
    }

    public static void setSalaire(double salaire) {
        Radiologue.salaire = salaire;
    }

}
