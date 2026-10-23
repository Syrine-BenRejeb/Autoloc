package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Equipement;
import tn.esprit.autoloc.Service.IEquipement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/equipement")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipement iEquipement;

    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement a) {
        return iEquipement.ajouterEquipement(a);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable Long id) {
        iEquipement.supprimerEquipement(id);
    }

    @GetMapping("/listEquipement")
    public List<Equipement> listEquipement() {
        return iEquipement.recupererEquipements();
    }

    @GetMapping("/setEquipement")
    public Set<Equipement> setEquipement() {
        return new HashSet<>(iEquipement.findEquipements());
    }

    @GetMapping("/{id}")
    public Equipement getEquipement(@PathVariable Long id) {
        return iEquipement.recupererEquipementByid(id);
    }


}
