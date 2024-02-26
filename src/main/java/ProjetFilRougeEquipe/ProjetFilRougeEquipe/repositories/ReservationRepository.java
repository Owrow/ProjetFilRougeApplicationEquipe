package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;

import java.time.LocalTime;

import org.springframework.data.repository.CrudRepository;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{


}