package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.EquipeDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Restaurant;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Role;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.EquipeRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.RestaurantRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.RoleRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository eqrepo;

	@Autowired
	private RoleRepository rolerepo;

	@Autowired
	private RestaurantRepository restorepo;

	public Iterable<EquipeDTO> findAllEquipe() {
		Iterable<Equipe> equipes = eqrepo.findAll();
		List<EquipeDTO> equipeList = new ArrayList<>();
		for (Equipe current : equipes) {
			equipeList.add(new EquipeDTO(current));
		}
		return equipeList;

	}

	public Equipe findById(int id) {
		Equipe equipe = eqrepo.findById(id).get();
		return equipe;
	}

	public EquipeDTO findEquipeDtoById(int id) {
		Equipe equipe = eqrepo.findById(id).get();
		EquipeDTO eqdto = new EquipeDTO(equipe);
		return eqdto;

	}

	public Equipe creationEquipier(int id_role, int id_restaurant, String identifiant) {
		Equipe newEquipier = new Equipe();
		Role associerRole = rolerepo.findById(id_role).get();
		Restaurant associerResto = restorepo.findById(id_restaurant).get();

		newEquipier.setRole(associerRole);
		newEquipier.setRestaurant(associerResto);
		newEquipier.setIdentifiant(identifiant);

		Random randomMdp = new Random();
		int nombreAleatoire = randomMdp.nextInt(10000);
		String mdpAleatoire = String.format("%04d", nombreAleatoire);
		newEquipier.setMdp(mdpAleatoire);

		eqrepo.save(newEquipier);

		return newEquipier;

	}

	public Equipe deleteEquipier(int id) {
		Equipe equipe = eqrepo.findById(id)	.get();	
		eqrepo.delete(equipe);
		return equipe;

	}
}
