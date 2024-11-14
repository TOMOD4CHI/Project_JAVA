public class Patient {
    private String nom;
    private String idP;
    private String dateDeNaissance;
    private Prescription prescription;//Change to dossier (contain every prescription + examens)

    public Patient(String idP, String nom, String dateDeNaissance) {
        this.idP = idP;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
    }

    public void ajouterPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public void afficherPrescription() {
        if (prescription != null) {
            System.out.println(prescription);
        } else {
            System.out.println("Aucune prescription pour ce patient.");
        }
    }

}
