package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "roles")
@Data
public class Role{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
}