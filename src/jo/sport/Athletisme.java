package jo.sport;

public class Athletisme extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     */
    public Athletisme (String categorie){
        super(categorie);
        this.coeffForce = 4;
        this.coeffAgilite = 3;
        this.coeffEndurance = 3;
        this.nbjoueursmaxequipe = 4;
    }
}