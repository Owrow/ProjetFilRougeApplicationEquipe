package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "cartes")
@Data
public class Carte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "plats_cartes",
			joinColumns = {@JoinColumn(name = "id_carte")},
			inverseJoinColumns = {@JoinColumn(name = "id_plat")}
	)
    private List<Plat> plats;

}