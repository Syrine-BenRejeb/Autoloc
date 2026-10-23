package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Service.IEmploye;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/employe")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmploye iEmploye;

    @PostMapping("/addEmploye")
    public Employe addEmploye(@RequestBody Employe a) {
        return iEmploye.ajouterEmploye(a);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        iEmploye.supprimerEmploye(id);
    }

    @GetMapping("/listEmploye")
    public List<Employe> listEmploye() {
        return iEmploye.recupererEmployes();
    }

    @GetMapping("/setEmploye")
    public Set<Employe> setEmploye() {
        return new HashSet<>(iEmploye.findEmployes());
    }

    @GetMapping("/{id}")
    public Employe getEmploye(@PathVariable Long id) {
        return iEmploye.recupererEmployeByid(id);
    }


}
