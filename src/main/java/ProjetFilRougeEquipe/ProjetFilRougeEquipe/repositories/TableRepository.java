package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;


import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<Table, Integer> {

    List<Table> findByEtatEquals(String etat);
     List<Table> findByEtat(String etat);
}
