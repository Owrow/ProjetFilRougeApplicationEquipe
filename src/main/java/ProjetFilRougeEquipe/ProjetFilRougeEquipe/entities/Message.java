package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "messages")
@Data
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message_text;
    private Client client;
    private Restaurant restaurant;


}