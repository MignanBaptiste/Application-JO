import jo.*;
import jo.exception.AlreadyInException;
import jo.exception.InvalidSexeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

public class TestsEquipe {
    private Pays france;
    private VolleyBall v;
    private Athlete ath1;
    private Athlete ath2;
    private Equipe equ1;

    @Before
    public void setUp() {
        france = new Pays("France");
        v = new VolleyBall("Volley");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        equ1 = new Equipe(v, france);
    }

    /** On veut pouvoir créer une nouvelle équipe  */
    @Test
    public void testEquipe(){
        assertNotNull(equ1);
    }

    /** On veut obtenir l'équipe */
    @Test
    public void testGetEquipe(){
        assertEquals(equ1, equ1.getEquipe());
    }

    /** On veut obtenir le sport de l'équipe */
    @Test
    public void testGetSportEquipe(){
        assertEquals(v, equ1.getSport());
    }

    /** On veut obtenir le nom de l'équipe */
    @Test
    public void testGetNomEquipe(){
        assertEquals("France", equ1.getNom());
    }

    /** On veut obtenir le pays de l'équipe */
    @Test
    public void testGetPays(){
        assertEquals(france, equ1.getPays());
    }

    /** On veut obtenir la force totale de l'équipe */
    @Test
    public void testGetForce(){
        
        try {
            equ1.addAthlete(ath1);
            equ1.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        assertEquals(145, equ1.getForce());
    }

    /** On veut obtenir l'agilité' totale de l'équipe */
    @Test
    public void testGetAgilite(){
        try {
            equ1.addAthlete(ath1);
            equ1.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        
        assertEquals(154, equ1.getAgilite());
    }

    /** On veut obtenir l'endurance totale de l'équipe */
    @Test
    public void testGetEndurance(){
        try {
            equ1.addAthlete(ath1);
            equ1.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        assertEquals(131, equ1.getEndurance());
    }

    /** On veut pouvoir ajouter un athlète à l'équipe */
    @Test
    public void testAddAthletes(){
        try {
            equ1.addAthlete(new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france));
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        assertEquals(1, equ1.getAthletes().size());
    }

    /** On veut obtenir les athlètes de l'équipe */
    @Test
    public void testGetAthletes(){
        try {
            equ1.addAthlete(ath1);
            equ1.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        assertEquals(Arrays.asList(ath1, ath2), equ1.getAthletes());
    }

    /** On veut ajouter une équipe à une épreuve */
    @Test
    public void testParticiper(){
        Sport escrime = new Escrime("Escrime");
        @SuppressWarnings("rawtypes")
        Epreuve epv1 = new Epreuve(Sexe.HOMME, escrime);
        try {
            equ1.addAthlete(ath1);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion des exceptions
        }
        equ1.participer(epv1);
        assertEquals(1, epv1.getParticipants().size());
    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        Equipe equ2 = new Equipe(v, new Pays("Suisse"));
        Equipe equ3 = new Equipe(v, new Pays("Suisse"));
        try {
            equ1.addAthlete(ath1);
            equ2.addAthlete(ath2);
            equ3.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion exception
        }
        assertNotEquals(equ1, equ2);
        assertEquals(equ2, equ3);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        assertEquals(equ1.hashCode(), (31*france.hashCode()*v.hashCode())/17);
        assertNotEquals(equ1.hashCode(), 58);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        assertEquals(equ1.toString(), "Cette équipe représente le pays suivant : France en Volley");
        assertNotEquals(equ1.toString(), "Voici une équipe de volley");
    }
}
