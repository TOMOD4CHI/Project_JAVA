package entity;

public class Calendrier {
    private Radiologue radiologue;
    private Salle salle;
    private String Date;

    public Calendrier(Radiologue radiologue, Salle salle, String date) {
        this.radiologue = radiologue;
        this.salle = salle;
        Date = date;
    }
}
