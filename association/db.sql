CREATE TABLE ASSO.ARTICLE (
		CODE INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
		NOM VARCHAR(25) NOT NULL,
		PRIX DOUBLE NOT NULL,
		STOCK INTEGER NOT NULL
	);

CREATE TABLE ASSO.COMMANDE_ARTICLE (
		COMMANDE_ID INTEGER NOT NULL,
		ARTICLE_CODE INTEGER NOT NULL,
		QUANTITE INTEGER NOT NULL,
		PRIMARY KEY (COMMANDE_ID, ARTICLE_CODE)
	);

CREATE TABLE ASSO.COMMANDE (
		ID INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
		ID_ADHERENT VARCHAR(8) NOT NULL,
		DATE_CMD DATE NOT NULL
	);

CREATE TABLE ASSO.ADHERENT (
		ID VARCHAR(8) NOT NULL,
		MDP VARCHAR(32) NOT NULL,
		NOM VARCHAR(50) NOT NULL,
		PRENOM VARCHAR(20) NOT NULL,
		ADRESSE VARCHAR(100) NOT NULL,
		CP VARCHAR(5) NOT NULL,
		VILLE VARCHAR(100) NOT NULL,
		PAYS VARCHAR(25) NOT NULL
	);

ALTER TABLE ASSO.ADHERENT ADD CONSTRAINT ID_ADHERENT_PK PRIMARY KEY (ID);

ALTER TABLE ASSO.COMMANDE ADD CONSTRAINT ID_ADHERENT_FK FOREIGN KEY (ID_ADHERENT)
	REFERENCES ASSO.ADHERENT (ID);

ALTER TABLE ASSO.COMMANDE_ARTICLE ADD CONSTRAINT COMMANDE_ARTICLE_ARTICLE_FK FOREIGN KEY (ARTICLE_CODE)
	REFERENCES ASSO.ARTICLE (CODE);

ALTER TABLE ASSO.COMMANDE_ARTICLE ADD CONSTRAINT COMMANDE_ARTICLE_COMMANDE_FK FOREIGN KEY (COMMANDE_ID)
	REFERENCES ASSO.COMMANDE (ID);

insert into asso.adherent values ('E115721J', 'a0fce90325b0b93f6bb828527c6dc2fd', 'LAIGLE', 'MAEL', 'TEST', '44000', 'NANTES', 'FRANCE');

insert into asso.ARTICLE (nom, prix,stock)
values ('SWEET PASCAL OP', 35.0, 93);

insert into asso.ARTICLE (nom, prix,stock)
values ('TEE SHIRT PASCAL OP', 12.50, 150);

insert into asso.ARTICLE (nom, prix,stock)
values ('ECHARPE TRUC DE OUF', 20.0, 2);

insert into asso.ARTICLE (nom, prix,stock)
values ('SLIP DE BAIN', 19.99, 19);

insert into asso.ARTICLE (nom, prix,stock)
values ('BONNET LOVE <3', 14.99, 25);