package jo.sport;

public class VolleyBall extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     */
    public VolleyBall (String categorie){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 5;
        this.coeffEndurance = 2;
    }
}