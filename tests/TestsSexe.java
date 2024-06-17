import jo.Sexe;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestsSexe {
    
    @Test
    public void testHomme() {
        // Teste l'énumération pour le sexe "Homme"
        assertEquals("Mr.", Sexe.HOMME.getSexe()); // Vérifie que la représentation textuelle est "homme"
    }

    @Test
    public void testFemme() {
        // Teste l'énumération pour le sexe "Femme"
        assertEquals("Mme.", Sexe.FEMME.getSexe()); // Vérifie que la représentation textuelle est "femme"
    }
}


