package entity;

public class Salle {
    private int num;
    private Technicien[] technicien;
    public Salle(int num) {
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public Technicien[] getTechnicien() {
        return technicien;
    }
    public void setTechnicien(Technicien[] technicien) {
        this.technicien = technicien;
    }

}
