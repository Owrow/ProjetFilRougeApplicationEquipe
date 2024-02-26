DROP TABLE IF EXISTS plats_commandes, plats_cartes,  factures,commandes, reservations,tables, equipes,messages, clients, restaurants, cartes,  roles,plats, categories;


 
CREATE TABLE roles (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id          INT       NOT NULL PRIMARY KEY IDENTITY,
 
	libelle   VARCHAR(6)   NOT NULL
 
);
 
CREATE TABLE clients (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id					INT		           NOT NULL
 
	                                       PRIMARY KEY IDENTITY,
	id_role				INT NOT NULL,
 
	nom					VARCHAR(20)			NOT NULL,
 
	prenom				VARCHAR(20)			NOT NULL,
 
	mail			    VARCHAR(30)			NOT NULL UNIQUE,
 
	telephone           VARCHAR(12)         NOT NULL,
 
	mdp                 VARCHAR(255)         NOT NULL,
	token				VARCHAR(255)		NULL,

	expiration_time		DATETIME			NULL,
 
);
CREATE TABLE equipes (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id            INT       NOT NULL  PRIMARY KEY IDENTITY,
	id_role		 INT       NOT NULL,	
	id_restaurant int		NOT NULL,
 
	identifiant   VARCHAR(255)   NOT NULL UNIQUE,
 
	mdp           VARCHAR(255)   NOT NULL,

	token		  VARCHAR(255)   NULL,

	expiration_time DATETIME      NULL,
);



CREATE TABLE categories (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY,
	nom VARCHAR(255)
); 
CREATE TABLE plats (
createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY	,
	id_categorie INT,
	nom VARCHAR(50),
	description_plat VARCHAR(100),
	prix NUMERIC(5,2)
	);

	
CREATE TABLE cartes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY	,
	nom varchar(30) 

);

CREATE TABLE plats_cartes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY	,
	id_carte INT,
	id_plat INT
	);


CREATE TABLE tables (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id					INT					NOT NULL
											PRIMARY KEY
											IDENTITY,
	id_restaurant		INT					NOT NULL,
	numero				INT					NOT NULL,
	nombre_places		INT					NULL,
	etat				VARCHAR(10)			NOT NULL DEFAULT 'LIBRE'
	
);
CREATE TABLE reservations (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id					INT					NOT NULL
											PRIMARY KEY
											IDENTITY,
	id_client			INT					NOT NULL,
	id_restaurant		INT					NOT NULL,
	id_table			INT					NULL,
	date_reservation	DATE				NOT NULL,
	heure_reservation	TIME				NOT NULL,
	etat				VARCHAR(10)			NOT NULL,
	taille_groupe		int					NOT NULL
											
); 


CREATE TABLE commandes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id					INT					NOT NULL
											PRIMARY KEY
											IDENTITY,
	id_client			INT					NOT NULL,
	id_table			INT					NOT NULL,
	
	etat				VARCHAR(10)			NOT NULL
											
);

CREATE TABLE plats_commandes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY	,
	id_commande  INT,
	id_plat INT
	);


CREATE TABLE factures (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY IDENTITY,
	id_commande INT 	,
	
	etat VARCHAR(10) NOT NULL
);

 
CREATE TABLE restaurants (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id           INT         NOT NULL  PRIMARY KEY IDENTITY,
	id_carte	INT      NULL,
	nom          VARCHAR(30) NOT NULL,
 
	adresse      VARCHAR(80) NOT NULL,
 
	ouverture    DATETIME    NOT NULL,
 
	fermeture    DATETIME    NOT NULL

);

CREATE TABLE messages (

    id INT PRIMARY KEY IDENTITY,

    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,

    updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,

    deletedAT DATETIME NULL,

    id_client INT NOT NULL,

    id_restaurant INT NOT NULL,

    message_text VARCHAR(255) NOT NULL

);
 
ALTER TABLE messages

    WITH CHECK ADD FOREIGN KEY (id_client) REFERENCES clients(id) ON DELETE CASCADE,
	FOREIGN KEY (id_restaurant) REFERENCES restaurants(id);


ALTER TABLE clients
WITH CHECK ADD
FOREIGN KEY (id_role) REFERENCES roles(id);
 

 
ALTER TABLE factures
WITH CHECK ADD
FOREIGN KEY (id_commande) REFERENCES commandes(id); 

 
ALTER TABLE tables
WITH CHECK ADD
FOREIGN KEY (id_restaurant) REFERENCES restaurants(id) ON DELETE CASCADE

 
ALTER TABLE commandes
WITH CHECK ADD
FOREIGN KEY (id_client) REFERENCES clients(id),
FOREIGN KEY (id_table) REFERENCES tables(id);



