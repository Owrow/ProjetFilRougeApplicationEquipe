package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.EquipeDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EquipeService;

@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeRest {

	@Autowired
	private EquipeService eqservice;
	
	@GetMapping
	public ResponseEntity<Iterable<EquipeDTO>> findAll() {
		return new ResponseEntity<>(eqservice.findAllEquipe(), HttpStatus.OK);
	}
	
	
	@GetMapping(path="/{id}")
	public ResponseEntity<EquipeDTO> findEquipeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(eqservice.findEquipeDtoById(id), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Equipe> creationEquipier(@RequestParam int id_role, @RequestParam int id_restaurant, @RequestParam String identifiant) {
		Equipe equipe = eqservice.creationEquipier(id_role, id_restaurant, identifiant);
		return new ResponseEntity<>(equipe,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteEquipier(@PathVariable int id) {
	    eqservice.deleteEquipier(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}

	
}

