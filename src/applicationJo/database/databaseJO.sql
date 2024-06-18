drop table if exists ATHLETE;
drop table if exists EQUIPE;
drop table if exists INDIVIDUELLE;
drop table if exists COLLECTIVE;
drop table if exists EPREUVE;
drop table if exists PAYS;
drop table if exists SPORT;
create table PAYS(
    idPays int PRIMARY KEY NOT NULL,
    nomPays varchar(50) NOT NULL
);
create table SPORT(
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    nbJoueurs int,
    PRIMARY KEY (nomSport, categorieSport)
);
create table EPREUVE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (nomSport, categorieSport) references SPORT(nomSport, categorieSport)
);
create table INDIVIDUELLE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (sexe, nomSport, categorieSport) references EPREUVE(sexe, nomSport, categorieSport)
);
create table COLLECTIVE(
    sexe varchar(1) NOT NULL,
    nomSport varchar(50) NOT NULL,
    categorieSport varchar(50) NOT NULL,
    PRIMARY KEY (sexe, nomSport, categorieSport),
    FOREIGN KEY (sexe, nomSport, categorieSport) references EPREUVE(sexe, nomSport, categorieSport)
);
create table EQUIPE(
    idEquipe int PRIMARY KEY NOT NULL,
    nomEquipe varchar(50) NOT NULL,
    score int,
    sexe varchar(1),
    nomSport varchar(50),
    categorieSport varchar(50),
    FOREIGN KEY (sexe, nomSport, categorieSport) references COLLECTIVE(sexe, nomSport, categorieSport)
);
create table ATHLETE(
    nomAthlete varchar(50) NOT NULL,
    prenomAthlete varchar(50) NOT NULL,
    sexe varchar(1) NOT NULL,
    laForce int NOT NULL,
    agilite int NOT NULL,
    endurence int NOT NULL,
    idPays int NOT NULL,
    idEquipe int,
    score int,
    nomSport varchar(50),
    categorieSport varchar(50),
    PRIMARY KEY (nomAthlete, prenomAthlete),
    FOREIGN KEY (idPays) references PAYS(idPays),
    FOREIGN KEY (idEquipe) references EQUIPE(idEquipe),
    FOREIGN KEY (sexe, nomSport, categorieSport) references INDIVIDUELLE(sexe, nomSport, categorieSport)
);