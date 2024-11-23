package ihm;

import entity.Dossier;
import entity.Patient;

import java.util.Scanner;

public class PatientIhm {
    private void PatientManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Patient MANAGEMENT ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Patient");
            System.out.println("4. List All Patient");
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
                    //listAllPatient();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public Patient addPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient Details:");
        System.out.print("First Name: ");
        String prenom = scanner.nextLine();
        System.out.print("Last Name: ");
        String nom = scanner.nextLine();
        System.out.print("Phone Number: ");
        int numTelephone = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Patient CIN: ");
        int cin = scanner.nextInt();

        System.out.print("Date De Naissance: ");
        String dateDeNaissance = scanner.nextLine();

        return new Patient(nom, prenom, numTelephone, adresse ,cin, dateDeNaissance,new Dossier());
    }

    private int removePatient() {
        System.out.print("Enter Patient CIN to remove: ");
        Scanner scanner = new Scanner(System.in);
        int cin = scanner.nextInt();

        return cin;
        /*if (medecin != null) {
            persMedecin.remove(medecin);
            System.out.println("Medecin removed successfully!");
        } else {
            System.out.println("Medecin not found!");
        }*/
    }

    public int viewPatient() {
        System.out.print("Enter Patient CIN to view: ");
        Scanner scanner = new Scanner(System.in);
        int cin = scanner.nextInt();

        return cin;
        /*if (medecin != null) {
            System.out.println("Medecin Details:");
            System.out.println("Name: " + medecin.getNom() + " " + medecin.getPrenom());
            System.out.println("Phone: " + medecin.getNumTelephone());
            System.out.println("Specialty: " + medecin.getSpecialite());
            System.out.println("Contact: " + medecin.getContact());
        } else {
            System.out.println("Medecin not found!");
        }*/
    }

    /*private void listAllMedecins() {
        Scanner scanner = new Scanner(System.in);
        // Placeholder for listing all medecins
        System.out.println("--- ALL MEDECINS ---");
    }*/

}
