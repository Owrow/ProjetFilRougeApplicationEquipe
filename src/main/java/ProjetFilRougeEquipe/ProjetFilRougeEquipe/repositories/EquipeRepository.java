package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;

public interface EquipeRepository extends CrudRepository<Equipe, Integer>{

	public Equipe findByTokenIsAndExpirationTimeAfter(String token, LocalDateTime expirationTime);
	
	public Equipe findByIdentifiantIsAndMdpIs(String username, String password);
}
