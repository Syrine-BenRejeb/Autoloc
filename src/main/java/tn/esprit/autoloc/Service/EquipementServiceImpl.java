package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Repository.EquipementRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipement {
    private final EquipementRepo equipementRepo;

    @Override
    public Equipement ajouterEquipement(Equipement eq) {
        equipementRepo.save(eq);
        return eq;
    }

    @Override
    public void supprimerEquipement(long idEquipement) {
        equipementRepo.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> recupererEquipements() {
        return equipementRepo.findAll();
    }

    @Override
    public Set<Equipement> findEquipements() {
        return (Set<Equipement>) equipementRepo.findAll();
    }

    @Override
    public Equipement recupererEquipementByid(long idEquipement) {
        return equipementRepo.findById(idEquipement).get();
    }
}
