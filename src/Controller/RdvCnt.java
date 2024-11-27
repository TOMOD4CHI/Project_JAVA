package Controller;


import entity.RendezVous;

import ihm.RendezVousIhm;
import service.RendezVousServ;


public class RdvCnt {
    RendezVousServ rendezVousServ=new RendezVousServ();
    int IdR;
    public void showRdvMenu() {
        int choice = RendezVousIhm.RdvManagementMenu();
        switch (choice) {
            case 1:
                RendezVous rendezVous=RendezVousIhm.addRendezVous();
                rendezVousServ.scheduleRendezVous(rendezVous);
                break;
            case 2:
                IdR= RendezVousIhm.removeRendezVous();
                rendezVousServ.removeRendezVous(IdR);
                break;
            case 3:
                IdR= RendezVousIhm.viewRendezVous();
                rendezVousServ.removeRendezVous(IdR);
                break;
            case 4:
                rendezVousServ.listAllRendezVous();
                break;
                //ad view by patient and update
            case 5:
                System.out.println("Exiting ...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
