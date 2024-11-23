package ihm;

import entity.Technicien;

import java.util.Scanner;

public class TechnicienIhm {
    public static int TechnicienManagementMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Technicien MANAGEMENT ---");
            System.out.println("1. Add Technicien");
            System.out.println("2. Remove Technicien");
            System.out.println("3. View Technicien");
            System.out.println("4. List All Technicien");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
    }

    public static Technicien addTechnicien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Technicien Details:");
        System.out.print("First Name: ");
        String prenom = scanner.nextLine();
        System.out.print("Last Name: ");
        String nom = scanner.nextLine();
        System.out.print("Phone Number: ");
        int numTelephone = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Technicien ID: ");
        int idT = scanner.nextInt();

        System.out.print("Num Salle: ");
        int numSalle = scanner.nextInt();// Consume newline

        return new Technicien(nom, prenom, numTelephone, idT ,numSalle);
    }

    public static int removeTechnicien() {
        System.out.print("Enter Technicien ID to remove: ");
        Scanner scanner = new Scanner(System.in);
        int idT = scanner.nextInt();

        return idT;
        /*if (medecin != null) {
            persMedecin.remove(medecin);
            System.out.println("Medecin removed successfully!");
        } else {
            System.out.println("Medecin not found!");
        }*/
    }

    public static int viewTechnicien() {
        System.out.print("Enter Technicien ID to view: ");
        Scanner scanner = new Scanner(System.in);
        int idT = scanner.nextInt();

        return idT;
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
