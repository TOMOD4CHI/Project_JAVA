package service;

import entity.Technicien;
import entity.Technicien;
import persistance.PersTechnicien;

public class TechnicienServ {
    PersTechnicien persTechnicien=new PersTechnicien();
    public void addTechnicien(Technicien p) {
        persTechnicien.add(p);
    }
    public boolean removeTechnicien(int idR){
        Technicien Technicien = (Technicien) persTechnicien.getTechnicien(idR);
        if (Technicien != null) {
            persTechnicien.remove(Technicien);
            //System.out.println("Technicien removed successfully!");
            return true;
        } else {
            return false;
            //System.out.println("Technicien not found!");
        }
    }
    public  void viewTechnicien(int idR) {
        Technicien technicien = (Technicien) persTechnicien.getTechnicien(idR);
        if (technicien != null) {
            System.out.println("Technicien Details:");
            System.out.println("Name: " + technicien.getNom() + " " + technicien.getPrenom());
            System.out.println("Phone: " + technicien.getNumTelephone());
            System.out.println("Num Salle : " + technicien.getSalle_attribuer());
            System.out.println("Salaire : " + Technicien.getSalaire());
        } else {

            System.out.println("Technicien not found!");
        }
    }

    public void listAllTechniciens() {
        System.out.println("--- ALL TechnicienS ---");
        for(Technicien Technicien : persTechnicien.getAllTechnicien()) {
            viewTechnicien(Technicien.getIdT());
        }
    }
}
