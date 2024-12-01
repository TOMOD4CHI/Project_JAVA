import Controller.*;
import entity.Patient;
import entity.Radiologue;
import entity.Rapport;
import service.RadiologyReportPDF;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Controller.init();
        try {
            // Create patient
            Patient patient = new Patient(
                    "Dupont",
                    "Jean",
                    987654321,
                    "456 Rue de Paris",
                    12345,
                    "01/01/1980",
                    null
            );

            // Create rapport
            Radiologue radiologue = new Radiologue("Dr. Martin", "Radiologie", 987654,"hghjhg",656);
            Rapport rapport = new Rapport("Résultat de l'IRM cérébrale: Aucune anomalie significative détectée.", radiologue);

            // Generate PDF
            RadiologyReportPDF pdfGenerator = new RadiologyReportPDF();
            String rapportChemin = pdfGenerator.genererRapport(patient, rapport);

            System.out.println("Rapport généré : " + rapportChemin);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
