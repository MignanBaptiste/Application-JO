import jo.*;
import jo.exception.AlreadyInException;
import jo.exception.FilledElementException;
import jo.exception.InvalidSexeException;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

import java.util.List;

public class TestsJeuxOlympiques {
    // Déclaration des variables nécessaires pour les tests

    private JeuxOlympiques jeux2024;
    private Pays france;
    private Pays usa;
    private Equipe equipeFrance;
    private Equipe equipeUSA;
    private Athletisme athletisme;

    // Méthode d'initialisation exécutée avant chaque test
    @Before
    public void setUp() {
        jeux2024 = new JeuxOlympiques(2024);
        france = new Pays("France");
        usa = new Pays("USA");
        equipeFrance = new Equipe(new VolleyBall("Volley"), france);
        equipeUSA = new Equipe(new VolleyBall("Volley"), usa);
        athletisme = new Athletisme("Athlétisme");
    }

    // Test pour vérifier l'instanciation correcte de JeuxOlympiques
    @Test
    public void testJeuxOlympiques() {
        assertNotNull(jeux2024);
    }

    // Test pour vérifier la récupération des équipes
    @Test
    public void testGetEquipes() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        try {
            equipeFrance.addAthlete(ath1);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion des exceptions
        }
        HashSet<Equipe> hs = new HashSet<>();
        hs.add(equipeFrance);
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getEquipes(), hs);
    }

    // Test pour vérifier la récupération des pays
    @Test
    public void testGetPays() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        List<Pays> hs = new ArrayList<>();
        hs.add(france);
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getPays(), hs);
    }

    // Test pour vérifier la récupération des athlètes
    @Test
    public void testGetAthlete() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        List<Athlete> hs = new ArrayList<>();
        hs.add(ath1);
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getAthletes(), hs);
    }

    // Test pour vérifier la récupération du nombre d'équipes
    @Test
    public void testGetNbEquipes() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        try {
            equipeFrance.addAthlete(ath1);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion des exceptions
        }
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getNbEquipes(), 1);
    }

    // Test pour vérifier la récupération du nombre d'épreuves
    @SuppressWarnings("rawtypes")
    @Test
    public void testGetNbEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        jeux2024.addEpreuve(ep1);
        assertEquals(1, jeux2024.getNbEpreuves());
    }

    // Test pour vérifier la récupération du nombre de pays
    @Test
    public void testGetNbPays() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getNbPays(), 1);
    }

    // Test pour vérifier la récupération du nombre d'athlète
    @Test
    public void testGetNbAthlete() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        jeux2024.addAthlete(ath1);
        assertEquals(jeux2024.getNbAthletes(), 1);
    }

    // Test pour vérifier la récupération de l'année des JO
    @Test
    public void testGetAnnee() {
        assertEquals(2024, jeux2024.getAnnee());
    }

    // Test pour vérifier l'ajout des épreuves
    @SuppressWarnings("rawtypes")
    @Test
    public void testAddEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        assertEquals(2, jeux2024.getEpreuves().size());
    }

    // Test pour vérifier la récupération des épreuves
    @SuppressWarnings("rawtypes")
    @Test
    public void testGetEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        jeux2024.addEpreuve(ep1);
        List<Epreuve> epreuves = jeux2024.getEpreuves();
        assertEquals(ep1, epreuves.get(0));
    }

    // Test pour vérifier la méthode MedaillesParPays
    @SuppressWarnings("unchecked")
    @Test
    public void testMedaillesParPays() {
        // Création d'épreuves
        @SuppressWarnings("rawtypes")
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        @SuppressWarnings("rawtypes")
        Epreuve ep2 = new Epreuve<>(Sexe.HOMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        //Ajout des athlètes
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, usa);
        jeux2024.addAthlete(ath1);
        jeux2024.addAthlete(ath2);
        try {
            equipeFrance.addAthlete(ath1);
            equipeUSA.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion des exceptions
        }
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException |InvalidSexeException | AlreadyInException e) {
            e.printStackTrace();
        }

        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeFrance.getPays().getClassement().addArgent(1);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du nombre de médailles
        HashMap<Pays, Classement> medailles = jeux2024.medaillesParPays();
        assertEquals(2, medailles.get(france).getOr());
        assertEquals(1, medailles.get(france).getArgent());
        assertEquals(0, medailles.get(france).getBronze());
        assertEquals(0, medailles.get(usa).getOr());
        assertEquals(0, medailles.get(usa).getArgent());
        assertEquals(1, medailles.get(usa).getBronze());
    }

    // Test pour vérifier la méthode MedaillesOr
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testMedaillesOr() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, usa);
        try {
            equipeFrance.addAthlete(ath1);
            equipeUSA.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion des erreurs
        }
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            e.printStackTrace();
        }
        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du classement par médailles d'or
        List<Pays> medaillesOr = jeux2024.medaillesOr();
        assertEquals(france, medaillesOr.get(0));
        assertEquals(usa, medaillesOr.get(1));
    }

    // Test pour vérifier la méthode MedaillesTotales
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testMedaillesTotales() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, usa);
        try {
            equipeFrance.addAthlete(ath1);
            equipeUSA.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion des erreurs
        }
        
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            e.printStackTrace();
        }
        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeFrance.getPays().getClassement().addArgent(1);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du classement par médailles totales
        List<Pays> medaillesTotales = jeux2024.medaillesTotales();
        assertEquals(france, medaillesTotales.get(0));
        assertEquals(usa, medaillesTotales.get(1));
    }

    // Test pour réinitialiser le classement des pays
    @Test
    public void testResetClassement() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        jeux2024.addAthlete(ath1);
        france.getClassement().addBronze(23);
        assertEquals(france.getClassement().getBronze(), 23);
        jeux2024.resetClassement();
        assertEquals(france.getClassement().getBronze(), 0);
    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        JeuxOlympiques jeux2023 = new JeuxOlympiques(2023);
        JeuxOlympiques jeux2024Num2 = new JeuxOlympiques(2024);
        assertNotEquals(jeux2024, jeux2023);
        assertEquals(jeux2024, jeux2024Num2);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        assertEquals(jeux2024.hashCode(), (31*2024)/17);
        assertNotEquals(jeux2024.hashCode(), 58);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        assertEquals(jeux2024.toString(), "Jeux Olympiques de 2024");
        assertNotEquals(jeux2024.toString(), "Vive les Jeux Olympiques !");
    }

     // Test pour charger les données à partir d'un fichier CSV
    public void testLoad_csv(){
        JeuxOlympiques jo = new JeuxOlympiques(0);
        try{
            jo.load_csv("tests/donnees.csv");
        }
        catch(InvalidTypeException e){
            System.out.println("Problème de chargement des données");
        }
        assertEquals(jo.getNbAthletes(), 400);
        assertEquals(jo.getNbEquipes(), 40);
        assertEquals(jo.getNbPays(), 10);
        assertEquals(jo.getNbEpreuves(), 16);
    }

    // Test pour la simulation des épreuves des jeux olympiques
    @Test
    public void testSimulation(){
    }
}

