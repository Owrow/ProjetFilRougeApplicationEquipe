package ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ReservationDTO {
	
	private int id;
	private Client client;
	private int id_restaurant;
	private int id_table;
	private int tailleGroupe;
	private String etatReservation;
    private LocalDate dateReservation;
    private LocalTime heureReservation;
	
	public ReservationDTO() {
	}

	public ReservationDTO(Reservation reservation) {
		super();
		this.id = reservation.getId();
		this.client = reservation.getClient();
		this.id_restaurant = reservation.getRestaurant().getId();
		this.id_table = reservation.getTable().getId();
		this.tailleGroupe = reservation.getTailleGroupe();
		this.etatReservation = reservation.getEtat();
		this.dateReservation = reservation.getDateReservation();
		this.heureReservation = reservation.getHeureReservation();
	}
}
