package ihm;

import entity.Salle;

import java.util.HashMap;
import java.util.Scanner;

public class SalleIhm {
    public static int SalleManagementMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Salle MANAGEMENT ---");
            System.out.println("1. Add Salle");
            System.out.println("2. Remove Salle");
            System.out.println("3. View Salle");
            System.out.println("4. List All Salle");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSalle();
                    break;
                case 2:
                    removeSalle();
                    break;
                case 3:
                    viewSalle();
                    break;
                case 4:
                    //listAllSalle();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            return choice;
    }

    public static Salle addSalle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Salle Details:");
        System.out.print("Numero Salle: ");
        int num = scanner.nextInt();


        return new Salle(num);
    }
    public HashMap<Integer, Integer> addTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Technicien Details:");
        System.out.println("Technicien ID : ");
        int idT = scanner.nextInt();
        System.out.print("Numero Salle: ");
        int num = scanner.nextInt();
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        res.put(idT, num);
        return res;
    }

    public static int removeSalle() {
        System.out.print("Enter numero de Salle  to remove: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        return num;
        /*if (medecin != null) {
            persMedecin.remove(medecin);
            System.out.println("Medecin removed successfully!");
        } else {
            System.out.println("Medecin not found!");
        }*/
    }
    public HashMap<Integer, Integer> removeTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID Technicien to remove:");
        int idT = scanner.nextInt();
        System.out.print("Enter Numero de Salle du Technicien to remove: ");
        int num = scanner.nextInt();
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        res.put(idT, num);
        return res;
    }

    public static int viewSalle() {
        System.out.print("Enter numero de Salle to view: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        return num;

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
    public static HashMap<Integer, Integer> viewTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID Technicien to view:");
        int idT = scanner.nextInt();
        System.out.print("Enter Numero de Salle du Technicien to view: ");
        int num = scanner.nextInt();
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        res.put(idT, num);
        return res;
    }

    /*private void listAllMedecins() {
        Scanner scanner = new Scanner(System.in);
        // Placeholder for listing all medecins
        System.out.println("--- ALL MEDECINS ---");
    }*/



}

