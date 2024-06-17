package jo.sport;

public class Natation extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     */
    public Natation (String categorie){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 2;
        this.coeffEndurance = 5;
    }
}
