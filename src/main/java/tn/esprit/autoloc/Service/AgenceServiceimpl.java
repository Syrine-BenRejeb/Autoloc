package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Repository.AgenceRepo;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgenceServiceimpl implements IAgence {
    private final AgenceRepo agenceRepo;

    @Override
    public Agence ajouterAgence(Agence ag) {
        agenceRepo.save(ag);
        return ag;
    }

    @Override
    public void supprimerAgence(long idAgence) {
        agenceRepo.deleteById(idAgence);
    }

    @Override
    public List<Agence> recupererAgences() {
        return agenceRepo.findAll();
    }

    @Override
    public Set<Agence> findAgences() {
        return (Set<Agence>) agenceRepo.findAll();
    }

    @Override
    public Agence recupererAgenceByid(long idAgence) {
        return agenceRepo.findById(idAgence).get();
    }
}
