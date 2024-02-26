package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;

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

    public Table EstPresent(int id_table){
    	Table table = repo.findById(id_table).get();
        table.setEtat("OCCUPEE");
        repo.save(table);
        return table ;
    }
    
    public Table changementEtat(int id, String etat) {
    	Table table = repo.findById(id).get();
    	table.setEtat(etat);
    	repo.save(table);
    	return table;
    }
}



