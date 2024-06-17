package jo;

/** 
 * Interface Participant contenant les méthodes pour qu'un(e) Athlète/Equipe participe à une épreuve 
 */
public interface Participant {
    /**
     * Permet d'ajouter un participant à une épreuve
     * @param epv L'épreuve à laquelle le participant va participer
     */
    public void participer(@SuppressWarnings("rawtypes") Epreuve epv);

    /**
     * Renvoie le sexe d'un participant
     * @return Le sexe du participant
     */
    public Sexe getSexe();
    
    /**
     * Renvoie le nom d'un participant
     * @return Le nom du participant
     */
    public String getNom();

    /**
     * Renvoie l'équipe à laquelle le participant appartient
     * @return L'équipe du participant
     */
    public Equipe getEquipe();

    /**
     * Renvoie le pays duquel le participant est originaire
     * @return Le pays du participant
     */
    public Pays getPays();

    /**
     * Renvoie la force du participant
     * @return La force du participant
     */
    public int getForce();

    /**
     * Renvoie l'agilité du participant
     * @return L'agilité du participant
     */
    public int getAgilite();

    /**
     * Renvoie l'endurance du participant
     * @return L'endurance du participant
     */
    public int getEndurance();
}  
