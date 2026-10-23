package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;
import java.util.Set;

public interface IVehicule {
    Vehicule ajouterVehicule(Vehicule ve);
    public void supprimerVehicule(long idVehicule);
    List<Vehicule> recupererVehicules();
    Set<Vehicule> findVehicules();
    Vehicule recupererVehiculeByid(long idVehicule);
}
