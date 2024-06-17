package jo;

/**
 * Représente le classement d'une équipe ou d'un participant dans une compétition.
 */
public class Classement {

    private int medailleOr; // Le nombre de médailles d'or
    private int medailleArgent; // Le nombre de médailles d'argent
    private int medailleBronze; // Le nombre de médailles de bronze

    /**
     * Initialise un classement avec aucun médaille.
     */
    public Classement(){
        this.medailleOr = 0;
        this.medailleArgent = 0;
        this.medailleBronze = 0;
    }

    /**
     * Renvoie le nombre de médailles d'or.
     * @return Le nombre de médailles d'or.
     */
    public int getOr(){
        return this.medailleOr;
    }

    /**
     * Renvoie le nombre de médailles d'argent.
     * @return Le nombre de médailles d'argent.
     */
    public int getArgent(){
        return this.medailleArgent;
    }

    /**
     * Renvoie le nombre de médailles de bronze.
     * @return Le nombre de médailles de bronze.
     */
    public int getBronze(){
        return this.medailleBronze;
    }

    /**
     * Ajoute un nombre de médailles d'or au classement.
     * @param nb Le nombre de médailles d'or à ajouter.
     */
    public void addOr(int nb){
        this.medailleOr += nb;
    }

    /**
     * Ajoute un nombre de médailles d'argent au classement.
     * @param nb Le nombre de médailles d'argent à ajouter.
     */
    public void addArgent(int nb){
        this.medailleArgent += nb;
    }

    /**
     * Ajoute un nombre de médailles de bronze au classement.
     * @param nb Le nombre de médailles de bronze à ajouter.
     */
    public void addBronze(int nb){
        this.medailleBronze += nb;
    }

    /**
     * Ajoute une médailles d'or au classement.
     */
    public void addOr(){
        ++this.medailleOr;
    }

    /**
     * Ajoute une médailles d'argent au classement.
     */
    public void addArgent(){
        ++this.medailleArgent;
    }

    /**
     * Ajoute une médailles de bronze au classement.
     */
    public void addBronze(){
        ++this.medailleBronze;
    }

    /**
     * Renvoie le nombre de médailles totales.
     * @return int Le nombre de médailles totales.
     */
    public int totalMedailles(){
        return this.medailleBronze + this.medailleArgent + this.medailleOr;
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
        if (!(o instanceof Classement)){return false;}
        Classement c = (Classement) o;
        return this.medailleBronze == c.getBronze() && this.medailleArgent == c.getArgent() && this.medailleOr == c.getOr();
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.medailleBronze * this.medailleArgent * this.medailleOr + 17) / 17 ;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de cet objet.
     * 
     * @return une chaîne de caractères représentant les attributs de l'objet
     */
    public String toString() {
        return "Médailles d'or : " + this.medailleOr + ", Médailles d'argent : " + this.medailleArgent + ", Médailles de bronze : " + this.medailleBronze;
    }
}

