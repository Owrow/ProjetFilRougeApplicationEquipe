package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@jakarta.persistence.Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Restaurant restaurant;
    private Client client;
    private Table table;
    private LocalDate dateReservation;
    private LocalTime heureReservation;
    private String etat;
    private int tailleGroupe;



}