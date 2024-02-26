package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private String etat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    @JsonIgnore
    private Restaurant restaurant;
    
}