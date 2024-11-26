package persistance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Salle;
import entity.Technicien;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersSalle {
    private static final String SALLES_FILE = "salles.json";
    private Gson gson;

    public PersSalle() {
        // Create Gson instance with pretty printing for readability
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void add(Salle s) {
        try {
            // Read existing salles
            List<Salle> salleList = readSalles();

            // Check if a salle with the same number already exists
            boolean exists = salleList.stream()
                    .anyMatch(existingSalle -> existingSalle.getNum() == s.getNum());

            if (!exists) {
                salleList.add(s);
                // Write updated list back to file
                writeSalles(salleList);
            } else {
                System.out.println("Salle with number " + s.getNum() + " already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(int salleNum) {
        try {
            List<Salle> salleList = readSalles();

            // Remove salle by matching salle number
            boolean removed = salleList.removeIf(salle -> salle.getNum() == salleNum);

            if (removed) {
                // Write updated list back to file
                writeSalles(salleList);
                System.out.println("Salle " + salleNum + " removed successfully.");
            } else {
                System.out.println("Salle " + salleNum + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Salle getSalle(int salleNum) {
        try {
            List<Salle> salleList = readSalles();

            return salleList.stream()
                    .filter(salle -> salle.getNum() == salleNum)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Salle> getAll() {
        try {
            List<Salle> salleList = readSalles();
            return !salleList.isEmpty() ? salleList : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addTechnicienToSalle(int salleNum, Technicien technicien) {
        try {
            List<Salle> salleList = readSalles();

            Salle salle = salleList.stream()
                    .filter(s -> s.getNum() == salleNum)
                    .findFirst()
                    .orElse(null);

            if (salle != null) {
                // If no technicien array exists, create one
                if (salle.getTechnicien() == null) {
                    salle.setTechnicien(new Technicien[]{technicien});
                } else {
                    // Expand the array to add the new technicien
                    Technicien[] currentTechniciens = salle.getTechnicien();
                    Technicien[] newTechniciens = new Technicien[currentTechniciens.length + 1];
                    System.arraycopy(currentTechniciens, 0, newTechniciens, 0, currentTechniciens.length);
                    newTechniciens[currentTechniciens.length] = technicien;
                    salle.setTechnicien(newTechniciens);
                }

                // Write updated list back to file
                writeSalles(salleList);
                System.out.println("Technicien added to Salle " + salleNum);
            } else {
                System.out.println("Salle " + salleNum + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTechnicienFromSalle(int salleNum, int technicienId) {
        try {
            List<Salle> salleList = readSalles();

            Salle salle = salleList.stream()
                    .filter(s -> s.getNum() == salleNum)
                    .findFirst()
                    .orElse(null);

            if (salle != null && salle.getTechnicien() != null) {
                // Filter out the technicien with the specified ID
                Technicien[] updatedTechniciens = java.util.Arrays.stream(salle.getTechnicien())
                        .filter(t -> t.getIdT() != technicienId)
                        .toArray(Technicien[]::new);

                // Update the salle with the filtered techniciens
                salle.setTechnicien(updatedTechniciens);

                // Write updated list back to file
                writeSalles(salleList);
                System.out.println("Technicien " + technicienId + " removed from Salle " + salleNum);
            } else {
                System.out.println("Salle " + salleNum + " not found or has no techniciens.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read salles from JSON file
    private List<Salle> readSalles() throws IOException {
        try (FileReader reader = new FileReader(SALLES_FILE)) {
            // Define the type to correctly deserialize the list of salles
            Type salleListType = new TypeToken<ArrayList<Salle>>(){}.getType();

            // Read existing salles or return empty list if file is empty/not found
            List<Salle> salles = gson.fromJson(reader, salleListType);
            return salles != null ? salles : new ArrayList<>();
        } catch (IOException e) {
            // If file doesn't exist, return an empty list
            return new ArrayList<>();
        }
    }

    // Write salles to JSON file
    private void writeSalles(List<Salle> salleList) throws IOException {
        try (FileWriter writer = new FileWriter(SALLES_FILE)) {
            gson.toJson(salleList, writer);
        }
    }
}