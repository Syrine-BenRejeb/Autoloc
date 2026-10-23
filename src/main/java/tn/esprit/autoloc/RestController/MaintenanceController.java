package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Service.IMaintenance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenance iMaintenance;

    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance a) {
        return iMaintenance.ajouterMaintenance(a);
    }

    @DeleteMapping("/deleteMaintenance/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        iMaintenance.supprimerMaintenance(id);
    }

    @GetMapping("/listMaintenance")
    public List<Maintenance> listMaintenance() {
        return iMaintenance.recupererMaintenances();
    }

    @GetMapping("/setMaintenance")
    public Set<Maintenance> setMaintenance() {
        return new HashSet<>(iMaintenance.findMaintenances());
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenance(@PathVariable Long id) {
        return iMaintenance.recupererMaintenanceByid(id);
    }


}
