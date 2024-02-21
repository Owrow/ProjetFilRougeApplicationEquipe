package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "plats")
@Data
public class Plat{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private float prix;
    private List<Carte> cartes;

    private Categorie categorie;
}