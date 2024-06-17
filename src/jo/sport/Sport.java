package jo.sport;

/**
 * Cette classe représente un sport abstrait.
 */
public abstract class Sport {
    private String categorie; // La catégorie du sport
    protected int coeffForce; // Coefficient de force pour ce sport
    protected int coeffAgilite; // Coefficient d'agilité pour ce sport
    protected int coeffEndurance; // Coefficient d'endurance pour ce sport

    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     */
    public Sport(String categorie){
        this.categorie = categorie;
    }

    /**
     * Renvoie la catégorie du sport.
     * @return La catégorie du sport.
     */
    public String getCategorie(){
        return this.categorie;
    }

    /**
     * Renvoie le coefficient de force pour ce sport.
     * @return Le coefficient de force pour ce sport.
     */
    public int getCoeffForce(){
        return this.coeffForce;
    }

    /**
     * Renvoie le coefficient d'agilité pour ce sport.
     * @return Le coefficient d'agilité pour ce sport.
     */
    public int getCoeffAgilite(){
        return this.coeffAgilite;
    }

    /**
     * Renvoie le coefficient d'endurance pour ce sport.
     * @return Le coefficient d'endurance pour ce sport.
     */
    public int getCoeffEndurance(){
        return this.coeffEndurance;
    }

    @Override
    /**
     * Vérifie si cet objet est égal à l'objet spécifié.
     * 
     * @param o l'objet à comparer avec cet objet
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o){
        if (o == null){return false;}
        if (this == o){return true;}
        if (!(o instanceof Sport)){return false;}
        Sport s = (Sport) o;
        return this.categorie.equals(s.getCategorie()) && this.coeffForce == s.getCoeffForce() && 
        this.coeffAgilite == s.coeffAgilite && this.coeffEndurance == s.coeffEndurance;
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.coeffAgilite * this.coeffEndurance * this.coeffForce + this.categorie.length()) / 17 ;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de cet objet.
     * 
     * @return une chaîne de caractères représentant les attributs de l'objet
     */
    public String toString() {
        return "Sport {" +
                "categorie='" + categorie + '\'' +
                ", coeffForce=" + coeffForce +
                ", coeffAgilite=" + coeffAgilite +
                ", coeffEndurance=" + coeffEndurance +
                '}';
    }

}


