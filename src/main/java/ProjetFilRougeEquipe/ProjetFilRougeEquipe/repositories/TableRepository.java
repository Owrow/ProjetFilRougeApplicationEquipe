package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;


import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<Table, Integer> {

    public List<Table> findByEtatEquals(String etat);


}
