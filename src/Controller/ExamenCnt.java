package Controller;

import ihm.ExamenIhm;
import service.ExamenServ;

public class ExamenCnt {
    private ExamenServ examenServ = new ExamenServ();

    public void showExamenMenu() {
        while(true) {
            int choice = ExamenIhm.ExamenManagementMenu();
            switch (choice) {
                case 1:
                    examenServ.getAllExamensByState("Waiting").showoutput();
                    break;
                case 2:
                    examenServ.getAllExamensByState("Done").showoutput();
                    break;
                case 3:
                    int idRDV = ExamenIhm.performExam();
                    examenServ.performExamen(idRDV).showoutput();
                    break;
                case 4:
                    int idRadiologue = ExamenIhm.viewExamsByRadiologue();
                    examenServ.getExamensByRadiologue(idRadiologue).showoutput();
                    break;
                case 5:
                    int cin = ExamenIhm.viewExamsByPatient();
                    examenServ.getExamensByPatient(cin).showoutput();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}