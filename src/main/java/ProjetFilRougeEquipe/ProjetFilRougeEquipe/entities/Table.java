package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "tables")
@Data
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private int nombre_places;

}