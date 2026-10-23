package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Service.IVehicule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehicule iVehicule;

    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule a) {
        return iVehicule.ajouterVehicule(a);
    }

    @DeleteMapping("/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        iVehicule.supprimerVehicule(id);
    }

    @GetMapping("/listVehicule")
    public List<Vehicule> listVehicule() {
        return iVehicule.recupererVehicules();
    }

    @GetMapping("/setVehicule")
    public Set<Vehicule> setVehicule() {
        return new HashSet<>(iVehicule.findVehicules());
    }

    @GetMapping("/{id}")
    public Vehicule getVehicule(@PathVariable Long id) {
        return iVehicule.recupererVehiculeByid(id);
    }



}
