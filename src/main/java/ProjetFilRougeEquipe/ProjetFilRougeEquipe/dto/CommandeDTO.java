package ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto;

import java.util.List;
import java.util.stream.Collectors;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Plat;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommandeDTO {

	private int id;
	private int idClient;
	private int idTable;
	private List<PlatDTO> plats;
	private String etatCommande;
	private float montant;

	
	public CommandeDTO() {
		super();
	}


	public CommandeDTO(Commande commande) {
		super();
		this.id = commande.getId();
		this.idClient = commande.getClient().getId();
		this.idTable = commande.getTable().getId();
		this.plats = commande.getPlats().stream().map(plat -> new PlatDTO(plat)).collect(Collectors.toList());		
		this.etatCommande = commande.getEtat();
		this.montant = commande.getMontant();
	
	}
	
}
