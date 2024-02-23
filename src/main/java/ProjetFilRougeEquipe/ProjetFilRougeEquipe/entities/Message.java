package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "messages")
@Data
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messageText;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

}