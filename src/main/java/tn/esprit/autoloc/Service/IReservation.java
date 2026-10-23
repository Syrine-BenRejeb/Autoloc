package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.Reservation;

import java.util.List;
import java.util.Set;

public interface IReservation {
    Reservation ajouterReservation(Reservation re);
    public void supprimerReservation(long idReservation);
    List<Reservation> recupererReservations();
    Set<Reservation> findReservations();
    Reservation recupererReservationByid(long idReservation);
}
