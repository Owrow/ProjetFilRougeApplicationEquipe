package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeRest {
	
	@Autowired
	private CommandeService cdeservice;
	
	@GetMapping
	public ResponseEntity<Iterable<Commande>> findAll() {
		return new ResponseEntity<>(cdeservice.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Commande> findCdeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(cdeservice.findCdeById(id), HttpStatus.OK);
	}

}
