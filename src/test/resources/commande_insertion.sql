INSERT INTO roles (id, libelle) values (1,'USER'),(2,'TEAM'),(3,'ADMIN');
INSERT INTO categories (id, nom) VALUES (1,'Entrée'), (2,'Plat'), (3,'Dessert'), (4,'Boisson');

 
INSERT INTO cartes (id, nom) VALUES (1,'Printemps'), (2,'Eté'), (3,'Automne'), (4,'Hiver');
 

 
INSERT INTO plats (id, id_categorie, nom, description_plat, prix) VALUES  
    (1,1, 'Salade César', 'Salade verte, poulet grillé, parmesan, croûtons et sauce César', 8.99),    
    (2,2, 'Spaghetti Bolognese', 'Spaghetti avec une sauce à la viande', 12.99),
    (3,2, 'Poulet rôti', 'Poulet rôti avec légumes de saison', 15.99),  
    (4,3, 'Tiramisu', 'Dessert italien au mascarpone et café', 7.99),
    (5,3, 'Crème brûlée', 'Crème dessert avec une couche de sucre caramélisé', 6.49),  
    (6,4, 'Vin rouge', 'Bouteille de vin rouge de la région', 18.99);

INSERT INTO plats_cartes (id, id_carte, id_plat) VALUES
(1,4,1),
(2,4,2),
(3,4,3),
(4,4,4),
(5,4,5),
(6,4,6);

 
INSERT INTO restaurants (id, nom, id_carte, adresse, ouverture, fermeture) VALUES 
(1,'Pâte d''or Nantes', 4, '14 rue du Paradis 44000 NANTES', '12:00', '22:30'),
(2,'Pâte d''or Paris', 4, '28 rue des Arts 75001 Paris', '12:00', '22:30'),
(3,'Pâte d''or Lyon', 4, '55 boulevard des bouchons 69000 LYON', '12:00', '22:30'),
(4,'Pâte d''or Marseille', 4,'3 rue du Jardin 13000 MARSEILLE', '12:00', '22:30');


INSERT INTO clients (id, id_role, nom, prenom, mail, telephone, mdp) VALUES
 (1,1,'Faure','Thomas','test1@gmail.com',0606060606,'patate'),
 (2,1,'Mbongui','Sidney','test2@gmail.com',0606060606,'patate'),
 (3,1,'Villeneuve','Severine','test3@gmail.com',0606060606,'patate');

INSERT INTO tables (id, id_restaurant, numero, nombre_places, etat) VALUES
(1,1,1,4,'LIBRE'),
(2,1,2,2,'LIBRE'),
(3,1,3,2,'LIBRE'),
(4,1,4,10,'LIBRE'),
(5,1,5,4,'OCCUPEE');

INSERT INTO reservations (id, id_client, id_restaurant, id_table, date_reservation, heure_reservation, etat, taille_groupe) VALUES
(1,1,1,1,'2024-05-05','12:00','RESERVED',5),
(2,1,1,1,'2024-05-05','19:00','PENDING',5);

INSERT INTO commandes (id, id_client, id_table, etat, montant) VALUES
(1,1,5,'REGLEE',40.97)

INSERT INTO plats_commandes (id, id_commande, id_plat) VALUES
(1,1,1),
(2,1,2),
(3,1,6);

INSERT INTO equipes (id, id_role, id_restaurant, identifiant, mdp) VALUES
(1,1,1,'ThomasF','patate'),
(2,1,1,'SidenyM','patate'),
(3,1,1,'SeverineV','patate');


INSERT INTO messages (id, id_client, id_restaurant,message_text) VALUES
(1,1,1,'Bonjour nous souhaitons reserver pour 5');