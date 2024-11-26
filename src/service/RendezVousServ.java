package service;
import entity.Radiologue;
import entity.RendezVous;
import entity.Salle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RendezVousServ {
    RadiologueServ radiologueServ=new RadiologueServ();
    SalleServ salleServ=new SalleServ();
    List<Radiologue> Radiologues=radiologueServ.listAllRadiologues();
   // ArrayList<Salle> salles=salleServ.;

}
