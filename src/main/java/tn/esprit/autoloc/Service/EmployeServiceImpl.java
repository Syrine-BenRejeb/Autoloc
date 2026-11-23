package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.Repository.AgenceRepo;
import tn.esprit.autoloc.Repository.EmployeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {
    private final EmployeRepo employeRepo;
    private final AgenceRepo agenceRepo;

    @Override
    public Employe ajouterEmploye(Employe em) {
        if (em.getIdEmploye() != null) {
            throw new IllegalArgumentException(
                    "Un nouvel employe ne doit pas avoir d'identifiant");
        }
        employeRepo.save(em);
        return em;
    }

    @Override
    public void supprimerEmploye(long idEmploye) {
        if (!employeRepo.existsById(idEmploye)) {
            throw new ResourceNotFoundException("Employe", idEmploye);
        }
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeRepo.findAll();
    }

    @Override
    public Set<Employe> findEmployes() {
        return new HashSet<>(employeRepo.findAll());
    }

    @Override
    public Employe recupererEmployeByid(long idEmploye) {
        return employeRepo.findById(idEmploye).get();
    }

    @Override
    public Employe updateEmploye(Employe em) {
        Employe existant = employeRepo.findById(em.getIdEmploye())
                .orElseThrow(() -> new ResourceNotFoundException("Employe", em.getIdEmploye()));

        existant.setNom(em.getNom());
        existant.setPrenom(em.getPrenom());
        existant.setRole(em.getRole());
        existant.setAgence(em.getAgence());

        return employeRepo.save(existant);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", idEmploye));
        employe.setAgence(null);
        return employeRepo.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", idEmploye));
        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", idAgence));
        employe.setAgence(agence);
        return employeRepo.save(employe);
    }
}
