public class Prescription {
    private String idM;
    private String medicament;
    private int dose;
    private String instructions;

    public Prescription(String idM, String medicament, int dose, String instructions) {
        this.idM = idM;
        this.medicament = medicament;
        this.dose = dose;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Prescription du Médecin ID: " + idM +
                " Médicament: " + medicament +
                " Dose: " + dose + "mL"+
                " Instructions: " + instructions;
    }
}

