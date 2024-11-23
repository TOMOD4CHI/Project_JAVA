package Controller;
import entity.Medecin;
import entity.Radiologue;
import entity.RendezVous;
import ihm.*;

public class Controller {
    public static void init() {
        int choice = Menu.displayMainMenu();
        while (choice != 6) {
            switch (choice) {
                case 1:
                    PatientCnt p = new PatientCnt();
                    p.showPatientMenu();
                    break;
                case 2:
                    MedecinCnt m=new MedecinCnt();
                    m.showMedecinMenu();
                    break;
                case 3:
                    RadiologueCnt r=new RadiologueCnt();
                    r.showRadiologueMenu();
                    break;
                case 4:
                    TechnicienCnt t=new TechnicienCnt();
                    t.showTechnicienMenu();
                    break;
               /* case 5:
                    RendezVousIhm rendezVousIhm=new PatientIhm();
                    rendezVousIhm.rendezVousManagementMenu();
                    break;*/
                case 6:
                    System.out.println("Exiting Administration System...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
