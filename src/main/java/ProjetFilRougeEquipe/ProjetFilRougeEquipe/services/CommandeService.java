package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
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

}
