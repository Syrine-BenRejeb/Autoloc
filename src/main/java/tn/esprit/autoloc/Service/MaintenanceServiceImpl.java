package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Repository.MaintenanceRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenance {
    private final MaintenanceRepo maintenanceRepo;

    @Override
    public Maintenance ajouterMaintenance(Maintenance ma) {
        maintenanceRepo.save(ma);
        return ma;
    }

    @Override
    public void supprimerMaintenance(long idMaintenance) {
        maintenanceRepo.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> recupererMaintenances() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Set<Maintenance> findMaintenances() {
        return (Set<Maintenance>) maintenanceRepo.findAll();
    }

    @Override
    public Maintenance recupererMaintenanceByid(long idMaintenance) {
        return maintenanceRepo.findById(idMaintenance).get();
    }
}
