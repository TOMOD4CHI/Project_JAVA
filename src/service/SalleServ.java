package service;

import entity.Salle;
import entity.Technicien;
import persistance.PersSalle;

import java.util.List;

public class SalleServ {
    PersSalle persSalle = new PersSalle();

    public void addSalle(Salle s) {
        persSalle.add(s);
    }

    public boolean removeSalle(int salleNum) {
        Salle salle = persSalle.getSalle(salleNum);
        if (salle != null) {
            persSalle.remove(salleNum);
            return true;
        } else {
            return false;
        }
    }

    public void viewSalle(int salleNum) {
        Salle salle = persSalle.getSalle(salleNum);
        if (salle != null) {
            System.out.println("Salle Details:");
            System.out.println("Numero Salle: " + salle.getNum());

            // Display techniciens if present
            Technicien[] techniciens = salle.getTechnicien();
            if (techniciens != null && techniciens.length > 0) {
                System.out.println("Techniciens in this Salle:");
                for (Technicien technicien : techniciens) {
                    System.out.println(" - Technicien ID: " + technicien.getIdT());
                    System.out.println(" - Technicien Full Name: " + technicien.getNom()+" "+technicien.getPrenom());
                }
            } else {
                System.out.println("No techniciens assigned to this Salle.");
            }
        } else {
            System.out.println("Salle not found!");
        }
    }

    public List<Salle> listAllSalles() {
        System.out.println("--- ALL SALLES ---");
        if (persSalle.getAll() != null) {
            for (Salle salle : persSalle.getAll()) {
                viewSalle(salle.getNum());
                System.out.println("---"); // Separator between salles
                return persSalle.getAll();
            }
        } else {
            System.out.println("No salles found.");
        }
        return null;
    }

    public void addTechnicienToSalle(int salleNum, Technicien technicien) {
        persSalle.addTechnicienToSalle(salleNum, technicien);
        TechnicienServ technicienServ= new TechnicienServ();
        technicien.setSalle_attribuer(salleNum);
        technicienServ.modifyTechnicien(technicien.getIdT(), technicien);
    }

    public void removeTechnicienFromSalle(int salleNum, int technicienId) {
        persSalle.removeTechnicienFromSalle(salleNum, technicienId);
    }
}