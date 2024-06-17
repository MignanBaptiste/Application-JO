import jo.JeuxOlympiques;
import jo.exception.InvalidTypeException;

import org.junit.*;

public class TestLoadSave{
    private JeuxOlympiques jo;
    
    @Before
    public void setUp(){
        this.jo = new JeuxOlympiques(2021);
    }

    @Test
    public void testLoadCSV(){
        try {
            jo.load_csv("./donnees.csv");
        } catch (InvalidTypeException e) {
            System.out.println("Problème concernant les sports");
        }
    }
}