drop table ATHLETEPARTICIPE if exists;
drop table EQUIPEPARTICIPE if exists;
drop table INDIVIDUELLE if exists;
drop table COLLECTIVE if exists;
drop table EPREUVE if exists;
drop table EQUIPE if exists;
drop table ATHLETE if exists;
drop table PAYS if exists;
drop table SPORT if exists;

create table PAYS(
    nomPays varchar(50) PRIMARY KEY
);

create table SPORT(
    nomSport varchar(50),
    categorieSport varchar(50),
    nbJoueurs int,
    PRIMARY KEY (nomSport, categorieSport)
);

create table ATHLETE(
    nomAthlete varchar(50),
    prenomAthlete varchar(50),
    sexe varchar(1),
    laForce int,
    agilite int,
    endurence int
);