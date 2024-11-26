package Controller;
import entity.Medecin;
import entity.Radiologue;
import entity.RendezVous;
import ihm.*;

public class Controller {
    public static void init() {
        while (true) {
            int choice = Menu.displayMainMenu();
            switch (choice) {
                case 1:
                    PatientCnt p = new PatientCnt();
                    p.showPatientMenu();
                    break;
                case 2:
                    MedecinCnt m = new MedecinCnt();
                    m.showMedecinMenu();
                    break;
                case 3:
                    RadiologueCnt r = new RadiologueCnt();
                    r.showRadiologueMenu();
                    break;
                case 4:
                    TechnicienCnt t = new TechnicienCnt();
                    t.showTechnicienMenu();
                    break;
                case 5:
                    CategorieCnt c = new CategorieCnt();
                    c.showCategorieMenu();
                    break;
                case 7:
                    SalleCnt s = new SalleCnt();
                    s.showSalleMenu();
                    break;
                case 8:
                    System.out.println("Exiting Administration System...");
                    return;
                    //case 6 for RDV
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
