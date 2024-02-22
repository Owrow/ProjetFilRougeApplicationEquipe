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
	
	public Iterable<Commande> findAll() {
		return cderepo.findAll();
	}
	
	public Commande findCdeById(int id) {
		return cderepo.findById(id).get();
	}
	
	public Commande ouvertureCde(int id_client, int id_table) {
		Commande newCde = new Commande();
		Client newClient = new Client();
		Table newTable = new Table();
		
		newClient.setId(id_client);
		newTable.setId(id_table);
		
		newCde.setClient(newClient);
		newCde.setTable(newTable);		
		
		newCde.setEtat("OPEN");
		return cderepo.save(newCde);
		
	
		
	}
	

}
