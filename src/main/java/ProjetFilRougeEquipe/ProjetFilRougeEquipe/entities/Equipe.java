package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.management.relation.Role;
import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "equipes")
@Data
public class Equipe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  identifiant;

    private String motDePasse;

    private Role role;

    private Restaurant restaurant;

}