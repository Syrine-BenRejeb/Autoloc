package tn.esprit.autoloc.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idVehicule ;
    String immatriculation;
    String marque;
    String modele;
    @Enumerated(EnumType.STRING)
    CategorieVehicule categorie;

    BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    StatutVehicule statut;


    @ManyToOne
    Agence agence;

    @OneToMany(mappedBy = "vehicule")
    Set<Maintenance> maintenances;

    @ManyToMany
    Set<Equipement> equipements;

    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations;
}
