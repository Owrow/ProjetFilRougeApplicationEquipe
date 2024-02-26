package ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EquipeService;

@RestController
@CrossOrigin
@RequestMapping("/logout")
public class LogoutController {
@Autowired private EquipeService eService;

	@GetMapping
	public void logout(@RequestHeader("token") String token) {
		eService.logout(token);
	}
}
