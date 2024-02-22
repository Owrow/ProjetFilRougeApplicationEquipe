package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository repo;

    public Iterable<Table> findAll() {
        return repo.findAll();
    }

    public Table findById(int id) {
        return repo.findById(id).get();
    }

    public List<Table> findByEtatEqualsLibre() { return repo.findByEtatEquals("LIBRE");}
    public List<Table> findByEtatEqualsOCcupee() { return repo.findByEtatEquals("OCCUPEE");}
     public List<Table> findByEtatEqualsReservee() { return repo.findByEtatEquals("RESERVEE");}
}



