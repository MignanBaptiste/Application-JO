import jo.*;
import jo.exception.AlreadyInException;
import jo.exception.InvalidSexeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestsAthlete {
    private Athlete ath1;
    private Athlete ath2;
    private Athlete ath3;
    private Pays france;

    @Before
    public void setUp() {
        france = new Pays("France");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        ath3 = new Athlete("Dumerc", "Céline", Sexe.FEMME, 45, 78, 65, france);
    }

    /** On veut pouvoir créer un nouvel athlète */
    @Test
    public void testAthlete() {
        // Test de création d'athlètes
        assertEquals("Manaudou", ath1.getNomAthlete());
        assertEquals("Riner", ath2.getNomAthlete());
        assertEquals("Dumerc", ath3.getNomAthlete());
        Equipe equ1 = new Equipe(new VolleyBall("Volley"), france);
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france, equ1);    
    }


    /** On veut obtenir l'équipe athlète */
    @Test
    public void testGetEquipe() {
        Equipe equipe1 = new Equipe(new VolleyBall("Volley"), france);
        Equipe equipe2 = new Equipe(new VolleyBall("Volley"), france);
        
        try {
            equipe1.addAthlete(ath1);
            equipe1.addAthlete(ath2);
            equipe2.addAthlete(ath3);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion des exceptions
        }
        assertEquals(ath1.getEquipe(), equipe1);
        assertEquals(ath2.getEquipe(), equipe1);
        assertEquals(ath3.getEquipe(), equipe2);
    }

    /** On veut obtenir le nom de l'athlète */
    @Test
    public void testGetNomAthlete() {
        // Test de récupération du nom de l'athlète
        assertEquals("Manaudou", ath1.getNomAthlete());
        assertEquals("Riner", ath2.getNomAthlete());
        assertEquals("Dumerc", ath3.getNomAthlete());
    }

    /** On veut obtenir le prénom de l'athlète */
    @Test
    public void testGetPrenomAthlete() {
        // Test de récupération du prénom de l'athlète
        assertEquals("Florent", ath1.getPrenomAthlete());
        assertEquals("Teddy", ath2.getPrenomAthlete());
        assertEquals("Céline", ath3.getPrenomAthlete());
    }

    /** On veut obtenir le nom complet d'un athlète */
    @Test
    public void testGetNom() {
        // Test de récupération du nom complet de l'athlète
        assertEquals("Manaudou Florent", ath1.getNom());
        assertEquals("Riner Teddy", ath2.getNom());
        assertEquals("Dumerc Céline", ath3.getNom());
    }

    /** On veut obtenir sex de l'athlète */
    @Test
    public void testGetSexe() {
        // Test de récupération du sexe de l'athlète
        assertEquals(Sexe.HOMME, ath1.getSexe());
        assertEquals(Sexe.HOMME, ath2.getSexe());
        assertEquals(Sexe.FEMME, ath3.getSexe());
    }

    /** On veut obtenir la force de l'athlète */
    @Test
    public void testGetForce() {
        // Test de récupération de la force de l'athlète
        assertEquals(56, ath1.getForce());
        assertEquals(89, ath2.getForce());
        assertEquals(45, ath3.getForce());
    }

    /** On veut obtenir l'agilité de l'athlète */
    @Test
    public void testGetAgilite() {
        // Test de récupération de l'agilité de l'athlète
        assertEquals(87, ath1.getAgilite());
        assertEquals(67, ath2.getAgilite());
        assertEquals(78, ath3.getAgilite());
    }

    /** On veut obtenir l'endurance de l'athlète */
    @Test
    public void testGetEndurance() {
        // Test de récupération de l'endurance de l'athlète
        assertEquals(78, ath1.getEndurance());
        assertEquals(53, ath2.getEndurance());
        assertEquals(65, ath3.getEndurance());
    }

    /** On veut obtenir le pays de l'athlète */
    @Test
    public void testGetPays() {
        // Test de récupération du pays de l'athlète
        assertEquals(france, ath1.getPays());
        assertEquals(france, ath2.getPays());
        assertEquals(france, ath3.getPays());
    }

    /** 
     * Test de participation de l'athlète à une épreuve
     */
    @Test
    public void testParticiper() {
        // Création d'une épreuve individuelle (pour Athlete)
        Sport athletisme = new Athletisme("100m");
        @SuppressWarnings({ "rawtypes", "unchecked" })
        Epreuve<Athlete> epv1 = new Epreuve(Sexe.HOMME, athletisme);

        // Tentative de participation de l'athlète à une épreuve individuelle 
        ath2.participer(epv1);
        assertNotNull(epv1.getParticipants()); // Vérifie si l'athlète a été ajouté à l'épreuve*
    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        Athlete ath4 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        assertNotEquals(ath1, ath2);
        assertNotEquals(ath2, ath3);
        assertEquals(ath2, ath4);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        assertEquals(ath1.hashCode(), (31*8*7*56*87*78)/17);
        assertEquals(ath2.hashCode(), (31*5*5*89*67*53)/17);
        assertEquals(ath3.hashCode(), (31*6*6*45*78*65)/17);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        assertEquals(ath1.toString(), "Florent Manaudou");
        assertEquals(ath2.toString(), "Teddy Riner");
        assertEquals(ath3.toString(), "Céline Dumerc");
    }
}
   
