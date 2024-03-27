package ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto;

import java.util.List;
import java.util.stream.Collectors;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Plat;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlatDTO {
	private int id;
	private String nom;
	private String descriptionPlat;
	private float prix;
	private String Categorie;
	
	public PlatDTO() {
		super();
	}
	
	public PlatDTO (Plat plat) {
		super();
		this.id = plat.getId();
		this.nom = plat.getNom();
		this.descriptionPlat = plat.getDescriptionPlat();
		this.prix = plat.getPrix();
		this.Categorie = plat.getCategorie().getNom();
	}
}
