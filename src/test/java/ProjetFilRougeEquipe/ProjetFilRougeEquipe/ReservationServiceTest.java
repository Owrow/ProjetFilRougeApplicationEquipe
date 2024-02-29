package ProjetFilRougeEquipe.ProjetFilRougeEquipe;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Client;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Reservation;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.repositories.ReservationRepository;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EmailService;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository repo; // Suppose que c'est l'interface pour les opérations de base de données

    @Mock
    private EmailService emailService; // Le service d'envoi d'e-mails

    @InjectMocks
    private ReservationService reservationService; // Le service contenant la méthode `mailClientAcceptResa`

    @Test
    public void mailClientAcceptResaTest() {
        // Configuration des mocks
        int id_reservation = 1;
        Reservation reservationMock = new Reservation();
        reservationMock.setId(id_reservation);
        reservationMock.setDateReservation(LocalDate.parse("2024-02-24"));
        reservationMock.setHeureReservation(LocalTime.parse("18:00"));
        Client clientMock = new Client();
        clientMock.setMail("client@example.com");
        reservationMock.setClient(clientMock);

        when(repo.findById(id_reservation)).thenReturn(Optional.of(reservationMock));

        // Appel de la méthode à tester
        reservationService.mailClientAcceptResa(id_reservation);

        // Vérification que la méthode envoyerEmailSimple a été appelée avec les bons paramètres
        String contenuAttendu = "Votre réservation a été confirmée, nous vous attendons le"
                + reservationMock.getDateReservation() + " à " + reservationMock.getHeureReservation()
                + ". Nous sommes trés heureux de vous recevoir dans notre établissement";
        verify(emailService).envoyerEmailSimple(clientMock.getMail(), "Notification de Réservation", contenuAttendu);
    }
}
