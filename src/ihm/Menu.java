package ihm;
import entity.*;

import java.util.List;
import java.util.Scanner;
public class Menu {

    public static int displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- ADMINISTRATION MANAGEMENT SYSTEM ---");
            System.out.println("1. Patient Management");
            System.out.println("2. Medecin Management");
            System.out.println("3. Radiologue Management");
            System.out.println("4. Technicien Management");
            System.out.println("5. Exam Categories Management");
            System.out.println("6. Rendez-Vous Management");
            System.out.println("7. Salle Management");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
        return scanner.nextInt();
        }
    }

/*private void patientManagementMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n--- PATIENT MANAGEMENT ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Remove Patient");
        System.out.println("3. View Patient");
        System.out.println("4. List All Patients");
        System.out.println("5. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                removePatient();
                break;
            case 3:
                viewPatient();
                break;
            case 4:
                listAllPatients();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public void addPatient() {
    Scanner scanner = new Scanner(System.in);Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Patient Details:");
    System.out.print("First Name: ");
    String prenom = scanner.nextLine();
    System.out.print("Last Name: ");
    String nom = scanner.nextLine();
    System.out.print("Phone Number: ");
    int numTelephone = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Address: ");
    String adresse = scanner.nextLine();
    System.out.print("CIN (National ID): ");
    int CIN = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Date of Birth (YYYY-MM-DD): ");
    String dateDeNaissance = scanner.nextLine();

    Patient newPatient = new Patient(nom, prenom, numTelephone, adresse, CIN, dateDeNaissance, null);
    persPatient.add(newPatient);
    System.out.println("Patient added successfully!");
}

private void removePatient() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Patient CIN to remove: ");
    int CIN = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Patient patient = (Patient) persPatient.getPersonne(CIN);
    if (patient != null) {
        persPatient.remove(patient);
        System.out.println("Patient removed successfully!");
    } else {
        System.out.println("Patient not found!");
    }
}

private void viewPatient() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Patient CIN to view: ");
    int CIN = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Patient patient = (Patient) persPatient.getPersonne(CIN);
    if (patient != null) {
        System.out.println("Patient Details:");
        System.out.println("Name: " + patient.getNom() + " " + patient.getPrenom());
        System.out.println("Phone: " + patient.getNumTelephone());
        System.out.println("Address: " + patient.getAdresse());
        System.out.println("Date of Birth: " + patient.getDateDeNaissance());
    } else {
        System.out.println("Patient not found!");
    }
}

private void listAllPatients() {
    Scanner scanner = new Scanner(System.in);
    // This is a placeholder. You might want to modify getAll() in your persistence classes
    System.out.println("--- ALL PATIENTS ---");
    // Implement a method in PersPatient to get all patients
}

// Similar methods for Medecin, Radiologue, Technicien
private void medecinManagementMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n--- MEDECIN MANAGEMENT ---");
        System.out.println("1. Add Medecin");
        System.out.println("2. Remove Medecin");
        System.out.println("3. View Medecin");
        System.out.println("4. List All Medecins");
        System.out.println("5. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addMedecin();
                break;
            case 2:
                removeMedecin();
                break;
            case 3:
                viewMedecin();
                break;
            case 4:
                listAllMedecins();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private void addMedecin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Medecin Details:");
    System.out.print("First Name: ");
    String prenom = scanner.nextLine();
    System.out.print("Last Name: ");
    String nom = scanner.nextLine();
    System.out.print("Phone Number: ");
    int numTelephone = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Medecin ID: ");
    String idM = scanner.nextLine();
    System.out.print("Specialty: ");
    String specialite = scanner.nextLine();
    System.out.print("Contact: ");
    String contact = scanner.nextLine();

    Medecin newMedecin = new Medecin(nom, prenom, numTelephone, idM, specialite, contact);
    persMedecin.add(newMedecin);
    System.out.println("Medecin added successfully!");
}

private void removeMedecin() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Medecin ID to remove: ");
    String idM = scanner.nextLine();

    Medecin medecin = (Medecin) persMedecin.getPersonne(Integer.parseInt(idM));
    if (medecin != null) {
        persMedecin.remove(medecin);
        System.out.println("Medecin removed successfully!");
    } else {
        System.out.println("Medecin not found!");
    }
}

private void viewMedecin() {
    System.out.print("Enter Medecin ID to view: ");
    String idM = scanner.nextLine();

    Medecin medecin = (Medecin) persMedecin.getPersonne(Integer.parseInt(idM));
    if (medecin != null) {
        System.out.println("Medecin Details:");
        System.out.println("Name: " + medecin.getNom() + " " + medecin.getPrenom());
        System.out.println("Phone: " + medecin.getNumTelephone());
        System.out.println("Specialty: " + medecin.getSpecialite());
        System.out.println("Contact: " + medecin.getContact());
    } else {
        System.out.println("Medecin not found!");
    }
}

private void listAllMedecins() {
    Scanner scanner = new Scanner(System.in);
    // Placeholder for listing all medecins
    System.out.println("--- ALL MEDECINS ---");
}

// Implement similar methods for Radiologue and Technicien

private void rendezVousManagementMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n--- RENDEZ-VOUS MANAGEMENT ---");
        System.out.println("1. View All Rendez-Vous");
        System.out.println("2. Filter Rendez-Vous by State");
        System.out.println("3. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                viewAllRendezVous();
                break;
            case 2:
                filterRendezVousByState();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private void viewAllRendezVous() {
    Scanner scanner = new Scanner(System.in);
    List<RendezVous> allRendezVous = persRendezVous.getAllRendezVous();
    if (allRendezVous.isEmpty()) {
        System.out.println("No Rendez-Vous found.");
        return;
    }

    System.out.println("--- ALL RENDEZ-VOUS ---");
    for (RendezVous rdv : allRendezVous) {
        System.out.println("ID: " + rdv.getIdRv() +
                ", Patient: " + rdv.getPatient().getNom() +
                ", State: " + rdv.getState());
    }
}

private void filterRendezVousByState() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter State to filter (Waiting/Completed/etc.): ");
    String state = scanner.nextLine();

    List<RendezVous> filteredRendezVous = persRendezVous.getRendezVousByState(state);
    if (filteredRendezVous.isEmpty()) {
        System.out.println("No Rendez-Vous found with state: " + state);
        return;
    }

    System.out.println("--- RENDEZ-VOUS WITH STATE: " + state + " ---");
    for (RendezVous rdv : filteredRendezVous) {
        System.out.println("ID: " + rdv.getIdRv() +
                ", Patient: " + rdv.getPatient().getNom());
    }
}

public static void main(String[] args) {
    AdminManagementMenu menu = new AdminManagementMenu();
    menu.displayMainMenu();
}
}

 */