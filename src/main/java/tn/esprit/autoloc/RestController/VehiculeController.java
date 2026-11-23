package tn.esprit.autoloc.restcontroller;

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

    @PutMapping
    public Vehicule miseajourVehicule(@RequestBody Vehicule a) {
        return iVehicule.updateVehicule(a);
    }

    @PutMapping("/affecter/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule,
                                     @PathVariable Long idAgence) {
        return iVehicule.affecterVehicule(idVehicule, idAgence);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule,
                                       @PathVariable Long idEquipement) {
        return iVehicule.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule,
                                          @PathVariable Long idEquipement) {
        return iVehicule.desaffecterEquipement(idVehicule, idEquipement);
    }
}
