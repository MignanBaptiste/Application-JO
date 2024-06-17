package jo.sport;

public class Handball extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     */
    public Handball (String categorie){
        super(categorie);
        this.coeffForce = 4;
        this.coeffAgilite = 4;
        this.coeffEndurance = 3;
        this.nbjoueursmaxequipe = 14;
    }
}