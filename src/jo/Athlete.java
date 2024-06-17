package jo;

import jo.exception.AlreadyInException;
import jo.exception.InvalidSexeException;
import jo.exception.InvalidTypeException;

/**
 * Représente un athlète participant à des compétitions.
 * Implémente les interfaces Participant et Comparable<Athlete>.
 */
public class Athlete implements Participant {
    private String nomAthlete; // Le nom de l'athlète
    private String prenomAthlete; // Le prénom de l'athlète
    private Sexe sexe; // Le sexe de l'athlète
    private int force; // La force de l'athlète
    private int agilite; // L'agilité de l'athlète
    private int endurance; // L'endurance de l'athlète
    private Pays pays; // Le pays d'origine de l'athlète
    private Equipe equipe; // L'équipe à laquelle appartient l'athlète

    /**
     * Crée un nouvel athlète avec les informations spécifiées.
     * @param nom Nom de l'athlète.
     * @param prenom Prénom de l'athlète.
     * @param sexe Sexe de l'athlète.
     * @param force Force de l'athlète.
     * @param agilite Agilité de l'athlète.
     * @param endurance Endurance de l'athlète.
     * @param pays Pays de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, Pays pays) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
    }

    /**
     * Crée un nouvel athlète avec les informations spécifiées (ajout de l'équipe).
     * @param nom Nom de l'athlète.
     * @param prenom Prénom de l'athlète.
     * @param sexe Sexe de l'athlète.
     * @param force Force de l'athlète.
     * @param agilite Agilité de l'athlète.
     * @param endurance Endurance de l'athlète.
     * @param pays Pays de l'athlète.
     * @param equipe Equipe de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, Pays pays, Equipe equipe) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
        this.equipe = equipe;
    }

    /**
     * Ajoute une équipe à l'athlète.
     * @param equ Une équipe.
     */
    public void ajoutEquipe(Equipe equ){
        this.equipe = equ;
    }

    /**
     * Renvoie le nom de l'athlète.
     * @return Nom de l'athlète.
     */
    public String getNomAthlete() {
        return this.nomAthlete;
    }

    /**
     * Renvoie le prénom de l'athlète.
     * @return Prénom de l'athlète.
     */
    public String getPrenomAthlete() {
        return this.prenomAthlete;
    }

    /**
     * Renvoie le sexe de l'athlète.
     * @return Sexe de l'athlète.
     */
    public Sexe getSexe() {
        return this.sexe;
    }

    @Override
    /**
     * Renvoie le pays auquel appartient l'athlète.
     * @return Pays de l'athlète.
     */
    public Pays getPays() {
        return this.pays;
    }

    @Override
    /**
     * Renvoie l'équipe à laquelle appartient l'athlète.
     * @return Équipe de l'athlète.
     */
    public Equipe getEquipe() {
        return this.equipe;
    }

    @Override
    /**
     * Renvoie le nom complet de l'athlète.
     * @return Nom complet de l'athlète.
     */
    public String getNom() {
        return this.nomAthlete + " " + this.prenomAthlete;
    }

    @Override
    /**
     * Renvoie la force de l'athlète.
     * @return Force de l'athlète.
     */
    public int getForce() {
        return this.force;
    }

    @Override
    /**
     * Renvoie l'agilité de l'athlète.
     * @return Agilité de l'athlète.
     */
    public int getAgilite() {
        return this.agilite;
    }

    @Override
    /**
     * Renvoie l'endurance de l'athlète.
     * @return Endurance de l'athlète.
     */
    public int getEndurance() {
        return this.endurance;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
    * Permet à l'athlète de participer à une épreuve.
    * @param epreuve L'épreuve à laquelle l'athlète participe.
    */
    public void participer(@SuppressWarnings("rawtypes") Epreuve epreuve) {
        try {
            epreuve.addParticipant(this);
        } catch (InvalidTypeException e) {
            System.out.println("Impossible de participer à cette épreuve.");
        }
        catch (InvalidSexeException e2){
            System.out.println("Impossible de participer à cette épreuve.");
        }
        catch (AlreadyInException e3){
            System.out.println("Impossible de participer à cette épreuve.");
        }
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Athlete.
     * @return Représentation sous forme de chaîne.
     */
    public String toString() {
        return this.prenomAthlete + " " + this.nomAthlete;
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
        if (!(o instanceof Athlete)){return false;}
        Athlete a = (Athlete) o;
        return this.nomAthlete.equals(a.getNomAthlete()) && this.prenomAthlete.equals(a.getPrenomAthlete()) && 
        this.force == a.getForce() && this.agilite == a.getAgilite() && this.endurance == a.getEndurance();
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.nomAthlete.length() * this.prenomAthlete.length() * this.force * this.agilite * this.endurance) / 17 ;
    }

}

