package Controller;
import entity.Patient;
import ihm.Menu;
import ihm.PatientIhm;
import service.PatientServ;

public class PatientCnt {
    PatientServ patientServ=new PatientServ();
    int CIN;
    public void showPatientMenu() {
        int choice = PatientIhm.PatientManagementMenu();
               switch (choice) {
                    case 1:
                        Patient patient = PatientIhm.addPatient();
                        patientServ.addPatient(patient);
                        break;
                    case 2:
                        CIN= PatientIhm.removePatient();
                        patientServ.removePatient(CIN);
                        break;
                   case 3:
                       CIN=PatientIhm.viewPatient();
                      patientServ.viewPatient(CIN);
                        break;
                    case 4:
                        patientServ.listAllPatients();
                        break;
                    case 5:
                        System.out.println("nigga");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
           }
    }
}

