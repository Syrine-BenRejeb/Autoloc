package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.Repository.AgenceRepo;
import tn.esprit.autoloc.Repository.EquipementRepo;
import tn.esprit.autoloc.Repository.VehiculeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {
    private final VehiculeRepo vehiculeRepo;
    private final AgenceRepo agenceRepo;
    private final EquipementRepo equipementRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule ve) {
        if (ve.getIdVehicule() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau véhicule ne doit pas avoir d'identifiant");
        }
        vehiculeRepo.save(ve);
        return ve;
    }

    @Override
    public void supprimerVehicule(long idVehicule) {
        if (!vehiculeRepo.existsById(idVehicule)) {
            throw new ResourceNotFoundException("Vehicule", idVehicule);
        }
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> recupererVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Set<Vehicule> findVehicules() {
        return new HashSet<>(vehiculeRepo.findAll());
    }

    @Override
    public Vehicule recupererVehiculeByid(long idVehicule) {
        return vehiculeRepo.findById(idVehicule).get();
    }

    @Override
    public Vehicule updateVehicule(Vehicule ve) {
        Vehicule existant = vehiculeRepo.findById(ve.getIdVehicule())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", ve.getIdVehicule()));

        existant.setImmatriculation(ve.getImmatriculation());
        existant.setMarque(ve.getMarque());
        existant.setModele(ve.getModele());
        existant.setCategorie(ve.getCategorie());
        existant.setTarifJournalier(ve.getTarifJournalier());
        existant.setStatut(ve.getStatut());
        existant.setAgence(ve.getAgence());

        return vehiculeRepo.save(existant);
    }

    @Override
    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));
        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", idAgence));
        vehicule.setAgence(agence);
        return vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));
        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", idEquipement));
        vehicule.getEquipements().add(equipement);
        return vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));
        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", idEquipement));
        vehicule.getEquipements().remove(equipement);
        return vehiculeRepo.save(vehicule);
    }
}
