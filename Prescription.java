//change this class to Dossier
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
        return "Prescipter par le  Medecin  " + medecin.getNom()+" "+medecin.getPrenom() +
                "\nType de traitement: " + traitement;
    }
}
