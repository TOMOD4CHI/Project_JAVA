package service;

import entity.Calendrier;
import entity.Radiologue;
import entity.RendezVous;
import entity.Salle;
import ihm.Output;
import persistance.PersCalendrier;
import persistance.PersRendezVous;
import service.RadiologueServ;
import service.SalleServ;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RendezVousServ {
    private RadiologueServ radiologueServ = new RadiologueServ();
    private SalleServ salleServ = new SalleServ();
    private PersCalendrier persCalendrier = new PersCalendrier();
    private PersRendezVous persRendezVous = new PersRendezVous();

    public RendezVous scheduleRendezVous(RendezVous newRendezVous) {
        List<Radiologue> radiologues = (List<Radiologue>)radiologueServ.listAllRadiologues().getObj();
        List<Salle> salles = (List<Salle>)salleServ.listAllSalles().getObj();

        LocalDateTime startDateTime = LocalDateTime.now();
        Radiologue radiologueEntry=null;
        Salle salleEntry=null;
        while (true) {
            String formattedDateTime = startDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            newRendezVous.setDate(formattedDateTime);
            if(radiologueEntry==null) {
                for (Radiologue radiologue : radiologues) {
                    if (isTimeSlotAvailable(radiologue, formattedDateTime)) {
                        radiologueEntry = radiologue;
                    }
                }
            }
            if(salleEntry==null) {
                for (Salle salle : salles) {
                    if (isTimeSlotAvailable(salle, formattedDateTime)) {
                        salleEntry = salle;
                    }
                }
            }
            if(isTimeSlotAvailable(radiologueEntry, formattedDateTime) && isTimeSlotAvailable(salleEntry, formattedDateTime)) {
                persCalendrier.add(new Calendrier(radiologueEntry,salleEntry,formattedDateTime));
                persRendezVous.add(newRendezVous);

                return newRendezVous;
            }
            startDateTime = startDateTime.plusHours(1);
        }

    }

    private boolean isTimeSlotAvailable(Radiologue radiologue, String proposedDateTime) {
        if(radiologue==null)
        {
            return false;
        }
        List<Calendrier> existingCalendriers = persCalendrier.getCalendrierByRadiologue(radiologue);

        LocalDateTime proposedStart = LocalDateTime.parse(proposedDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime proposedEnd = proposedStart.plusHours(1);

        for (Calendrier existingCalendrier : existingCalendriers) {
            LocalDateTime existingStart = LocalDateTime.parse(existingCalendrier.getDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime existingEnd = existingStart.plusHours(1);

            if (isOverlapping(proposedStart, proposedEnd, existingStart, existingEnd)) {
                return false;
            }
        }

        return true;
    }
        private boolean isTimeSlotAvailable(Salle salle, String proposedDateTime) {
            if(salle==null)
            {
                return false;
            }
            List<Calendrier> existingCalendriers = persCalendrier.getCalendrierBySalle(salle);

            LocalDateTime proposedStart = LocalDateTime.parse(proposedDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime proposedEnd = proposedStart.plusHours(1);

            for (Calendrier existingCalendrier : existingCalendriers) {
                LocalDateTime existingStart = LocalDateTime.parse(existingCalendrier.getDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime existingEnd = existingStart.plusHours(1);

                if (isOverlapping(proposedStart, proposedEnd, existingStart, existingEnd)) {
                    return false;
                }
            }

            return true;
        }

    private boolean isOverlapping(LocalDateTime start1, LocalDateTime end1,
                                  LocalDateTime start2, LocalDateTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }
    public void removeRendezVous(int IdR){
        persRendezVous.remove(IdR);
    }
    public Output viewRdv(int IdR){
        RendezVous rdv=persRendezVous.getRendezVous(IdR);
        if(rdv==null){
            return new Output(false,"No Rendez-Vous Found",null);
        }
        return new Output(true,"",rdv);
    }
    public Output listAllRendezVous(){
        return new Output(true,"List Of Rendez-Vous : \n",persRendezVous.getAllRendezVous());
    }
    public Output showRendezVousbyPatient(int CIN){
        return new Output(true,"---- Rendez Vous -----\n",persRendezVous.getRendezVousByPatient(CIN));
    }

}
