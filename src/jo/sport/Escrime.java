package jo.sport;

public class Escrime extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     */
    public Escrime (String categorie){
        super(categorie);
        this.coeffForce = 2;
        this.coeffAgilite = 5;
        this.coeffEndurance = 3;
    }
}