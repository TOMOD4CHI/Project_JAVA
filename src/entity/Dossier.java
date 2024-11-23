package entity;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.HashMap;
//Contient les compte rendue et prescription de chaque patient
public class Dossier {
    ArrayList<HashMap<Prescription, Rapport>> results = new ArrayList<HashMap<Prescription, Rapport>>();
    void add(Prescription prescription, Rapport rapport) {
        HashMap<Prescription,Rapport> res = new HashMap<Prescription,Rapport>();
        res.put(prescription, rapport);
        this.results.add(res);
    }
=======

//Contient les compte rendue et prescription de chaque patient
public class Dossier {

>>>>>>> Stashed changes
}
