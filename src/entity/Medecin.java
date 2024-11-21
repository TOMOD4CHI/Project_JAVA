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

    public String getIdM() {
        return idM;
    }

    public void setIdM(String idM) {
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
}
