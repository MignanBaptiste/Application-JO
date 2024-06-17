package jo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jo.exception.*;
import jo.sport.Sport;

/** Class permettant de créer une épreuve ayant des participants */
public class Epreuve<T extends Participant>{
    private Sexe sexe; // Le sexe de l'épreuve
    private Sport sport; // Le sport de l'épreuve
    private List<T> participants; // La liste des participants à l'épreuve

    /**
     * Permet de créer une épreuve.
     * @param sexe Le sexe de l'épreuve.
     * @param sport Le sport de l'épreuve.
     */
    public Epreuve(Sexe sexe, Sport sport){
        this.sexe = sexe;
        this.sport = sport;
        this.participants = new ArrayList<>();
    }

    /**
     * Renvoie le sexe de l'épreuve.
     * @return Sexe Le sexe de l'épreuve.
     */
    public Sexe getSexe(){return this.sexe;}

    /**
     * Renvoie le sport de l'épreuve.
     * @return Sport Le sport de l'épreuve.
     */
    public Sport getSport(){return this.sport;}
    
    /**
     * Permet d'ajouter un participant à une épreuve.
     * @param participant Le participant à ajouter.
     */
    public void addParticipant(T participant) throws InvalidTypeException, InvalidSexeException, AlreadyInException {
        if(participant.getSexe() != null){
            if(this.sexe != participant.getSexe() && participant instanceof Athlete){
                if(this.sexe.equals(Sexe.HOMME)){
                    throw new InvalidSexeException("Cette épreuve est une épreuve Masculine (ath)");
                }
                throw new InvalidSexeException("Cette épreuve est une épreuve Féminine (ath)");
            }
            if(this.sexe != participant.getSexe() && participant instanceof Equipe){
                if(this.sexe.equals(Sexe.HOMME)){
                    throw new InvalidSexeException("Cette épreuve est une épreuve Masculine (epv)");
                }
                throw new InvalidSexeException("Cette épreuve est une épreuve Féminine (epv)");
            }
        }
        if (this.participants.contains(participant)){
            throw new AlreadyInException("Déjà ajouté à l'épreuve");
        }
        if(!(this.participants.isEmpty())){
            if(participant instanceof Athlete && participants.get(0) instanceof Athlete){
                this.participants.add(participant);
            }
            else if(participant instanceof Equipe && participants.get(0) instanceof Equipe){
                this.participants.add(participant);
            }
            else{
                if(participant instanceof Athlete){
                    throw new InvalidTypeException("Vous ne pouvez pas ajouter un athlète dans une épreuve constituée d'équipes");
                }
                else {
                    throw new InvalidTypeException("Vous ne pouvez pas ajouter une équipe dans une épreuve constituée d'athlète");
                }
            }
        } // Ces 2 tests permettent de créer des épreuves constituées uniquement d'équipe ou uniquement d'athlete
        else if(this.participants.isEmpty()){
            this.participants.add(participant);
        }
    }
    
    /**
     * Renvoie la liste des participants à l'épreuve.
     * @return List<Participant> La liste des participants à l'épreuve.
     */
    public List<T> getParticipants(){return this.participants;}
    
    /**
     * Renvoie le résultat de l'épreuve.
     * @return HashMap<T, Integer> Le résultat de l'épreuve.
     */
    public HashMap<T, Integer> resultats() throws NothingInException {
        if(this.participants.isEmpty()){
            throw new NothingInException("Il n'y a pas de participants pour cette épreuve");}
        HashMap<T, Integer> res = new HashMap<>();
        for(T participant: this.participants){
            int score = 0;
            score += participant.getForce() * this.sport.getCoeffForce();
            score += participant.getAgilite() * this.sport.getCoeffAgilite();
            score += participant.getEndurance() * this.sport.getCoeffEndurance();
            
            double randomnombre = 0.5 + (Math.random() * 0.5);
            score = (int) Math.round(score * randomnombre); // de cette manière ce n'est pas forcément le meilleur qui gagne

            res.put(participant, score);
        }
        return res;
    }

    /**
     * Renvoie le classement de l'épreuve.
     * @return List<T> Le classement de l'épreuve.
     */
    public List<T> classementEpv(){
        try {
            HashMap<T, Integer> res = this.resultats();
            List<T> participantsTri = new ArrayList<>(this.participants);
            participantsTri.sort((p1, p2) -> res.get(p2).compareTo(res.get(p1))); // Tri par ordre décroissant des scores
            return participantsTri;
        } catch (NothingInException e) {
            System.out.println("Il n'y a pas de participants pour cette épreuve");
        }
    return null;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Epreuve.
     * @return Représentation sous forme de chaîne.
     */
    public String toString() {
        if (this.sexe.equals(Sexe.FEMME)){
            return "Epreuve de " + this.sport.getCategorie() + " Féminin";
        }
        else{
            return "Epreuve de " + this.sport.getCategorie() + " Masculin";
        }
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
        if (!(o instanceof Epreuve)){return false;}
        Epreuve<?> e = (Epreuve<?>) o;
        return this.sport.equals(e.getSport()) && this.sexe.equals(e.getSexe());
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.sport.hashCode() * this.sexe.hashCode()) / 17 ;
    }
}
