package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.PlatDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Plat;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.PlatRepository;

@Service
public class PlatService {
	@Autowired
	private PlatRepository platrepo;
	
	public Iterable<PlatDTO> findAll() {
		Iterable<Plat> plats = platrepo.findAll();
		List<PlatDTO> dtoList = new ArrayList<>();
		for (Plat plat : plats) {
			dtoList.add(new PlatDTO(plat));
		}
		return dtoList;
	}
}
