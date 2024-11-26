package persistance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Patient;
import entity.Patient;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersPatient{
    private static final String PATIENTS_FILE = "patients.json";
    private Gson gson;

    public PersPatient() {
        // Create Gson instance with pretty printing for readability
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
    
    public void add(Patient p) {
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
    public boolean modify(int CIN, Patient updatedPatient) {
        try {
            List<Patient> patientList = readPatients();

            // Find the patient to update
            for (int i = 0; i < patientList.size(); i++) {
                Patient existingPatient = patientList.get(i);

                // Match patient by CIN
                if (existingPatient.getCIN() == CIN) {
                    // Update all fields except CIN
                    existingPatient.setNom(updatedPatient.getNom());
                    existingPatient.setPrenom(updatedPatient.getPrenom());
                    existingPatient.setNumTelephone(updatedPatient.getNumTelephone());
                    existingPatient.setAdresse(updatedPatient.getAdresse());
                    existingPatient.setDateDeNaissance(updatedPatient.getDateDeNaissance());

                    // Write back the updated list
                    writePatients(patientList);
                    System.out.println("Patient updated successfully.");
                    return true;
                }
            }

            System.out.println("Patient not found.");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Rename this method to avoid confusion with the new modify method
    public void updatePlaceholder(int id) {
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
    public void remove(Patient p) {
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
    public Patient getPatient(int id) {
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

    public List<Patient> getAll() {
        try {
            List<Patient> patientList = readPatients();
            return !patientList.isEmpty() ? patientList : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

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