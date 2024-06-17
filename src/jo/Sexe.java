package jo;

// Enumération représentant les sexes des participants et des épreuves
public enum Sexe {
    HOMME("Mr."), // Constante pour homme
    FEMME("Mme."); // Constante pour femme

    private final String sexe; // Chaîne de caractères représentant le sexe

    // Constructeur privé de l'enum Sexe
    private Sexe(String sexe){
        this.sexe = sexe;
    }

    /**
     * Renvoie la représentation textuelle du sexe.
     * @return String La représentation textuelle du sexe.
     */
    public String getSexe(){
        return this.sexe;
    }
}
