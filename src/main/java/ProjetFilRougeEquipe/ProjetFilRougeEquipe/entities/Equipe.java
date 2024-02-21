package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

}