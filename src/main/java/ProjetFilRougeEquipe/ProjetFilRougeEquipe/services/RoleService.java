package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Role;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository rolerepo;
	
	public Role findRoleById(int id) {
		return rolerepo.findById(id).get();
		
	}
	

}
