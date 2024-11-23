package service;
import entity.Patient;
import persistance.*;

public class PatientServ {
    PersPatient persPatient=new PersPatient();
    public void addPatient(Patient p) {
        persPatient.add(p);
    }
    public boolean removePatient(int CIN){
        Patient patient = (Patient) persPatient.getPatient(CIN);
        if (patient != null) {
            persPatient.remove(patient);
            //System.out.println("Patient removed successfully!");
            return true;
        } else {
                return false;
            //System.out.println("Patient not found!");
        }
        }
        public  void viewPatient(int CIN) {
        Patient patient = (Patient) persPatient.getPatient(CIN);
        if (patient != null) {
            System.out.println("Patient Details:");
            System.out.println("Name: " + patient.getNom() + " " + patient.getPrenom());
            System.out.println("Phone: " + patient.getNumTelephone());
            System.out.println("Address: " + patient.getAdresse());
            System.out.println("Date of Birth: " + patient.getDateDeNaissance());
        } else {

            System.out.println("Patient not found!");
        }
    }

    public void listAllPatients() {
        System.out.println("--- ALL PATIENTS ---");
        for(Patient patient : persPatient.getAllPatients()) {
            viewPatient(patient.getCIN());
        }
    }
}
