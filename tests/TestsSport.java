import jo.sport.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestsSport {
    // Test pour la classe Athletisme
    @Test 
    public void testAthletisme() {
        Athletisme a = new Athletisme("Athletisme");
        assertEquals(a.getCategorie(), "Athletisme");
        assertEquals(a.getCoeffForce(), 4);
        assertEquals(a.getCoeffAgilite(), 3);
        assertEquals(a.getCoeffEndurance(), 3);
    }

    // Test pour la classe Escrime
    @Test 
    public void testEscrime() {
        Escrime e = new Escrime("Escrime");
        assertEquals(e.getCategorie(), "Escrime");
        assertEquals(e.getCoeffForce(), 2);
        assertEquals(e.getCoeffAgilite(), 5);
        assertEquals(e.getCoeffEndurance(), 3);
    }

    // Test pour la classe Handball
    @Test 
    public void testHandball() {
        Handball h = new Handball("Handball");
        assertEquals(h.getCategorie(), "Handball");
        assertEquals(h.getCoeffForce(), 4);
        assertEquals(h.getCoeffAgilite(), 4);
        assertEquals(h.getCoeffEndurance(), 3);
    }

    // Test pour la classe Natation
    @Test 
    public void testNatation() {
        Natation n = new Natation("Natation");
        assertEquals(n.getCategorie(), "Natation");
        assertEquals(n.getCoeffForce(), 3);
        assertEquals(n.getCoeffAgilite(), 2);
        assertEquals(n.getCoeffEndurance(), 5);
    }

    // Test pour la classe VolleyBall
    @Test 
    public void testVolleyBall() {
        VolleyBall v = new VolleyBall("VolleyBall");
        assertEquals(v.getCategorie(), "VolleyBall");
        assertEquals(v.getCoeffForce(), 3);
        assertEquals(v.getCoeffAgilite(), 5);
        assertEquals(v.getCoeffEndurance(), 2);
    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        Natation n1 = new Natation("Natation 50 metres");
        Natation n2 = new Natation("Natation 100 metres");
        Natation n3 = new Natation("Natation 50 metres");
        VolleyBall v = new VolleyBall("VolleyBall");
        assertNotEquals(n1, n2);
        assertEquals(n1, n3);
        assertNotEquals(n3, v);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        Athletisme a = new Athletisme("Athletisme");
        Escrime e = new Escrime("Escrime");
        Handball h = new Handball("Handball");
        Natation n = new Natation("Natation");
        VolleyBall v = new VolleyBall("VolleyBall");
        assertEquals(a.hashCode(), (31*3*3*4 +10) / 17);
        assertEquals(e.hashCode(), (31*5*3*2 +7) / 17);
        assertEquals(h.hashCode(), (31*4*3*4 +8) / 17);
        assertEquals(n.hashCode(), (31*2*5*3 +8) / 17);
        assertEquals(v.hashCode(), (31*5*2*3 +10) / 17);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        Athletisme a = new Athletisme("Athletisme");
        Escrime e = new Escrime("Escrime");
        Handball h = new Handball("Handball");
        Natation n = new Natation("Natation");
        VolleyBall v = new VolleyBall("VolleyBall");
        assertEquals(a.toString(), "Sport {categorie='Athletisme', coeffForce=4, coeffAgilite=3, coeffEndurance=3}");
        assertEquals(e.toString(), "Sport {categorie='Escrime', coeffForce=2, coeffAgilite=5, coeffEndurance=3}");
        assertEquals(h.toString(), "Sport {categorie='Handball', coeffForce=4, coeffAgilite=4, coeffEndurance=3}");
        assertEquals(n.toString(), "Sport {categorie='Natation', coeffForce=3, coeffAgilite=2, coeffEndurance=5}");
        assertEquals(v.toString(), "Sport {categorie='VolleyBall', coeffForce=3, coeffAgilite=5, coeffEndurance=2}");
    }
}
