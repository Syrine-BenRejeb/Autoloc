
package tn.esprit.autoloc.Service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ReservationResponseDTO;
import tn.esprit.autoloc.Entities.Reservation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReservationMapper {

    @Mapping(source = "client.nom", target = "nomClient")
    @Mapping(source = "client.prenom", target = "prenomClient")
    @Mapping(source = "vehicule.marque", target = "marqueVehicule")
    @Mapping(source = "vehicule.modele", target = "modeleVehicule")
    @Mapping(source = "vehicule.immatriculation",
            target = "immatriculationVehicule")
    ReservationResponseDTO toDto(Reservation reservation);

    List<ReservationResponseDTO> toDtoList(
            List<Reservation> reservations);
}
