package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
    private Role role;
    
    @OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private List<Commande> commandes;
  
}