package service;

import entity.Radiologue;
import entity.Radiologue;
import ihm.Output;
import persistance.PersRadiologue;

import java.util.List;

public class RadiologueServ {
    PersRadiologue persRadiologue=new PersRadiologue();
    public Output addRadiologue(Radiologue p) {
        if(viewRadiologue(p.getIdR()).getObj()==null) {
            persRadiologue.add(p);
            return new Output(false,"Radiologue added Succesfully ! ",null);
        }
        return new Output(false,"Radiologue already exists ! ",null);

    }
    public Output removeRadiologue(int idR){
        Radiologue Radiologue = (Radiologue) persRadiologue.getRadiologue(idR);
        if (Radiologue != null) {
            persRadiologue.remove(Radiologue);
            return new Output(true,"Radiologue removed Succesfully ! ",null);
        } else {
            return new Output(false,"Radiologue does not exist ! ",null);
        }
    }
    public Output viewRadiologue(int idR) {
        Radiologue radiologue = (Radiologue) persRadiologue.getRadiologue(idR);
        if (radiologue != null) {
            return new Output(true,"",radiologue);
        } else {
            return new Output(false,"Radiologue not found!",null);
        }
    }

    public Output listAllRadiologues() {
        return new Output(true,"--- ALL RadiologueS ---\n",persRadiologue.getAllRadiologue());
    }
}
