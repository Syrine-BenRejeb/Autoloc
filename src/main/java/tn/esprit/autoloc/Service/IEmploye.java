package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Employe;

import java.util.List;
import java.util.Set;

public interface IEmploye {
    Employe ajouterEmploye(Employe em);
    public void supprimerEmploye(long idEmploye);
    List<Employe> recupererEmployes();
    Set<Employe> findEmployes();
    Employe recupererEmployeByid(long idEmploye);
}
