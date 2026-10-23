package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Maintenance;

import java.util.List;
import java.util.Set;

public interface IMaintenance {
    Maintenance ajouterMaintenance(Maintenance ma);
    public void supprimerMaintenance(long idMaintenance);
    List<Maintenance> recupererMaintenances();
    Set<Maintenance> findMaintenances();
    Maintenance recupererMaintenanceByid(long idMaintenance);
}
