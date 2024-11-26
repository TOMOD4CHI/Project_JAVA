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
            System.out.println("5. Add Technicien to Salle");
            System.out.println("6. Remove Technicien from Salle");
            System.out.println("7. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
    }

    public static Salle addSalle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Salle Details:");
        System.out.print("Numero Salle: ");
        int num = scanner.nextInt();
        return new Salle(num);
    }
    public static HashMap<String, Integer> addTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Technicien Details:");
        System.out.println("Technicien ID : ");
        int idT = scanner.nextInt();
        System.out.print("Numero Salle: ");
        int num = scanner.nextInt();
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        res.put("NumS",num);
        res.put("IdT", idT);
        return res;
    }

    public static int removeSalle() {
        System.out.print("Enter numero de Salle  to remove: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        return num;
    }
    public static HashMap<String, Integer> removeTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID Technicien to remove:");
        int idT = scanner.nextInt();
        System.out.print("Enter Numero de Salle du Technicien to remove: ");
        int num = scanner.nextInt();
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        res.put("IdT", idT);
        res.put("NumS", num);
        return res;
    }

    public static int viewSalle() {
        System.out.print("Enter numero de Salle to view: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        return num;

    }
    public static HashMap<String, Integer> viewTechnicien() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID Technicien to view:");
        int idT = scanner.nextInt();
        System.out.print("Enter Numero de Salle du Technicien to view: ");
        int num = scanner.nextInt();
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        res.put("IdT", idT);
        res.put("NumS",num);
        return res;
    }

}

