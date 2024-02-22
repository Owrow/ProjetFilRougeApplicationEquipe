package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired private ClientService cService;
	
	@PostMapping
	public ResponseEntity<Client> get(@RequestParam String username, @RequestParam String password) {
		Client user = cService.getByLoginAndPassword(username, password);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}
}
