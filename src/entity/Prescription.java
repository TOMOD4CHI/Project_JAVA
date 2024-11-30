package entity;

//change this class to entity.Dossier
//medecin gives a prescription (what type of treatement to do ) not a medicine(dwee)
public class Prescription {
    private Medecin medecin;
    private String traitement;

    public Prescription(String categorie, Medecin medecin) {
        this.traitement = categorie;
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Prescipter par le Medecin  " + medecin.getNom()+" "+medecin.getPrenom() +
                "\nType de traitement: " + traitement;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
