package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;

public interface TableRepository extends CrudRepository<Table, Integer> {

    List<Table> findByEtatEquals(String etat);
     List<Table> findByEtat(String etat);
}
