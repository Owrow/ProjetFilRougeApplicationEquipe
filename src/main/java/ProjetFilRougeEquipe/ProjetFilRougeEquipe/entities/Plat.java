package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "plats")
@Data
public class Plat{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String descriptionPlat;
    private float prix;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="cartes")
    private List<Carte> cartes;

    @OneToOne(
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "id_categorie")
    private Categorie categorie;
}