package entity;

import java.util.Scanner;
public class Examen {
    private String id;
    private String idRDV;
    private Patient patient;
    private Radiologue radiologue;
    private Technicien technicien;
    private Categorie categorie;
    private Rapport rapport;

    public Examen(String id, Patient patient, Radiologue radiologue, Categorie categorie) {
        this.id = id;
        this.patient = patient;
        this.radiologue = radiologue;
        getCategorie();
        genererRapport();
    }
    public void getCategorie() {
        //form the rdv id get the categorie in the prescreption
    }
    public  void genererRapport() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisit le conteneu du rapport entity.Rapport: ");
        String contenu= sc.nextLine();
        this.rapport = new Rapport(contenu,this.radiologue);
    }
    private void done(){
        //add the money to finance and add the rapport to the patient's dossier
    }
    //then when creating tho do_exam function look for the latest rdv of this client
    //and retrieve the prescription from there to assign it to his dossier and add the price of the treatement
}
