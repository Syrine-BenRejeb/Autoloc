
package tn.esprit.autoloc.DTO;

import lombok.*;
import tn.esprit.autoloc.Entities.StatutReservation;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {

    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private StatutReservation statut;

    private String nomClient;
    private String prenomClient;

    private String marqueVehicule;
    private String modeleVehicule;
    private String immatriculationVehicule;
}
