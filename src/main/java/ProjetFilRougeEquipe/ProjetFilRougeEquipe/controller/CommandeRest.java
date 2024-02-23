package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.CommandeDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeRest {
	
	private static final Logger log = LoggerFactory.getLogger(CommandeRest.class);
	
	@Autowired
	private CommandeService cdeservice;
	
	@GetMapping
	public ResponseEntity<Iterable<CommandeDTO>> findAll() {
			return new ResponseEntity<>(cdeservice.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<CommandeDTO> findCdeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(cdeservice.findCdeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> ouvertureCde(@RequestBody Commande commande) {
		cdeservice.ouvertureCde(commande.getClient().getId(), commande.getTable().getId());
		log.info("Nouvelle commande ouverte : {}", commande);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/id")
	public ResponseEntity<Commande> ajouterPlatCde(@RequestParam int id_commande, @RequestParam int id_plat) {
		
		cdeservice.ajouterPlatCde(id_commande, id_plat);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}
