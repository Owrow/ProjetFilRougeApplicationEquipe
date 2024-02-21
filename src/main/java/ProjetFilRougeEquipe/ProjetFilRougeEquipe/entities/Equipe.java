package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

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

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

}