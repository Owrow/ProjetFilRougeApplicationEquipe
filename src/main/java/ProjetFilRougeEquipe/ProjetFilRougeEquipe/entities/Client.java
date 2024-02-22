package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String mdp;
	private String token;
	private LocalDateTime expirationTime;
    
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
    private Role role;
    

  
}