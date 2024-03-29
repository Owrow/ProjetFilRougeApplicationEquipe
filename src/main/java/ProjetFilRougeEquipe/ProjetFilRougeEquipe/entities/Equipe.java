package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "equipes")
@Data
public class Equipe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  identifiant;

    private String mdp;
	private String token;
	private LocalDateTime expirationTime;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

}