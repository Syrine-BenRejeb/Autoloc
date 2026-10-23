package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Repository.PaiementRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiement {
    private final PaiementRepo paiementRepo;

    @Override
    public Paiement ajouterPaiement(Paiement pa) {
        paiementRepo.save(pa);
        return pa;
    }

    @Override
    public void supprimerPaiement(long idPaiement) {
        paiementRepo.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> recupererPaiements() {
        return paiementRepo.findAll();
    }

    @Override
    public Set<Paiement> findPaiements() {
        return (Set<Paiement>) paiementRepo.findAll();
    }

    @Override
    public Paiement recupererPaiementByid(long idPaiement) {
        return paiementRepo.findById(idPaiement).get();
    }
}
