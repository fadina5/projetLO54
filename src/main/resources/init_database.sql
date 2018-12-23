DROP DATABASE IF EXISTS GESTION_BDD_ECOLE;

CREATE DATABASE IF NOT EXISTS GESTION_BDD_ECOLE;

USE GESTION_BDD_ECOLE;

-----------------------------------------------------------------------------
--       TABLE : LOCATION
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   LOC_ID INTEGER(10) NOT NULL AUTO_INCREMENT ,
   LOC_CITY VARCHAR(255) NOT NULL  
   , PRIMARY KEY (LOC_ID) 
 ) 
;
-- -----------------------------------------------------------------------------
--       TABLE : COURSE_SESSION
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE_SESSION

   (
    CS_ID INTEGER(10) NOT NULL AUTO_INCREMENT  ,
   LOC_ID INTEGER(10) NOT NULL  ,
   COURS_CODE VARCHAR(255) NOT NULL  ,
   CS_START_DATE DATE NOT NULL  ,
   CS_END_DATE DATE NOT NULL  ,
   CS_MAX INTEGER(10) NOT NULL  
   , PRIMARY KEY (CS_ID) 
 ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE COURSE_SESSION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_COURSE_SESSION_LOCATION
     ON COURSE_SESSION (LOC_ID ASC);

CREATE  INDEX I_FK_COURSE_SESSION_COURSE
     ON COURSE_SESSION (COURS_CODE ASC);

-- -----------------------------------------------------------------------------
--       TABLE : COURSE
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE
 (
   COURS_CODE  VARCHAR(255) NOT NULL  ,
   COURS_TITLE VARCHAR(255) NOT NULL,
   COURS_DESCRIPTION VARCHAR(255) NOT NULL  
   , PRIMARY KEY (COURS_CODE) 
 );

-- -----------------------------------------------------------------------------
--       TABLE : CLIENT
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   CLI_ID INTEGER(10) NOT NULL AUTO_INCREMENT ,
   CLI_LASTNAME VARCHAR(255) NOT NULL  ,
   CLI_FIRSTNAME VARCHAR(255) NOT NULL  ,
   CLI_ADDRESS VARCHAR(255) NOT NULL  ,
   CLI_PHONE VARCHAR(255) NOT NULL  ,
   CLI_EMAIL VARCHAR(255) ,
   CS_ID INTEGER(10) NOT NULL  
   , PRIMARY KEY (CLI_ID) 
 ) 
;
-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CLIENT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CLIENT_COURSE_SESSION
     ON CLIENT (CS_ID ASC)
    ;
-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_COURSE (COURS_CODE)
      REFERENCES COURSE (COURS_CODE) ;

ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_LOCATION (LOC_ID)
      REFERENCES LOCATION (LOC_ID) ;

ALTER TABLE CLIENT 
ADD FOREIGN KEY FK_CLIENT_COURSE_SESSION(CS_ID)
		REFERENCES COURSE_SESSION (CS_ID);
        
INSERT INTO LOCATION(LOC_CITY) VALUES('BELFORT');
INSERT INTO LOCATION(LOC_CITY) VALUES('PARIS');
INSERT INTO LOCATION(LOC_CITY) VALUES('TOULOUSE');
INSERT INTO LOCATION(LOC_CITY) VALUES('LYON');
INSERT INTO LOCATION(LOC_CITY) VALUES('STRASBOURG');

INSERT INTO COURSE VALUES('LO54','Java Enterprise Applications Architectures and Development Frameworks','Acquérir les compétences des architectures d application Java Enterprise.');
INSERT INTO COURSE VALUES('AG51','Algorithmiques avancées','Acquérir les compétences sur les concepts en algorithmique avancée : structures de données, algorithmes de routage, algorithmes géométriques, algorithmes parallèles...');
INSERT INTO COURSE VALUES('LO51','Administration des bases de données','Être capable d automatiser, de surveiller et d optimiser une base de données Oracle sur un système Linux et Windows.');
INSERT INTO COURSE VALUES('SR50','Sécurité des systèmes informatiques','L objectif de l UV est de développer des méthodes et des outils pour le management de risques et la sûreté de fonctionnement de systèmes informatiques.');
INSERT INTO COURSE VALUES('TL53','Principes et techniques des télécommunications','Acquérir les compétences pour concevoir et mettre en œuvre un système de communication transportant des données multimédia.');
INSERT INTO COURSE VALUES('SI02','Sémiologie de limage et du son','Appréhender les connaissances de base du traitement des informations auditives et visuelles.');
INSERT INTO COURSE VALUES('PH03','Théories du cinéma, théories des jeux vidéo','Sinterroger sur les transformations de l art au 20e siècle face à la montée en puissance des industries culturelles : enrichir sa culture à travers létude de lhistoire du cinéma, sinitier à la recherche à travers les théories contemporaines du jeu vidéo.');

INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('1','LO54','2018-12-20','2018-12-21','10');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('1','LO54','2018-01-20','2018-04-12','2');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('3','LO51','2018-12-20','2018-12-21','10');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('2','AG51','2018-12-20','2018-12-21','10');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('4','PH03','2018-12-21','2018-12-29','5');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('5','SI02','2018-12-20','2018-12-21','7');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('2','SR50','2018-12-20','2018-12-21','8');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('3','TL53','2018-12-20','2018-12-21','4');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('4','LO51','2018-12-22','2018-12-29','10');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('4','PH03','2018-12-20','2018-12-21','12');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('5','SI02','2018-12-19','2018-12-21','10');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('5','TL53','2018-01-02','2018-02-02','4');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('3','AG51','2018-03-20','2018-03-24','6');
INSERT INTO COURSE_SESSION(LOC_ID, COURS_CODE, CS_START_DATE , CS_END_DATE ,CS_MAX) 
VALUES('1','LO51','2018-10-20','2018-10-21','10');



