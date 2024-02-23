package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Restaurant;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restorepo;
	
	private Restaurant findRestoById(int id) {
		return restorepo.findById(id).get();
	}
	

}
