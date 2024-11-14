//note every instance shall be saves into a json file
//so we can every patient have his own treatement(based on the categorie)
public class RendezVous {
    //Date date;
    int idRv;
    Patient patient;
    Prescription prescription;//base on this schedule the rendez-vous
    RendezVous(int idRv, Patient patient) {//,Date date
        this.idRv = idRv;
        this.patient = patient;
        //this.date=date;
    }
}
