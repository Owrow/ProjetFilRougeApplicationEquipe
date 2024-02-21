package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService{

    @Autowired
    private ReservationRepository repo;

    public Iterable<Reservation> findAll() {
        return repo.findAll();
    }

    public Reservation findById(int id) {
        return repo.findById(id).get();
    }



}