package entity;

public class Technicien extends Personne{
    private int idT;
    private static double salaire;
    private Salle salle_attribuer;
    public Technicien(String nom, String prenom, int numTelephone, int idT,Salle salle_attribuer) {
        super(nom, prenom, numTelephone);
        this.idT = idT;
        this.salle_attribuer = salle_attribuer;
    }
    public int getIdT() {
        return idT;
    }
    public void setIdT(int idT) {
        this.idT = idT;
    }
    public Salle getSalle_attribuer() {
        return salle_attribuer;
    }
    public void setSalle_attribuer(Salle salle_attribuer) {
        this.salle_attribuer = salle_attribuer;
    }
}
