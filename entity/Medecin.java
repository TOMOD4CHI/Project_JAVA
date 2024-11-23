package entity;

public class Medecin extends Personne{
    private String idM;
    private String specialite;
    private String contact;

    public Medecin(String nom, String prenom, int numTelephone, String idM, String specialite, String contact) {
        super(nom, prenom, numTelephone);
        this.idM = idM;
        this.specialite = specialite;
        this.contact = contact;
    }

}
