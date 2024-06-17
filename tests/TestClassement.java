import jo.*;  // Importation des classes nécessaires du package jo

import org.junit.*;  // Importation des annotations et classes de JUnit
import static org.junit.Assert.assertEquals;  // Importation des méthodes statiques pour les assertions
import static org.junit.jupiter.api.Assertions.assertNotEquals;  // Importation des méthodes statiques pour les assertions

public class TestClassement {
    private Pays france;  // Déclaration d'une instance de la classe Pays

    @Before
    public void setUp() {
        france = new Pays("France");  // Initialisation de l'objet france avant chaque test
    }

    @Test
    public void testAddOr() {
        france.getClassement().addOr(6);  // Ajout de 6 médailles d'or au classement de la France
        assertEquals(6, france.getClassement().getOr());  // Vérification que le nombre de médailles d'or est bien 6
    }

    @Test
    public void testAddArgent() {
        france.getClassement().addArgent(8);  // Ajout de 8 médailles d'argent au classement de la France
        assertEquals(8, france.getClassement().getArgent());  // Vérification que le nombre de médailles d'argent est bien 8
    }

    @Test
    public void testAddBronze() {
        france.getClassement().addBronze(10);  // Ajout de 10 médailles de bronze au classement de la France
        assertEquals(10, france.getClassement().getBronze());  // Vérification que le nombre de médailles de bronze est bien 10
    }

    @Test
    public void testEquals() {
        // Ajout de médailles d'or, d'argent et de bronze au classement de la France
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        
        Classement c = new Classement();  // Création d'un nouveau classement
        // Ajout des mêmes médailles au nouveau classement
        c.addOr(6);
        c.addArgent(8);
        c.addBronze(10);
        
        assertEquals(france.getClassement(), c);  // Vérification que les deux classements sont égaux
        
        c.addBronze(1);  // Ajout d'une médaille de bronze supplémentaire au nouveau classement
        assertNotEquals(france.getClassement(), c);  // Vérification que les deux classements ne sont plus égaux
    }

    @Test
    public void testHashCode() {
        // Ajout de médailles au classement de la France
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        
        Classement c = new Classement();  // Création d'un nouveau classement
        // Ajout de médailles au nouveau classement
        c.addOr(4);
        c.addArgent(2);
        c.addBronze(0);
        
        // Vérification des hash codes des classements
        assertEquals(france.getClassement().hashCode(), (31 * 6 * 8 * 10 + 17) / 17);  // Calcul du hash code attendu pour le classement de la France
        assertEquals(c.hashCode(), 1);  // Vérification du hash code attendu pour le nouveau classement
    }

    @Test
    public void testToString() {
        // Ajout de médailles au classement de la France
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        
        Classement c = new Classement();  // Création d'un nouveau classement
        // Ajout de médailles au nouveau classement
        c.addOr(4);
        c.addArgent(2);
        c.addBronze(0);
        
        // Vérification des chaînes de caractères retournées par toString
        assertEquals(france.getClassement().toString(), "Médailles d'or : 6, Médailles d'argent : 8, Médailles de bronze : 10");  // Chaîne de caractères attendue pour le classement de la France
        assertEquals(c.toString(), "Médailles d'or : 4, Médailles d'argent : 2, Médailles de bronze : 0");  // Chaîne de caractères attendue pour le nouveau classement
    }
}
