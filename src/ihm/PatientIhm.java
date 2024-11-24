package ihm;

import entity.Dossier;
import entity.Patient;

import java.util.Scanner;

public class PatientIhm {
    public static int  PatientManagementMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Patient MANAGEMENT ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Patient");
            System.out.println("4. List All Patient");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
    }

    public static Patient addPatient() {
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
        scanner.nextLine();

        return new Patient(nom, prenom, numTelephone, adresse ,cin, dateDeNaissance,new Dossier());
    }

    public static int removePatient() {
        System.out.print("Enter Patient CIN to remove: ");
        Scanner scanner = new Scanner(System.in);
        int cin = scanner.nextInt();

        return cin;
    }

    public static int viewPatient() {
        System.out.print("Enter Patient CIN to view: ");
        Scanner scanner = new Scanner(System.in);
        int cin = scanner.nextInt();

        return cin;
    }

}
