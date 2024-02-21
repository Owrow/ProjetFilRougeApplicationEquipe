package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "commandes")
@Data
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Client client;
	private Table table;
	private String etat;
}
