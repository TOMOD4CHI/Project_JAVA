package entity;

import java.util.Scanner;
public class Patient extends Personne{
    private String adresse;
    private String CIN;
    private String dateDeNaissance;
    private Dossier dossier;


    public Patient(String nom, String prenom, int numTelephone, String adresse, String CIN, String dateDeNaissance, Dossier dossier) {
        super(nom, prenom, numTelephone);
        this.adresse = adresse;
        this.CIN = CIN;
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
}
