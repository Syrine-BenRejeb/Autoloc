package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Repository.ReservationRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {
    private final ReservationRepo reservationRepo;

    @Override
    public Reservation ajouterReservation(Reservation re) {
        reservationRepo.save(re);
        return re;
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Set<Reservation> findReservations() {
        return (Set<Reservation>) reservationRepo.findAll();
    }

    @Override
    public Reservation recupererReservationByid(long idReservation) {
        return reservationRepo.findById(idReservation).get();
    }
}
