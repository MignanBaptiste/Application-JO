insert into PAYS values ("France");
insert into PAYS values ("Japon");
insert into SPORT values ("Volley-ball", "Volley-ball");
insert into EPREUVE(sexe, nomSport, categorieSport) values ("M", "Volley-ball", "Volley-ball");
insert into COLLECTIVE(sexe, nomSport, categorieSport) values ("M", "Volley-ball", "Volley-ball");
insert into EQUIPE(nomPays, sexe, nomSport, categorieSport, score) values ("France", "M", "Volley-ball", "Volley-ball", -1);
insert into EQUIPE(nomPays, nomSport, categorieSport, score) values ("Japon", "Volley-ball", "Volley-ball", -1);
insert into ATHLETE(nomAthlete, prenomAthlete, sexe, laForce, agilite, endurance, nomPays, score) values ("Mignan", "Baptiste", "M", 100, 100, 100, "France", -1);
insert into ATHLETE(nomAthlete, prenomAthlete, sexe, laForce, agilite, endurance, nomPays) values ("Jean", "Baptiste", "M", 100, 100, 100, "France");
-- insert into INDIVIDUELLE(sexe, nomSport, categorieSport) values ("M", "Athletisme", "100 mètres");
UPDATE ATHLETE SET nomSport = "Volley-ball" WHERE nomAthlete = "Mignan" and prenomAthlete = "Baptiste";
UPDATE ATHLETE SET categorieSport = "Volley-ball" WHERE nomAthlete = "Mignan" and prenomAthlete = "Baptiste";
