package Controller;

import entity.Salle;
import entity.Technicien;
import ihm.SalleIhm;
import service.SalleServ;
import service.TechnicienServ;

import java.util.HashMap;

public class SalleCnt {
    SalleServ salleServ = new SalleServ();
    int salleNum;

    public void showSalleMenu() {
        int choice = SalleIhm.SalleManagementMenu();
        switch (choice) {
            case 1:
                Salle salle = SalleIhm.addSalle();
                salleServ.addSalle(salle);
                break;
            case 2:
                salleNum = SalleIhm.removeSalle();
                salleServ.removeSalle(salleNum);
                break;
            case 3:
                salleNum = SalleIhm.viewSalle();
                salleServ.viewSalle(salleNum);
                break;
            case 4:
                // List All Salles
                salleServ.listAllSalles();
                break;
            case 5:
                TechnicienServ technicienServ=new TechnicienServ();
                HashMap<String, Integer> details = SalleIhm.addTechnicien();
                if (!details.isEmpty()) {
                    // first entry is technicien ID second is salle number
                    int salleNum = details.get("NumS");
                    Technicien technicien = technicienServ.viewTechnicien(details.get("IdT"));
                    salleServ.addTechnicienToSalle(salleNum, technicien);
                }
                break;
            case 6:
                HashMap<String, Integer> rdetails = SalleIhm.removeTechnicien();
                if (!rdetails.isEmpty()) {
                    // first entry is technicien ID, second is salle number
                    int salleNum = rdetails.get("NumS");
                    int idT= rdetails.get("IdT");

                    salleServ.removeTechnicienFromSalle(salleNum, idT);
                }
                break;
            case 7:
                // Return to Main Menu
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}