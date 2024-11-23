package ihm;

import entity.Medecin;

import java.util.Scanner;

public class MedecinIhm {
    private void MedecinManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Medecin MANAGEMENT ---");
            System.out.println("1. Add Medecin");
            System.out.println("2. Remove Medecin");
            System.out.println("3. View Medecin");
            System.out.println("4. List All Medecin");
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
                    //listAllMedecin();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public Medecin addMedecin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Medecin Details:");
        System.out.print("First Name: ");
        String prenom = scanner.nextLine();
        System.out.print("Last Name: ");
        String nom = scanner.nextLine();
        System.out.print("Phone Number: ");
        int numTelephone = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Medecin ID: ");
        int idM = scanner.nextInt();

        System.out.print("Specialite: ");
        String specialite = scanner.nextLine();
        System.out.print("Contact: ");
        String contact = scanner.nextLine();// Consume newline

        return new Medecin(nom, prenom, numTelephone, idM ,specialite, contact);
    }

    private int removeMedecin() {
        System.out.print("Enter Medecin ID to remove: ");
        Scanner scanner = new Scanner(System.in);
        int idM = scanner.nextInt();

        return idM;
        /*if (medecin != null) {
            persMedecin.remove(medecin);
            System.out.println("Medecin removed successfully!");
        } else {
            System.out.println("Medecin not found!");
        }*/
    }

    public int viewMedecin() {
        System.out.print("Enter Medecin ID to view: ");
        Scanner scanner = new Scanner(System.in);
        int idM = scanner.nextInt();

        return idM;
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
