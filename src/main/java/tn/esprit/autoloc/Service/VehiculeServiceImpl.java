package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repository.VehiculeRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {
    private final VehiculeRepo vehiculeRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule ve) {
        vehiculeRepo.save(ve);
        return ve;
    }

    @Override
    public void supprimerVehicule(long idVehicule) {
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> recupererVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Set<Vehicule> findVehicules() {
        return (Set<Vehicule>) vehiculeRepo.findAll();
    }

    @Override
    public Vehicule recupererVehiculeByid(long idVehicule) {
        return vehiculeRepo.findById(idVehicule).get();
    }
}
