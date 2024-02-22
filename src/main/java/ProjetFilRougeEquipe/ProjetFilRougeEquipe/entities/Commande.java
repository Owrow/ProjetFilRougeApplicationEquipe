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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "commandes")
@Data
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "id_client")
	private Client client;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_table")
	private Table table;
	
	 @ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(
				name = "plats_commandes",
				joinColumns = {@JoinColumn(name = "id_commande")},
				inverseJoinColumns = {@JoinColumn(name = "id_plat")}
		)
	 private List<Plat> plats;
	
	private String etat;
}
