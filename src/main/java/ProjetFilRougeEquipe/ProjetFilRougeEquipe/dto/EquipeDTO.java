package ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipeDTO {

	private int id;
	private int idRole;
	private int idResto;
	private String identifiant;
	private String mdp;

	public EquipeDTO() {
		super();
	}

	public EquipeDTO(Equipe equipe) {
		super();
		this.id = equipe.getId();
		this.idRole = equipe.getRole().getId();
		this.idResto = equipe.getRestaurant().getId();
		this.identifiant = equipe.getIdentifiant();
		this.mdp = equipe.getMdp();

	}

}
