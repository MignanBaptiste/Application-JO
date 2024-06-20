drop table if exists ATHLETE;
drop table if exists EQUIPE;
drop table if exists INDIVIDUELLE;
drop table if exists COLLECTIVE;
drop table if exists EPREUVE;
drop table if exists PAYS;
drop table if exists SPORT;
-- Pays(String pays) fait
create table PAYS(
    nomPays varchar(50) PRIMARY KEY NOT NULL
);
-- Sport(String categorie) fait
create table SPORT(
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (nomSport, categorieSport)
);
-- Epreuve(Sexe sexe, Sport sport) fait
create table EPREUVE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (nomSport, categorieSport) references SPORT(nomSport, categorieSport)
);
-- Epreuve(Sexe sexe, Sport sport) fait
create table INDIVIDUELLE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (sexe, nomSport, categorieSport) references EPREUVE(sexe, nomSport, categorieSport)
);
-- Epreuve(Sexe sexe, Sport sport) fait
create table COLLECTIVE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (sexe, nomSport, categorieSport) references EPREUVE(sexe, nomSport, categorieSport)
);
-- Equipe(Sport sport, Pays pays)
create table EQUIPE(
    nomPays varchar(50) NOT NULL,
    score int,
    sexe varchar(1),
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (nomSport, categorieSport, nomPays),
    FOREIGN KEY (sexe, nomSport, categorieSport) references COLLECTIVE(sexe, nomSport, categorieSport),
    FOREIGN KEY (nomPays) references PAYS(nomPays)
);
-- Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, Pays pays) fait
create table ATHLETE(
    nomAthlete varchar(50) NOT NULL,
    prenomAthlete varchar(50) NOT NULL,
    sexe varchar(1) NOT NULL,
    laForce int NOT NULL,
    agilite int NOT NULL,
    endurance int NOT NULL,
    nomPays varchar(50) NOT NULL,
    score int,
    nomSport varchar(50),
    categorieSport varchar(50),
    PRIMARY KEY (nomAthlete, prenomAthlete),
    FOREIGN KEY (nomPays) references PAYS(nomPays),
    FOREIGN KEY (nomSport, categorieSport, nomPays) references EQUIPE(nomSport, categorieSport, nomPays),
    FOREIGN KEY (sexe, nomSport, categorieSport) references EPREUVE(sexe, nomSport, categorieSport)
);