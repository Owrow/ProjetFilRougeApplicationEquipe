package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService{

    @Autowired
    private ReservationRepository repo;

    @Autowired
    private TableRepository tableRepo;


    @Autowired
    private TableService tableService;



    public Iterable<Reservation> findAll() {
        return repo.findAll();
    }

    public Reservation findById(int id) {
        return repo.findById(id).get();
    }

    public boolean AcceptOrRefuseReservation(int id, Table table){
        Reservation reservation = repo.findById(id).get();
       Iterable<Table> tableLibre = tableService.findByEtatEqualsLibre();
       for( Table currentTable : tableLibre ) {
           if (reservation.getTailleGroupe() == currentTable.getNombrePlaces()) {
               table.setEtat("RESERVEE");
               tableRepo.save(table);
           }
            if(currentTable.getEtat().equals("RESERVEE") || currentTable.getEtat().equals("OCCUPEE")){
                       return false;
                   }
               }

        return true;
    }


    public Boolean EstPresent(Reservation reservation){
        reservation.setEtat("RESERVED");
         repo.save(reservation);
         return true ;
    }
       }




