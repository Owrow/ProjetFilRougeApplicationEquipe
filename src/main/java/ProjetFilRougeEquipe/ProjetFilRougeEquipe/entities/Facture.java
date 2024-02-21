package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "factures")
@Data
public class Facture{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Commande commande;

    private String etat;
}