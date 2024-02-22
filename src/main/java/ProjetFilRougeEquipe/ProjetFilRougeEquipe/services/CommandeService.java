package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.CommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
	private CommandeRepository cderepo;
	private TableRepository tablerepo;
	
	public Iterable<Commande> findAll() {
		return cderepo.findAll();
	}
	
	public Commande findCdeById(int id) {
		return cderepo.findById(id).get();
	}
	
	public Commande ouvertureCde(int id_client, int id_table) {
		Commande newCde = new Commande();
		Client newClient = new Client();
		Table tableAssociee = tablerepo.findById(id_table) ;
		
		newClient.setId(id_client);
		
		
		newCde.setClient(newClient);
		newCde.setTable(tableAssociee.getId());		
		
		newCde.setEtat("OPEN");
		
		tableAssociee.setEtat("PRESENT");
		tablerepo.save(tableAssociee);
		return cderepo.save(newCde);
		
	
		
	}
	

}
