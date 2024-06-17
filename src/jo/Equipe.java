package jo;

import java.util.ArrayList;
import java.util.List;

import jo.exception.AlreadyInException;
import jo.exception.FilledElementException;
import jo.exception.InvalidSexeException;
import jo.exception.InvalidTypeException;
import jo.sport.*;


// Classe représentant une équipe participant à une compétition
public class Equipe implements Participant{
    private final Pays pays; // Le pays auquel appartient l'équipe
    private final Sport sport;
    private List<Athlete> athletes; // La liste des athlètes de l'équipe
    private Sexe sexe;
    

    /**
     * Création d'une nouvelle équipe avec un sport, un pays et une liste d'athlètes.
     * @param nomEquipe Le nom de l'équipe.
     * @param pays Le pays auquel appartient l'équipe.
     */
    public Equipe(Sport sport, Pays pays) {
        this.pays = pays;
        this.sport = sport;
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie la liste des athlètes de l'équipe.
     * @return List<Athlete> La liste des athlètes de l'équipe.
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Renvoie le sexe de l'équipe.
     * @return Sexe de l'athlète.
     */
    public Sexe getSexe() {
        return this.sexe;
    }

    /**
     * Ajoute un athlète à l'équipe et ajoute l'équipe à l'athlète.
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath) throws InvalidSexeException, AlreadyInException, FilledElementException{
        if (this.sport instanceof Handball | this.sport instanceof VolleyBall | this.sport.getCategorie().contains("relais")){
            if(this.athletes.size() == this.sport.getNombreJoueursMaxEquipe()){
                throw new FilledElementException("Cette équipe est pleine");
            }
        }
        if (this.sexe == null){
            this.sexe = ath.getSexe();
        }
        if(this.athletes.contains(ath)){
            throw new AlreadyInException("Athlète déjà dans l'équipe");
        }
        else if(this.sexe != ath.getSexe()){
            if(this.sexe.equals(Sexe.HOMME)){
                throw new InvalidSexeException("Cette équipe est une épreuve Masculine");
            }
            throw new InvalidSexeException("Cette équipe est une épreuve Féminine");
        }
        this.athletes.add(ath);
        ath.ajoutEquipe(this);
    }

    @Override
    /**
     * Renvoie le nom du pays de l'équipe.
     * @return String nom du pays de l'équipe.
     */
    public String getNom() {
        return this.pays.getNom();
    }

    @Override
    /**
     * Renvoie l'équipe elle-même.
     * @return Equipe L'équipe elle-même.
     */
    public Equipe getEquipe(){
        return this;
    }

    @Override
    /**
     * Renvoie la somme des forces de tous les athlètes de l'équipe.
     * @return int La somme des forces de tous les athlètes de l'équipe.
     */
    public int getForce(){
        int totalF = 0;
        for(Athlete a : this.athletes){
            totalF += a.getForce();
        }
        return totalF;
    }

    @Override
    /**
     * Renvoie la somme des agilités de tous les athlètes de l'équipe.
     * @return int La somme des agilités de tous les athlètes de l'équipe.
     */
    public int getAgilite(){
        int totalA = 0;
        for(Athlete a : this.athletes){
            totalA += a.getAgilite();
        }
        return totalA;
    }

    @Override
    /**
     * Renvoie la somme des endurances de tous les athlètes de l'équipe.
     * @return int La somme des endurances de tous les athlètes de l'équipe.
     */
    public int getEndurance(){
        int totalE = 0;
        for(Athlete a : this.athletes){
            totalE += a.getEndurance();
        }
        return totalE;
    }

    @Override
    /**
     * Renvoie le pays auquel appartient l'équipe.
     * @return Pays Le pays de l'équipe.
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Renvoie le sport auquel va participer l'équipe
     * @return
     */
    public Sport getSport(){
        return this.sport;
    }

    // @SuppressWarnings("unchecked") C'est quoi ?
    // @SuppressWarnings({ "rawtypes", "unchecked" })

    @SuppressWarnings("unchecked")
    @Override
    /**
     * Permet à l'équipe de participer à une épreuve en ajoutant l'équipe comme participant.
     * @param epreuve L'épreuve à laquelle l'équipe participe.
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

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'équipe.
     * @return La représentation de l'équipe sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Cette équipe représente le pays suivant : " + pays.getNom() + " en " + this.sport.getCategorie();
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
        if (!(o instanceof Equipe)){return false;}
        Equipe e = (Equipe) o;
        return this.pays.equals(e.getPays()) && this.sport.equals(e.getSport());
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return 31 * this.pays.hashCode() * this.sport.hashCode()/ 17 ;
    }
}

