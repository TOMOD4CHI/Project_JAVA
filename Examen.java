import java.util.Scanner;
public class Examen {
    private String id;
    private Patient patient;
    private Radiologue radiologue;
    private Categorie categorie;
    private Rapport rapport;

    public Examen(String id, Patient patient, Radiologue radiologue, Categorie categorie) {
        this.id = id;
        this.patient = patient;
        this.radiologue = radiologue;
        this.categorie = categorie;
        Scanner sc = new Scanner(System.in);
        this.rapport=radiologue.Rapporter(sc.next());
    }
    //then when creating tho do_exam function look for the latest rdv of this client
    //and retrieve the prescription from there to assign it to his dossier and add the price of the treatement
}
