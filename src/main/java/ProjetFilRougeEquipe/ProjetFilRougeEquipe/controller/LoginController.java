package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EquipeService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired private EquipeService eService;
	
	@PostMapping
	public ResponseEntity<Equipe> get(@RequestParam String username, @RequestParam String password) {
		Equipe user = eService.getByLoginAndPassword(username, password);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}
}
