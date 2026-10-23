package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Repository.ContratRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContrat {
    private final ContratRepo contratRepo;

    @Override
    public Contrat ajouterContrat(Contrat co) {
        contratRepo.save(co);
        return co;
    }

    @Override
    public void supprimerContrat(long idContrat) {
        contratRepo.deleteById(idContrat);
    }

    @Override
    public List<Contrat> recupererContrats() {
        return contratRepo.findAll();
    }

    @Override
    public Set<Contrat> findContrats() {
        return (Set<Contrat>) contratRepo.findAll();
    }

    @Override
    public Contrat recupererContratByid(long idContrat) {
        return contratRepo.findById(idContrat).get();
    }
}
