package Controller;

import entity.Salle;
import service.SalleServ;
import ihm.SalleIhm;

public class SalleCnt {
    SalleServ salleServ=new SalleServ();
    public void showSalleMenu(){
        int choice = SalleIhm.SalleManagementMenu();
        switch (choice) {
            case 1:
                Salle salle = SalleIhm.addSalle();
                salleServ.addSalle(salle);
                break;
            case 2:
                //remove
                //to service
                break;
            case 3:
                //viewSalle(); from service
                break;
            case 4:

                //listAllSalles();from service
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                showSalleMenu();
        }
    }
}
