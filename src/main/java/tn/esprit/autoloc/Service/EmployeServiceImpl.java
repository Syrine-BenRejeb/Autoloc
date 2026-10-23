package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Repository.EmployeRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {
    private final EmployeRepo employeRepo;

    @Override
    public Employe ajouterEmploye(Employe em) {
        employeRepo.save(em);
        return em;
    }

    @Override
    public void supprimerEmploye(long idEmploye) {
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeRepo.findAll();
    }

    @Override
    public Set<Employe> findEmployes() {
        return (Set<Employe>) employeRepo.findAll();
    }

    @Override
    public Employe recupererEmployeByid(long idEmploye) {
        return employeRepo.findById(idEmploye).get();
    }
}
