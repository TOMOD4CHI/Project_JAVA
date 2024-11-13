public class Examen {
    private String id;
    private String idP;
    private String idM;
    private Categorie categorie;

    public Examen(String id, String idP, String idM, Categorie categorie) {
        this.id = id;
        this.idP = idP;
        this.idM = idM;
        this.categorie = categorie;
    }

    public void afficherExamen() {
        System.out.println("ID de l'Examen: " + id);
        System.out.println("ID du Patient: " + idP);
        System.out.println("ID du Médecin: " + idM);
        categorie.afficherCategorie();
    }
}
