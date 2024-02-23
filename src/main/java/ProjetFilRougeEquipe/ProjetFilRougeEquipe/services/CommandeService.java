package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.CommandeDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Plat;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Table;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.CommandeRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.PlatRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.TableRepository;

@Service
public class CommandeService {
	
	@Autowired
	private CommandeRepository cderepo;
	@Autowired
	private TableRepository tablerepo;
	@Autowired
	private PlatRepository platrepo;
	
	public Iterable<CommandeDTO> findAll() {
		Iterable<Commande> commandes = cderepo.findAll();
		 List<CommandeDTO> dtoList = new ArrayList<>();
		    for (Commande commande : commandes) {
		        dtoList.add(new CommandeDTO(commande));
		    }
		    return dtoList;
	}
	
	public CommandeDTO findCdeById(int id) {
		Commande commande =  cderepo.findById(id).get();
		CommandeDTO cdeDTO = new CommandeDTO(commande);
		return cdeDTO;
	}
	
	public Commande ouvertureCde(int id_client, int id_table) {
		Commande newCde = new Commande();
		Client newClient = new Client();
		Table tableAssociee = tablerepo.findById(id_table).get() ;
		
		newClient.setId(id_client);
		
		
		newCde.setClient(newClient);
		newCde.setTable(tableAssociee);	
		
		newCde.setEtat("OPEN");
		
		tableAssociee.setEtat("PRESENT");
		tablerepo.save(tableAssociee);
		return cderepo.save(newCde);
		}
	
	public Commande ajouterPlatCde(int id_commande, int id_plat) {
		Plat platAjoutCommande = platrepo.findById(id_plat).get();
		Commande commande = cderepo.findById(id_commande).get();
		List<Plat> plats = commande.getPlats();
		
		plats.add(platAjoutCommande);
		
	
		return cderepo.save(commande);
		
	}
	

}
