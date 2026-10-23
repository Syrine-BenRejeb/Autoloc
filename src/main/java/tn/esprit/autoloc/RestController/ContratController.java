package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Contrat;
import tn.esprit.autoloc.Service.IContrat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/contrat")
@RequiredArgsConstructor
public class ContratController {
    private final IContrat iContrat;

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat a) {
        return iContrat.ajouterContrat(a);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable Long id) {
        iContrat.supprimerContrat(id);
    }

    @GetMapping("/listContrat")
    public List<Contrat> listContrat() {
        return iContrat.recupererContrats();
    }

    @GetMapping("/setContrat")
    public Set<Contrat> setContrat() {
        return new HashSet<>(iContrat.findContrats());
    }

    @GetMapping("/{id}")
    public Contrat getContrat(@PathVariable Long id) {
        return iContrat.recupererContratByid(id);
    }


}
