package ProjetFilRougeEquipe.ProjetFilRougeEquipe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ProjetFilRougeEquipeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjetFilRougeEquipeApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetFilRougeEquipeApplication.class, args);
		log.info("Message informatif");
		log.warn("Message d'avertissement");
	}
	
	

}
