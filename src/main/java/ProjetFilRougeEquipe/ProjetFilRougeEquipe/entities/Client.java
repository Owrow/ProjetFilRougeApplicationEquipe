package ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities;

import jakarta.persistence.*;
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
    private int id_role;
}