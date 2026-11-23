
package tn.esprit.autoloc.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
}