ALTER TABLE equipes
WITH CHECK ADD
FOREIGN KEY (id_role) REFERENCES roles(id),
FOREIGN KEY (id_restaurant) REFERENCES restaurants(id);

ALTER TABLE restaurants
WITH CHECK ADD
FOREIGN KEY (id_carte) REFERENCES cartes(id);


ALTER TABLE reservations
WITH CHECK ADD
FOREIGN KEY (id_client) REFERENCES clients(id) ON DELETE CASCADE,
FOREIGN KEY (id_restaurant) REFERENCES restaurants(id),
FOREIGN KEY (id_table) REFERENCES tables(id);

ALTER TABLE plats
WITH CHECK ADD
FOREIGN KEY (id_categorie) REFERENCES categories(id);

ALTER TABLE plats_cartes
WITH CHECK ADD
FOREIGN KEY (id_carte) REFERENCES cartes(id),
FOREIGN KEY (id_plat) REFERENCES plats(id);

ALTER TABLE plats_commandes
WITH CHECK ADD
FOREIGN KEY (id_commande) REFERENCES commandes(id),
FOREIGN KEY (id_plat) REFERENCES plats(id);


INSERT INTO roles (libelle) values ('USER'),('TEAM'),('ADMIN');
INSERT INTO categories (nom) VALUES ('Entrée'), ('Plat'), ('Dessert'), ('Boisson');

 
INSERT INTO cartes (nom) VALUES ('Printemps'), ('Eté'), ('Automne'), ('Hiver');
 

 
INSERT INTO plats (id_categorie, nom, description_plat, prix) VALUES  
    (1, 'Salade César', 'Salade verte, poulet grillé, parmesan, croûtons et sauce César', 8.99),    
    (2, 'Spaghetti Bolognese', 'Spaghetti avec une sauce à la viande', 12.99),
    (2, 'Poulet rôti', 'Poulet rôti avec légumes de saison', 15.99),  
    (3, 'Tiramisu', 'Dessert italien au mascarpone et café', 7.99),
    (3, 'Crème brûlée', 'Crème dessert avec une couche de sucre caramélisé', 6.49),  
    (4, 'Vin rouge', 'Bouteille de vin rouge de la région', 18.99);

INSERT INTO plats_cartes (id_carte, id_plat) VALUES
(4,1),
(4,2),
(4,3),
(4,4),
(4,5),
(4,6);

 
INSERT INTO restaurants (nom, id_carte, adresse, ouverture, fermeture) VALUES 
('Pâte d''or', 4, '14 rue du Paradis 44000 NANTES', '12:00', '22:30'),
('Pâte d''or', 4, '28 rue des Arts 75001 Paris', '12:00', '22:30'),
('Pâte d''or', 4, '55 boulevard des bouchons 69000 LYON', '12:00', '22:30'),
('Pâte d''or', 4,'3 rue du Jardin 13000 MARSEILLE', '12:00', '22:30');


INSERT INTO clients (id_role, nom, prenom, mail, telephone, mdp) VALUES
 (1,'Faure','Thomas','test1@gmail.com',0606060606,'patate'),
 (1,'Mbongui','Sidney','test2@gmail.com',0606060606,'patate'),
 (1,'Villeneuve','Severine','test3@gmail.com',0606060606,'patate');

INSERT INTO tables (id_restaurant, numero, nombre_places, etat) VALUES
(1,1,4,'LIBRE'),
(1,2,2,'LIBRE'),
(1,3,2,'LIBRE'),
(1,4,10,'LIBRE'),
(1,5,4,'OCCUPEE');

INSERT INTO reservations (id_client, id_restaurant, id_table, date_reservation, heure_reservation, etat, taille_groupe) VALUES
(1,1,1,'2024-05-05','12:00','RESERVED',5),
(1,1,1,'2024-05-05','19:00','PENDING',5);

INSERT INTO commandes (id_client, id_table, etat) VALUES
(1,5,'REGLEE')

INSERT INTO plats_commandes (id_commande, id_plat) VALUES
(1,1),
(1,2),
(1,6);

INSERT INTO equipes (id_role, id_restaurant, identifiant, mdp) VALUES
(2,1,'ThomasF','patate'),
(2,1,'SidenyM','patate'),
(2,1,'SeverineV','patate');


INSERT INTO factures (id_commande, etat) VALUES
(1,'REGLEE');

INSERT INTO messages (id_client, id_restaurant,message_text) VALUES
(1,1,'Bonjour nous souhaitons reserver pour 5');