package service;

import entity.Medecin;
import entity.Medecin;
import persistance.PersMedecin;

public class MedecinServ {
    PersMedecin persMedecin=new PersMedecin();
    public void addMedecin(Medecin p) {
        persMedecin.add(p);
    }
    public boolean removeMedecin(int idM){
        Medecin medecin = (Medecin) persMedecin.getMedecin(idM);
        if (medecin != null) {
            persMedecin.remove(medecin);
            //System.out.println("Medecin removed successfully!");
            return true;
        } else {
            return false;
            //System.out.println("Medecin not found!");
        }
    }
    public  void viewMedecin(int idM) {
        Medecin medecin = (Medecin) persMedecin.getMedecin(idM);
        if (medecin != null) {
            System.out.println("Medecin Details:");
            System.out.println("Name: " + medecin.getNom() + " " + medecin.getPrenom());
            System.out.println("Phone: " + medecin.getNumTelephone());
            System.out.println("Contact : " + medecin.getContact());
            System.out.println("Specialite : " + medecin.getSpecialite());
        } else {

            System.out.println("Medecin not found!");
        }
    }

    public void listAllMedecins() {
        System.out.println("--- ALL MedecinS ---");
        for(Medecin medecin : persMedecin.getAllMedecin()) {
            viewMedecin(medecin.getIdM());
        }
    }
}
