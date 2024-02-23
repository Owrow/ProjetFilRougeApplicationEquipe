package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<Reservation> findAll() {
        return repo.findAll();
    }

    public Reservation findById(int id) {
        return repo.findById(id).get();
    }

    public boolean acceptReservation(int id_reservation, int id_table) {
        Reservation reservation = repo.findById(id_reservation).get();
        Table table =  tableRepo.findById(id_table).get();

        if (table.getNombrePlaces() < reservation.getTailleGroupe() || !table.getEtat().contains("LIBRE")) {
        	return false;
        } 
        	reservation.setTable(table);
        	reservation.setEtat("RESERVEE");
        	table.setEtat("RESERVEE");
        	repo.save(reservation);
        	tableRepo.save(table);
            return true;
        
    }
    
    public Reservation refuseReservation(int id_reservation) {
    	Reservation reservation = repo.findById(id_reservation).get();
    	reservation.setEtat("REFUSEE");
    	repo.save(reservation);
    	return reservation;
    }
    
    
    public Boolean EstPresent(int id_reservation){
    	Reservation reservation = repo.findById(id_reservation).get();
        reservation.setEtat("RESERVED");
         repo.save(reservation);
         return true ;
    	}
    }




