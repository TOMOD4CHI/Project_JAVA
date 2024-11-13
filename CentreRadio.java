public class CentreRadio {
    private String nom;
    private String adresse;
    private int num;

    public CentreRadio(String nom, String adresse,int num) {
        this.nom = nom;
        this.adresse = adresse;
        this.num = num;
    }

    public void afficherCentreRadio() {
        System.out.println("Nom du Centre: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Num: " + num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
