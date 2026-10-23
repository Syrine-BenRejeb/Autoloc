package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Paiement;
import tn.esprit.autoloc.Service.IPaiement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/paiement")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiement iPaiement;

    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement a) {
        return iPaiement.ajouterPaiement(a);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void deletePaiement(@PathVariable Long id) {
        iPaiement.supprimerPaiement(id);
    }

    @GetMapping("/listPaiement")
    public List<Paiement> listPaiement() {
        return iPaiement.recupererPaiements();
    }

    @GetMapping("/setPaiement")
    public Set<Paiement> setPaiement() {
        return new HashSet<>(iPaiement.findPaiements());
    }

    @GetMapping("/{id}")
    public Paiement getPaiement(@PathVariable Long id) {
        return iPaiement.recupererPaiementByid(id);
    }


}
