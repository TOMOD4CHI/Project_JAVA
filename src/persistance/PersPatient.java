package persistance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Patient;
import entity.Personne;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersPatient implements Pers {
    private static final String PATIENTS_FILE = "patients.json";
    private Gson gson;

    public PersPatient() {
        // Create Gson instance with pretty printing for readability
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void add(Personne p) {
        if (!(p instanceof Patient)) {
            throw new IllegalArgumentException("Only Patient objects can be added");
        }

        try {
            // Read existing patients
            List<Patient> patientList = readPatients();

            // Add new patient
            patientList.add((Patient) p);

            // Write updated list back to file
            writePatients(patientList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Personne p) {
        if (!(p instanceof Patient)) {
            throw new IllegalArgumentException("Only Patient objects can be removed");
        }

        try {
            List<Patient> patientList = readPatients();
            Patient patient = (Patient) p;

            // Remove patient by matching CIN
            patientList.removeIf(existingPatient -> existingPatient.getCIN() == patient.getCIN());

            // Write updated list back to file
            writePatients(patientList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Personne getPersonne(int id) {
        try {
            List<Patient> patientList = readPatients();

            return patientList.stream()
                    .filter(patient -> patient.getCIN() == id)
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
            List<Patient> patientList = readPatients();

            // If you need to return a single Personne, return the first patient
            return !patientList.isEmpty() ? patientList.get(0) : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(int id) {
        try {
            List<Patient> patientList = readPatients();

            // Find the patient to update
            Patient patientToUpdate = patientList.stream()
                    .filter(patient -> patient.getCIN() == id)
                    .findFirst()
                    .orElse(null);

            if (patientToUpdate != null) {
                // Placeholder for update logic
                // In a real implementation, you'd modify the patient object
                System.out.println("Patient found: " + patientToUpdate.getNom());

                // Write back the updated list
                writePatients(patientList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read patients from JSON file
    private List<Patient> readPatients() throws IOException {
        try (FileReader reader = new FileReader(PATIENTS_FILE)) {
            // Define the type to correctly deserialize the list of patients
            Type patientListType = new TypeToken<ArrayList<Patient>>(){}.getType();

            // Read existing patients or return empty list if file is empty/not found
            List<Patient> patients = gson.fromJson(reader, patientListType);
            return patients != null ? patients : new ArrayList<>();
        } catch (IOException e) {
            // If file doesn't exist, return an empty list
            return new ArrayList<>();
        }
    }

    // Write patients to JSON file
    private void writePatients(List<Patient> patientList) throws IOException {
        try (FileWriter writer = new FileWriter(PATIENTS_FILE)) {
            gson.toJson(patientList, writer);
        }
    }

    // Optional: Method to get all patients as a list
    public List<Patient> getAllPatients() {
        try {
            return readPatients();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}