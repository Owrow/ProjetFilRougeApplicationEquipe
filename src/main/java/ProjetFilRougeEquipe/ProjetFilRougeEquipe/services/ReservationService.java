package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.ReservationDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;

@Service
public class ReservationService{

    @Autowired
    private ReservationRepository repo;

    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private EmailService emailService;

    public Iterable<Reservation> findAll() {
        return repo.findAll();
    }

    public Iterable<ReservationDTO> findAllResaDTO() {
		Iterable<Reservation> reservations = repo.findAll();
		 List<ReservationDTO> resaDTOList = new ArrayList<>();
		    for (Reservation reservation : reservations) {
		    	resaDTOList.add(new ReservationDTO(reservation));
		    }
		    return resaDTOList;
    }
    
    public Reservation findById(int id) {
        return repo.findById(id).get();
    }
    
    public ReservationDTO findResaDTOById(int id) 
    {
    	Reservation reservation = repo.findById(id).get();
    	ReservationDTO resaDTO = new ReservationDTO(reservation);
        return resaDTO;
        
    }
    

    public Reservation acceptReservation(int id_reservation, int id_table) {
        Reservation reservation = repo.findById(id_reservation).get();
        ReservationDTO	reservationDTO = new ReservationDTO(reservation);
        Table table =  tableRepo.findById(id_table).get();

        if (table.getNombrePlaces() < reservation.getTailleGroupe() || !table.getEtat().contains("LIBRE")) {
        	return null;
        } 
        	reservation.setTable(table);
        	reservation.setEtat("RESERVEE");
        	table.setEtat("RESERVEE");
        	repo.save(reservation);
        	tableRepo.save(table);
            mailClientAcceptResa(id_reservation);
            return reservation;
        
    }
    
    public Reservation refuseReservation(int id_reservation) {
    	Reservation reservation = repo.findById(id_reservation).get();
    	reservation.setEtat("REFUSEE");
    	repo.save(reservation);
        mailClientRefuseResa(id_reservation);
    	return reservation;
    }
    
    
    public Reservation EstPresent(int id_reservation){
    	Reservation reservation = repo.findById(id_reservation).get();
        reservation.setEtat("RESERVED");
         repo.save(reservation);
         return reservation ;
    	}

    public void mailClientAcceptResa(int id_reservation) {
        Reservation reservation = repo.findById(id_reservation).get();
        String destinataire = reservation.getClient().getMail();
        String sujet = "Notification de Réservation";
        String contenu = "Votre réservation a été confirmée, nous vous attendons le"
                + reservation.getDateReservation() + " à " + reservation.getHeureReservation() + ". Nous sommes trés heureux de vous recevoir dans notre établissement";
        emailService.envoyerEmailSimple(destinataire, sujet, contenu);
    }
  public void mailClientRefuseResa(int id_reservation) {
        Reservation reservation = repo.findById(id_reservation).get();
        String destinataire = reservation.getClient().getMail();
        String sujet = "Notification de Réservation";
        String contenu = "Malheureusement nous ne pouvons accepter votre reservation car le restaurant est complet.";
        emailService.envoyerEmailSimple(destinataire, sujet, contenu);
    }



    }




