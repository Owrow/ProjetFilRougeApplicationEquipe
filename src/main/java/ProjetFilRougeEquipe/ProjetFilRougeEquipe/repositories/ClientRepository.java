package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{
	public Client findByTokenIsAndExpirationTimeAfter(String token, LocalDateTime expirationTime);
	
	public Client findByMailIsAndMdpIs(String username, String password);
	
}
