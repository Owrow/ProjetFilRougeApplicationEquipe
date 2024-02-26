package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired private ClientRepository repo;
	
	public void insert(Client user) {
		repo.save(user);
	}
	
	public Client getByLoginAndPassword(String login, String password) {
		Client user = repo.findByMailIsAndMdpIs(login, password);
		if (user != null) {
			user.setToken(generateToken());
			user.setExpirationTime(LocalDateTime.now().plusMinutes(30));
			repo.save(user);
		}
		return user;
	}
	
	public Client getByToken(String token) {
		Client user = repo.findByTokenIsAndExpirationTimeAfter(token, LocalDateTime.now());
		if (user != null) {
			user.setExpirationTime(LocalDateTime.now().plusMinutes(30));
			repo.save(user);
		}
		return user;
	}

	public void logout(String token) {
		Client user = repo.findByTokenIsAndExpirationTimeAfter(token, LocalDateTime.now());
		if (user != null) {
			user.setToken(null);
			user.setExpirationTime(null);
			repo.save(user);
		}
	}
	
	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Encoder base64encoder = Base64.getUrlEncoder();
	
	private String generateToken() {
		byte[] randomBytes = new byte[48];
		secureRandom.nextBytes(randomBytes);
		return base64encoder.encodeToString(randomBytes);
	}
}
