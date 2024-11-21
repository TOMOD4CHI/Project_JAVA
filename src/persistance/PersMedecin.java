package persistance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Medecin;
import entity.Personne;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersMedecin implements Pers {
    private static final String MEDECINS_FILE = "medecins.json";
    private Gson gson;

    public PersMedecin() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void add(Personne p) {
        if (!(p instanceof Medecin)) {
            throw new IllegalArgumentException("Only Medecin objects can be added");
        }

        try {
            List<Medecin> medecinList = readMedecins();
            medecinList.add((Medecin) p);
            writeMedecins(medecinList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Personne p) {
        if (!(p instanceof Medecin)) {
            throw new IllegalArgumentException("Only Medecin objects can be removed");
        }

        try {
            List<Medecin> medecinList = readMedecins();
            Medecin medecin = (Medecin) p;
            medecinList.removeIf(existingMedecin -> existingMedecin.getIdM().equals(medecin.getIdM()));
            writeMedecins(medecinList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Personne getPersonne(int id) {
        try {
            List<Medecin> medecinList = readMedecins();
            return medecinList.stream()
                    .filter(medecin -> Integer.parseInt(medecin.getIdM()) == id)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Personne getAll() {
        try {
            List<Medecin> medecinList = readMedecins();
            return !medecinList.isEmpty() ? medecinList.get(0) : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(int id) {
        try {
            List<Medecin> medecinList = readMedecins();
            Medecin medecinToUpdate = medecinList.stream()
                    .filter(medecin -> Integer.parseInt(medecin.getIdM()) == id)
                    .findFirst()
                    .orElse(null);

            if (medecinToUpdate != null) {
                System.out.println("Medecin found: " + medecinToUpdate.getNom());
                writeMedecins(medecinList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Medecin> readMedecins() throws IOException {
        try (FileReader reader = new FileReader(MEDECINS_FILE)) {
            Type medecinListType = new TypeToken<ArrayList<Medecin>>(){}.getType();
            List<Medecin> medecins = gson.fromJson(reader, medecinListType);
            return medecins != null ? medecins : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void writeMedecins(List<Medecin> medecinList) throws IOException {
        try (FileWriter writer = new FileWriter(MEDECINS_FILE)) {
            gson.toJson(medecinList, writer);
        }
    }
}