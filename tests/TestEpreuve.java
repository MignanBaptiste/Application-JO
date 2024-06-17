import jo.*;
import jo.exception.AlreadyInException;
import jo.exception.FilledElementException;
import jo.exception.InvalidSexeException;
import jo.exception.InvalidTypeException;
import jo.exception.NothingInException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashMap;

public class TestEpreuve {
    private VolleyBall volleyBall;
    private Epreuve<Athlete> individuelle; // Mise à jour du type d'Epreuve
    private Epreuve<Equipe> collective; // Mise à jour du type d'Epreuve

    @Before
    public void setUp() {
        volleyBall = new VolleyBall("Volley");
        individuelle = new Epreuve<>(Sexe.HOMME, volleyBall);
        collective = new Epreuve<>(Sexe.FEMME, volleyBall); 
    }

    /** Test de récupération du sexe de l'épreuve */
    @Test
    public void testGetSexe() {
        assertEquals(Sexe.HOMME, individuelle.getSexe());
        assertEquals(Sexe.FEMME, collective.getSexe());
    }

    /** Test de récupération du sport de l'épreuve */
    @Test
    public void testGetSport() {
        assertEquals(volleyBall, individuelle.getSport());
        assertEquals(volleyBall, collective.getSport());
    }

    /** Test de l'ajout d'un participant individuel */
    @Test
    public void testAddParticipantIndividuel() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        try {
            individuelle.addParticipant(ath1);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            // gestion de l'exception
        }
        assertEquals(1, individuelle.getParticipants().size());
        assertEquals(ath1, individuelle.getParticipants().get(0));
    }

    /** Test de l'ajout d'une équipe comme participant */
    @Test
    public void testAddParticipantEquipe() {
        Pays france = new Pays("France");
        Equipe equipe = new Equipe(new VolleyBall("Volley"), france);
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.FEMME, 56, 87, 78, france);
        try {
            equipe.addAthlete(ath1);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion de l'exception
        }
        try {
            collective.addParticipant(equipe);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            // gestion de l'exception
        }
        assertEquals(1, collective.getParticipants().size());
        assertEquals(equipe, collective.getParticipants().get(0));
    }

    /** Test du résultat de l'épreuve 
     * @throws InvalidTypeException */
    @Test
    public void testResultats() throws InvalidTypeException {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        Equipe equipe1 = new Equipe(volleyBall, france);
        try {
            equipe1.addAthlete(ath1);
            equipe1.addAthlete(ath2);
            collective.addParticipant(equipe1);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion de l'exception
            }
        
        // Calcul manuel des scores attendus
        int scoreAttendu = 0;
        scoreAttendu += ath1.getForce() * volleyBall.getCoeffForce();
        scoreAttendu += ath1.getAgilite() * volleyBall.getCoeffAgilite();
        scoreAttendu += ath1.getEndurance() * volleyBall.getCoeffEndurance();
        scoreAttendu += ath2.getForce() * volleyBall.getCoeffForce();
        scoreAttendu += ath2.getAgilite() * volleyBall.getCoeffAgilite();
        scoreAttendu += ath2.getEndurance() * volleyBall.getCoeffEndurance();
        
        // Vérification du résultat obtenu
        try{
        HashMap<Equipe, Integer> resultats = collective.resultats();
        assertEquals(1, resultats.size());
        assertEquals((Integer)scoreAttendu, resultats.get(equipe1));
        } catch (NothingInException e) {
            // gestion de l'exception
        }
    }

    /** Test du classement de l'épreuve */
    @Test
    public void testClassementEpreuve() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.FEMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.FEMME, 89, 67, 53, france); 
        Equipe equipe = new Equipe(volleyBall, france);
        try {
            equipe.addAthlete(ath1);
            equipe.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion de l'exception
        }
        try {
            collective.addParticipant(equipe);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            // gestion de l'exception
        }
        // Vérification du classement
        assertEquals(1, collective.classementEpv().size());
        assertEquals(equipe, collective.classementEpv().get(0));
    }

    /** Test de récupération des participants */
    @Test
    public void testGetParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 
        Athlete ath3 = new Athlete("Manaudou", "Florent", Sexe.FEMME, 56, 87, 78, france); 
        Athlete ath4 = new Athlete("Riner", "Teddy", Sexe.FEMME, 89, 67, 53, france);
        Equipe equipe = new Equipe(new VolleyBall("Volley"), france);
        try {
            equipe.addAthlete(ath3);
            equipe.addAthlete(ath4);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion de l'exception
        }
        try {
            individuelle.addParticipant(ath1);
            individuelle.addParticipant(ath2);
            collective.addParticipant(equipe);

        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            // gestion de l'exception
        }

        assertEquals(Arrays.asList(ath1, ath2), individuelle.getParticipants());
        assertEquals(Arrays.asList(equipe), collective.getParticipants());

    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        Epreuve<Equipe> collective2 = new Epreuve<>(Sexe.FEMME, volleyBall);
        Epreuve<Equipe> collective3 = new Epreuve<>(Sexe.FEMME, volleyBall);
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.FEMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.FEMME, 89, 67, 53, france);
        Equipe equipe1 = new Equipe(volleyBall, france);
        Equipe equipe2 = new Equipe(volleyBall, france);
        try {
            equipe1.addAthlete(ath1);
            equipe2.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
            // gestion de l'exception
        }
        try {
            collective.addParticipant(equipe1);
            collective2.addParticipant(equipe2);
            collective3.addParticipant(equipe1);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            // pas possible
        }
        assertEquals(collective, collective2);
        assertEquals(collective, collective3);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        assertEquals(collective.hashCode(), (31*volleyBall.hashCode()*Sexe.FEMME.hashCode())/17);
        assertEquals(individuelle.hashCode(), (31*volleyBall.hashCode()*Sexe.HOMME.hashCode())/17);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        assertEquals(individuelle.toString(), "Epreuve de Volley Masculin");
        assertEquals(collective.toString(), "Epreuve de Volley Féminin");
    }
}
