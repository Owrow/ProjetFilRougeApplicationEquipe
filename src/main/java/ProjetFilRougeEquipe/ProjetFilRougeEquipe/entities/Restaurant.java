package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "restaurants")
@Data
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carte")
    @JsonIgnore
    private Carte carte;
    private String nom;
    private String adresse;
    private LocalTime ouverture;
    private LocalTime fermeture;



}