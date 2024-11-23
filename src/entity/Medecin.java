package entity;

public class Medecin extends Personne{
<<<<<<< Updated upstream
    private int idM;
    private String specialite;
    private String contact;

    public Medecin(String nom, String prenom, int numTelephone, int idM, String specialite, String contact) {
=======
    private String idM;
    private String specialite;
    private String contact;

    public Medecin(String nom, String prenom, int numTelephone, String idM, String specialite, String contact) {
>>>>>>> Stashed changes
        super(nom, prenom, numTelephone);
        this.idM = idM;
        this.specialite = specialite;
        this.contact = contact;
    }

<<<<<<< Updated upstream
    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
=======
>>>>>>> Stashed changes
}
