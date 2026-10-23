package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Equipement;

import java.util.List;
import java.util.Set;

public interface IEquipement {
    Equipement ajouterEquipement(Equipement eq);
    public void supprimerEquipement(long idEquipement);
    List<Equipement> recupererEquipements();
    Set<Equipement> findEquipements();
    Equipement recupererEquipementByid(long idEquipement);
}
