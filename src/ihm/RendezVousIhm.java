package ihm;

import entity.*;

import java.util.Scanner;

public class RendezVousIhm {
    public static int RdvManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Rendez-Vous MANAGEMENT ---");
        System.out.println("1. Add Rendez-Vous");
        System.out.println("2. Remove Rendez-Vous ");
        System.out.println("3. View Rendez-Vous");
        System.out.println("4. List All Rendez-Vous");
        System.out.println("5. Show Rendez-Vous by Patient");
        System.out.println("6. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    public static RendezVous addRendezVous() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id RendezVous : ");
        int Idr= scanner.nextInt();
        scanner.nextLine();
        Patient patient=PatientIhm.addPatient();
        System.out.println("Type The Prescription : ");
        Prescription prescription=generatePrescription();
        return new RendezVous(Idr,patient,prescription);
    }
    private static Prescription generatePrescription() {
        //need to check if the type exist in the categorie json file
        //else raise an excep
        System.out.println("Enter the traitement name:");
        String type = Verification.getValidName();
        Medecin medecin = MedecinIhm.addMedecin();
        return new Prescription(type, medecin);
    }
    public static int removeRendezVous() {
        System.out.print("Enter Rdv ID to remove: ");
        return Verification.getValidID();
    }

    public static int viewRendezVous() {
        System.out.print("Enter Rdv ID to view: ");
        return Verification.getValidID();
    }
}