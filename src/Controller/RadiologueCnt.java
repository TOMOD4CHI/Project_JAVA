package Controller;
import ihm.RadiologueIhm;
import entity.Radiologue;
import service.RadiologueServ;

public class RadiologueCnt {
    RadiologueServ radiologueServ=new RadiologueServ();
    int idR;
    public void showRadiologueMenu(){
        int choice = RadiologueIhm.RadiologueManagementMenu();
        switch (choice) {
            case 1:
                Radiologue radiologue = RadiologueIhm.addRadiologue();
                radiologueServ.addRadiologue(radiologue);
                break;
            case 2:
                idR=RadiologueIhm.removeRadiologue();
                radiologueServ.removeRadiologue(idR);
                break;
            case 3:
                idR=RadiologueIhm.viewRadiologue();
                radiologueServ.viewRadiologue(idR);
                break;
            case 4:
                radiologueServ.listAllRadiologues();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                showRadiologueMenu();
        }
    }
}
