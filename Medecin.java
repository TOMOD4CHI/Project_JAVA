public class Medecin {
    private String idM;
    private String nom;
    private String specialite;
    private String contact;

    public Medecin(String idM, String nom, String specialite, String contact) {
        this.idM = idM;
        this.nom = nom;
        this.specialite = specialite;
        this.contact = contact;
    }

    public void prescrire(Patient patient, Prescription prescription) {
        patient.ajouterPrescription(prescription);
    }
}
