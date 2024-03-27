package ProjetFilRougeEquipe.ProjetFilRougeEquipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.dto.CommandeDTO;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Commande;

@SpringBootTest
class CommandeServiceTest {
	@Autowired 
	private CommandeService service;


	@Test
	@Sql("classpath:commande_insertion.sql")
	void testFindCdeById() {
		Commande commande = service.findCdeById(1);
		
		assertEquals(1, commande.getId());
		assertEquals(1, commande.getClient().getId());
		assertEquals(5, commande.getTable().getId());
		assertEquals("REGLEE", commande.getEtat());
		assertEquals(40.97F, commande.getMontant());
	}

	@Test
	void testFindCdeDTOById() {
		CommandeDTO commandeDto = service.findCdeDTOById(1);
		
		assertEquals(1, commandeDto.getId());
		assertEquals(1, commandeDto.getIdClient());
		assertEquals(5, commandeDto.getIdTable());
		assertEquals("REGLEE", commandeDto.getEtatCommande());
		assertEquals(40.97F, commandeDto.getMontant());
	}

	@Test
	@Sql("classpath:commande_insertion.sql")
	void testOuvertureCde() {

	service.ouvertureCde(1,1);
	
	Commande commandeOuverte = service.findCdeById(2);
	
	assertEquals("OPEN", commandeOuverte.getEtat());
	assertEquals(1, commandeOuverte.getClient().getId());
	assertEquals(1, commandeOuverte.getTable().getId());
	assertEquals("PRESENT", commandeOuverte.getTable().getEtat());
	
	}

	@Test
	void testAjouterPlatCde() {
		fail("Not yet implemented");
	}

	@Test
	void testModifierStatutCommande() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculerMontantTotal() {
		fail("Not yet implemented");
	}

}
