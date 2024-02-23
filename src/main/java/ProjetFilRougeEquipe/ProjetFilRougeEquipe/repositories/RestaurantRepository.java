package ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories;



import org.springframework.data.repository.CrudRepository;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	
}
