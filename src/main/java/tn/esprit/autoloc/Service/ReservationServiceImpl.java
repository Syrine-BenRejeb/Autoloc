
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Repository.ReservationRepo;
import tn.esprit.autoloc.DTO.ReservationResponseDTO;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepo reservationRepo;

    private final IReservationMapper reservationMapper;


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
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public Reservation recupererReservationByid(long idReservation) {
        return reservationRepo.findById(idReservation).get();
    }


    @Override
    public List<ReservationResponseDTO> recupererReservationsDTO() {

        List<Reservation> reservations = reservationRepo.findAll();

        return reservationMapper.toDtoList(reservations);
    }

    @Override
    public List<ReservationResponseDTO> recupererReservationsClient(Long idClient) {

        List<Reservation> reservations =
                reservationRepo.findByClient_IdClient(idClient);

        return reservationMapper.toDtoList(reservations);
    }
}
