package service;

import entity.Radiologue;
import entity.Radiologue;
import persistance.PersRadiologue;

public class RadiologueServ {
    PersRadiologue persRadiologue=new PersRadiologue();
    public void addRadiologue(Radiologue p) {
        persRadiologue.add(p);
    }
    public boolean removeRadiologue(int idR){
        Radiologue Radiologue = (Radiologue) persRadiologue.getRadiologue(idR);
        if (Radiologue != null) {
            persRadiologue.remove(Radiologue);
            //System.out.println("Radiologue removed successfully!");
            return true;
        } else {
            return false;
            //System.out.println("Radiologue not found!");
        }
    }
    public  void viewRadiologue(int idR) {
        Radiologue radiologue = (Radiologue) persRadiologue.getRadiologue(idR);
        if (radiologue != null) {
            System.out.println("Radiologue Details:");
            System.out.println("Name: " + radiologue.getNom() + " " + radiologue.getPrenom());
            System.out.println("Phone: " + radiologue.getNumTelephone());
            System.out.println("Specialite: " + radiologue.getSpecialite().getNom());
            System.out.println("Salaire : " + Radiologue.getSalaire());
        } else {

            System.out.println("Radiologue not found!");
        }
    }

    public void listAllRadiologues() {
        System.out.println("--- ALL RadiologueS ---");
        for(Radiologue Radiologue : persRadiologue.getAllRadiologue()) {
            viewRadiologue(Radiologue.getIdR());
        }
    }
}
