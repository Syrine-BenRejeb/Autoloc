package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Service.IAgence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/agence")
@RequiredArgsConstructor
@Tag(name="Gestion Agence")
public class AgenceController {
    private final IAgence iAgence;

    @PostMapping("/addAgence")
    public Agence addAgence(@RequestBody Agence a) {
        return iAgence.ajouterAgence(a);
    }

    @DeleteMapping("/deleteAgence/{id}")
    public void deleteAgence(@PathVariable Long id) {
        iAgence.supprimerAgence(id);
    }

    @GetMapping("/listAgence")
    public List<Agence> listAgence() {
        return iAgence.recupererAgences();
    }

    @GetMapping("/setAgence")
    public Set<Agence> setAgence() {
        return new HashSet<>(iAgence.findAgences());
    }

    @GetMapping("/{id}")
    public Agence getAgence(@PathVariable Long id) {
        return iAgence.recupererAgenceByid(id);
    }


}
