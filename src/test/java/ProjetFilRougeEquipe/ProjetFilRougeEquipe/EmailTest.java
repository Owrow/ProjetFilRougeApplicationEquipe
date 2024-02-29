package ProjetFilRougeEquipe.ProjetFilRougeEquipe;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTest {

    @Autowired
    private EmailService emailService; // Assurez-vous que c'est le service qui envoie des e-mails

    @Autowired
    private ReservationRepository repo;

   @Test
  public void testSendEmail() {
        emailService.envoyerEmailSimple("test@example.com", "Test MailHog", "Ceci est un test.");
    }


}
