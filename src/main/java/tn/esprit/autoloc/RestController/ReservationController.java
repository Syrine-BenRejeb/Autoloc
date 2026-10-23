package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Service.IReservation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservation iReservation;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation a) {
        return iReservation.ajouterReservation(a);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        iReservation.supprimerReservation(id);
    }

    @GetMapping("/listReservation")
    public List<Reservation> listReservation() {
        return iReservation.recupererReservations();
    }

    @GetMapping("/setReservation")
    public Set<Reservation> setReservation() {
        return new HashSet<>(iReservation.findReservations());
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return iReservation.recupererReservationByid(id);
    }



}
