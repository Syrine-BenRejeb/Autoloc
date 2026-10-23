package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Paiement;

import java.util.List;
import java.util.Set;

public interface IPaiement {
    Paiement ajouterPaiement(Paiement pa);
    public void supprimerPaiement(long idPaiement);
    List<Paiement> recupererPaiements();
    Set<Paiement> findPaiements();
    Paiement recupererPaiementByid(long idPaiement);
}
