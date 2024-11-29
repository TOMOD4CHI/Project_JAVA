package entity;
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
    //chouf 7al
    @Override
    public String toString() {
        return "";
    }
}
