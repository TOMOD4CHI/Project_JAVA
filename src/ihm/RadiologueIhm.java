package ihm;

import entity.Radiologue;

import java.util.Scanner;

public class RadiologueIhm {
    private void RadiologueManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- RADIOLOGUE MANAGEMENT ---");
            System.out.println("1. Add Radiologue");
            System.out.println("2. Remove Radiologue");
            System.out.println("3. View Radiologue");
            System.out.println("4. List All Radiologue");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addRadiologue();
                    break;
                case 2:
                    removeRadiologue();
                    break;
                case 3:
                    viewRadiologue();
                    break;
                case 4:
                    //listAllRadiologue();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public Radiologue addRadiologue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Radiologue Details:");
        System.out.print("First Name: ");
        String prenom = scanner.nextLine();
        System.out.print("Last Name: ");
        String nom = scanner.nextLine();
        System.out.print("Phone Number: ");
        int numTelephone = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Specialty: ");
        String specialite = scanner.nextLine();// Consume newline
        System.out.print("Radiologue ID: ");
        int idR = scanner.nextInt();

        return new Radiologue(nom, prenom, numTelephone, specialite,idR);
    }

    private int removeRadiologue() {
        System.out.print("Enter Radiologue ID to remove: ");
        Scanner scanner = new Scanner(System.in);
        int idR = scanner.nextInt();

        return idR;
        /*if (medecin != null) {
            persMedecin.remove(medecin);
            System.out.println("Medecin removed successfully!");
        } else {
            System.out.println("Medecin not found!");
        }*/
    }

    public int viewRadiologue() {
        System.out.print("Enter Radiologue ID to view: ");
        Scanner scanner = new Scanner(System.in);
        int idR = scanner.nextInt();

        return idR;
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
