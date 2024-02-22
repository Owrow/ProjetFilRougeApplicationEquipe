package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/logout")
public class LogoutController {
@Autowired private ClientService cService;

	@GetMapping
	public void logout(@RequestHeader("token") String token) {
		cService.logout(token);
	}
}
