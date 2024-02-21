package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "tables")
@Data
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private int nombrePlaces;

}