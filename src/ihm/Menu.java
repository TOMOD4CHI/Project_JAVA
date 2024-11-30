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
            System.out.println("8.Examen Management");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}