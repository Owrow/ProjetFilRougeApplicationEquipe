package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "commandes")
@Data
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Client client;
	private Table table;
	private String etat;
}
