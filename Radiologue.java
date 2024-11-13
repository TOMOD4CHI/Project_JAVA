public class Radiologue {
    private String idR;
    private String nom;
    private String specialite;

    public Radiologue(String idR, String nom, String specialite) {
        this.idR = idR;
        this.nom = nom;
        this.specialite = specialite;
    }

    public Rapport Rapporter(String idExamen, String contenu) {
        return new Rapport(idExamen, contenu);
    }
}
