package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;


import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean acceptOrRefuseReservation(Reservation reservation) {
        List<Table> tablesLibres = tableRepo.findByEtat("LIBRE");
        for (Table table: tablesLibres) {
            Table tableDisponible;
            if (table.getNombrePlaces() >= reservation.getTailleGroupe()) {
                tableDisponible = table;
                reservation.setTable(tableDisponible);
                reservation.setEtat("RESERVEE");
                tableDisponible.setEtat("RESERVEE");
                repo.save(reservation);
                tableRepo.save(tableDisponible);
                break;
            }
            return true;
        }
        return false;
    }

    public Boolean EstPresent(Reservation reservation){
        reservation.setEtat("RESERVED");
         repo.save(reservation);
         return true ;
    }
       }




