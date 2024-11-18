public class Technicien extends Personne{
    private int idT;

    public Technicien(String nom, String prenom, int numTelephone, int idT) {
        super(nom, prenom, numTelephone);
        this.idT = idT;
    }
    public int getIdT() {
        return idT;
    }
    public void setIdT(int idT) {
        this.idT = idT;
    }

}
