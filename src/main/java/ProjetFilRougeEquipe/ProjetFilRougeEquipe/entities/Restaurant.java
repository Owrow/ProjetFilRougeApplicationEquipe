package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;

@Entity
@jakarta.persistence.Table(name = "restaurants")
@Data
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Carte carte;
    private String nom;
    private String adresse;
    private LocalTime ouverture;
    private LocalTime fermeture;

}