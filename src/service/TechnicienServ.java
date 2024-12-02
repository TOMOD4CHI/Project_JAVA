package service;

import entity.Technicien;
import entity.Technicien;
import ihm.Output;
import persistance.PersTechnicien;

public class TechnicienServ {
    private static int iD=8756;
    PersTechnicien persTechnicien=new PersTechnicien();
    public Output addTechnicien(Technicien p) {
        p.setIdT(iD++);
        if(viewTechnicien(p.getIdT()).getObj()==null){
        persTechnicien.add(p);
        iD++;
        return new Output(true,"Technicien added Succesfully",null);
        }
        return new Output(false,"Technicien Already Exists",null);
    }
    public Output removeTechnicien(int idR){
        Technicien Technicien = (Technicien) persTechnicien.getTechnicien(idR);
        if (Technicien != null) {
            persTechnicien.remove(Technicien);
            return new Output(true,"Technicien removed",null);
        } else {
            return new Output(false,"Technicien not found",null);
        }
    }
    public Output viewTechnicien(int idR) {
        Technicien technicien = (Technicien) persTechnicien.getTechnicien(idR);
        if (technicien != null) {
            return new Output(true,"",technicien);
        } else {
            return new Output(false,"Technicien not found!",null);
        }
    }

    public Output listAllTechniciens() {
        return new Output(true,"--- ALL TechnicienS ---\n",persTechnicien.getAll());
    }
    public Output modifyTechnicien(int idT,Technicien t){
        if(persTechnicien.modify(idT,t)){
            return new Output(true,"Technicien modified Succesfully",null);
        }
        return new Output(false,"Technicien not found",null);
    }
}
