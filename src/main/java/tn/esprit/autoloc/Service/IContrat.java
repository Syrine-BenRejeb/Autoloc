package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Contrat;

import java.util.List;
import java.util.Set;

public interface IContrat {
    Contrat ajouterContrat(Contrat co);
    public void supprimerContrat(long idContrat);
    List<Contrat> recupererContrats();
    Set<Contrat> findContrats();
    Contrat recupererContratByid(long idContrat);
}
