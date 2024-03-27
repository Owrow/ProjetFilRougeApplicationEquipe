DROP TABLE IF EXISTS plats_commandes, plats_cartes,  factures,commandes, reservations,tables, equipes,messages, clients, restaurants, cartes,  roles,plats, categories;


 
CREATE TABLE roles (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id          INT       NOT NULL PRIMARY KEY ,
 
	libelle   VARCHAR(6)   NOT NULL
 
);
 
CREATE TABLE clients (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id					INT		           NOT NULL
 
	                                       PRIMARY KEY ,
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
 
	id            INT       NOT NULL  PRIMARY KEY ,
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
	id INT PRIMARY KEY ,
	nom VARCHAR(255)
); 
CREATE TABLE plats (
createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY 	,
	id_categorie INT,
	nom VARCHAR(50),
	description_plat VARCHAR(100),
	prix NUMERIC(5,2)
	);

	
CREATE TABLE cartes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY 	,
	nom varchar(30) 

);

CREATE TABLE plats_cartes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY 	,
	id_carte INT,
	id_plat INT
	);


CREATE TABLE tables (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id					INT					NOT NULL
											PRIMARY KEY
											,
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
											,
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
											,
	id_client			INT					NOT NULL,
	id_table			INT					NOT NULL,
	
	etat				VARCHAR(10)			NOT NULL,
	montant				FLOAT				NULL
											
);

CREATE TABLE plats_commandes (
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
	id INT PRIMARY KEY 	,
	id_commande  INT,
	id_plat INT
	);

 
CREATE TABLE restaurants (
 
	createdAt          DATETIME DEFAULT CURRENT_TIMESTAMP,     
 
	updatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,
 
	deletedAT          DATETIME NULL,
 
	id           INT         NOT NULL  PRIMARY KEY ,
	id_carte	INT      NULL,
	nom          VARCHAR(30) NOT NULL,
 
	adresse      VARCHAR(80) NOT NULL,
 
	ouverture    DATETIME    NOT NULL,
 
	fermeture    DATETIME    NOT NULL

);

CREATE TABLE messages (

    id INT PRIMARY KEY ,

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