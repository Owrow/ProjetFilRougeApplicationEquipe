package ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TableDTO {

	private int id;
	private int numero;
	private int nombrePlaces;
	private String etat;


	public TableDTO() {
		// TODO Auto-generated constructor stub
	}


	public TableDTO(Table table) {
		super();
		this.id = table.getId();
		this.numero = table.getNumero();
		this.nombrePlaces = table.getNombrePlaces();
		this.etat = table.getEtat();

	}
	
	}
	

