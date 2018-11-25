DROP DATABASE IF EXISTS GESTION_BDD_ECOLE;

CREATE DATABASE IF NOT EXISTS GESTION_BDD_ECOLE;

USE GESTION_BDD_ECOLE;

-----------------------------------------------------------------------------
--       TABLE : LOCATION
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   LOC_ID INTEGER(10) NOT NULL  ,
   LOC_CITY VARCHAR(255) NOT NULL  
   , PRIMARY KEY (LOC_ID) 
 ) 
;
-- -----------------------------------------------------------------------------
--       TABLE : COURSE_SESSION
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE_SESSION

   (
    CS_ID INTEGER(10) NOT NULL  ,
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
   COURS_TITLE VARCHAR(255) NOT NULL  
   , PRIMARY KEY (COURS_CODE) 
 );

-- -----------------------------------------------------------------------------
--       TABLE : CLIENT
-- -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   CLI_ID INTEGER(10) NOT NULL  ,
   CLI_LASTNAME VARCHAR(255) NOT NULL  ,
   CLI_FIRSTNAME VARCHAR(255) NOT NULL  ,
   CLI_ADDRESS VARCHAR(255) NOT NULL  ,
   CLI_PHONE VARCHAR(255) NOT NULL  ,
   CLI_EMAIL VARCHAR(255) NOT NULL ,
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