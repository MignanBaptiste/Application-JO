package jo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet; 

import java.util.List;

import applicationJo.database.ConnexionMySQL;
import jo.exception.*;
import jo.sport.*;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques {

    private int annee; // L'année des Jeux Olympiques
    @SuppressWarnings("rawtypes")
    private List<Epreuve> lesEpreuves; // Liste des épreuves des Jeux Olympiques
    private List<Athlete> lesAthletes;

    /**
     * Constructeur de la classe JeuxOlympiques.
     * 
     * @param annee L'année des Jeux Olympiques.
     */
    public JeuxOlympiques(int annee) {
        this.annee = annee;
        this.lesEpreuves = new ArrayList<>();
        this.lesAthletes = new ArrayList<>();
    }

    /**
     * Renvoie l'année des Jeux Olympiques.
     * 
     * @return int L'année des Jeux Olympiques.
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Renvoie toutes les épreuves des Jeux Olympiques.
     * 
     * @return List<Epreuve> Liste de toutes les épreuves des Jeux Olympiques.
     */
    @SuppressWarnings("rawtypes")
    public List<Epreuve> getEpreuves() {
        return this.lesEpreuves;
    }

    /**
     * Renvoie le nombre d'épreuves des Jeux Olympique de cette année
     * @return int nombre d'Epreuve
     */
    public int getNbEpreuves(){
        return this.lesEpreuves.size();
    }

    /**
     * Renvoie la liste d'athlètes participant aux Jeux Olympique de cette année
     * @return List<Athlete> liste d'Athlete
     */
    public List<Athlete> getAthletes() {
        return this.lesAthletes;
    }

    /**
     * Renvoie le nombre d'athlètes participant aux Jeux Olympique de cette année
     * @return int nombre d'Athlete
     */
    public int getNbAthletes(){
        return this.getAthletes().size();
    }

    /**
     * Renvoie l'ensemle d'équipes participant aux Jeux Olympique de cette année
     * @return HashSet<Equipe> liste d'Equipe
     */
    public List<Equipe> getEquipes() {
        List<Equipe> lesEquipes = new ArrayList<>();
        for (Athlete ath: this.lesAthletes){
            if (ath.getEquipe() != null){
                if (lesEquipes.contains(ath.getEquipe())){
                    lesEquipes.add(ath.getEquipe());
                }
            }
        }
        return lesEquipes;
    }

    /**
     * Renvoie le nombre d'équipes participant aux Jeux Olympique de cette année
     * @return int nombre de d'Equipe
     */
    public int getNbEquipes(){
        return this.getEquipes().size();
    }

    /**
     * Renvoie les pays participant aux Jeux Olympique de cette année
     * @return HashSet<Pays> liste de Pays
     */
    public List<Pays> getPays(){
        List<Pays> lesPays = new ArrayList<>();
        for (Athlete ath : this.getAthletes()){
            if (!lesPays.contains(ath.getPays())){
                lesPays.add(ath.getPays());
            }
        }
        return lesPays;
    }

    /**
     * Renvoie le nombre de pays participant aux Jeux Olympique de cette année
     * @return int nombre de Pays
     */
    public int getNbPays(){
        return this.getPays().size();
    }
    //

    /**
     * Ajoute une épreuve à la liste des épreuves des Jeux Olympiques.
     * 
     * @param epv L'épreuve à ajouter.
     */
    public void addEpreuve(@SuppressWarnings("rawtypes") Epreuve epv) {
        this.lesEpreuves.add(epv);
    }

    /**
     * Ajoute un athlète à la liste des athlètes des Jeux Olympiques.
     * 
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath) {
        this.lesAthletes.add(ath);
    }

    /**
     * Calcule le nombre de médailles par pays.
     * 
     * @return HashMap<Pays, Classement>> Nombre de médailles par pays.
     */
    public HashMap<Pays, Classement> medaillesParPays() {
        HashMap<Pays, Classement> res = new HashMap<>();
        for (Pays pays : this.getPays()){
            res.put(pays, pays.getClassement());
        }
        return res;
    }

    
    /**
     * Renvoie la liste des pays classés par nombre de médailles d'or.
     * 
     * @return List<Pays> Liste des pays classés par nombre de médailles d'or.
     */
    public List<Pays> medaillesOr() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesOr = new HashMap<>();
        
        // Parcours de toutes les épreuves
        for (@SuppressWarnings("rawtypes") Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            @SuppressWarnings("unchecked")
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                Pays p = participant.getPays();
                int i = p.getClassement().getOr();
                if (!(medaillesOr.containsKey(p))){
                    medaillesOr.put(p, i);
                }
            }   
        }
        res.addAll(medaillesOr.keySet());
        res.sort((p1, p2) -> medaillesOr.get(p2).compareTo(medaillesOr.get(p1))); // Tri des pays en fonction du nombre de médailles d'or
        return res;
    }


    /**
     * Renvoie la liste des pays classés par nombre total de médailles.
     * 
     * @return List<Pays> Liste des pays classés par nombre total de médailles.
     */
    public List<Pays> medaillesTotales() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesTotales = new HashMap<>();
        
        // Parcours de toutes les épreuves
        for (@SuppressWarnings("rawtypes") Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            @SuppressWarnings("unchecked")
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                Pays p = participant.getPays();
                int i = p.getClassement().totalMedailles();
                if (!(medaillesTotales.containsKey(p))){
                    medaillesTotales.put(p, i);
                }
            }
        }
        // Tri des pays en fonction du nombre total de médailles
        res.addAll(medaillesTotales.keySet());
        res.sort((p1, p2) -> medaillesTotales.get(p2).compareTo(medaillesTotales.get(p1)));
        return res;
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
        if (!(o instanceof JeuxOlympiques)){return false;}
        JeuxOlympiques jo = (JeuxOlympiques) o;
        return this.annee == jo.getAnnee();
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.annee) / 17 ;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de cet objet.
     * 
     * @return une chaîne de caractères représentant les attributs de l'objet
     */
    public String toString() {
        return "Jeux Olympiques de " + this.annee;
    }
    
    /**
     * Permet de charger un fichier contenant des épreuves, athlètes/équipes.
     * @param chemin
     * @throws InvalidTypeException
     */
    @SuppressWarnings("unchecked") 
    public void load_csv(String chemin) throws InvalidTypeException{
        // Chargement d'un fichier CSV où chaque ligne est une liste
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
    }
        } catch (IOException e) {
            System.out.println("Fichier invalide");
        }
        // Création des instances de class
        for (List<String> liste : records){
            Sexe sexe;
            if (liste.get(2).equals("M")){
                sexe = Sexe.HOMME;
            }
            else{
                sexe = Sexe.FEMME;
            }
            Sport sport;
            if (liste.get(4).contains("Ath")){
                sport = new Athletisme(liste.get(4));
            }
            else if (liste.get(4).contains("Escrime")){
                sport = new Escrime(liste.get(4));
            }
            else if (liste.get(4).contains("Handball")){
                sport = new Handball(liste.get(4));
            }
            else if (liste.get(4).contains("Natation")){
                sport = new Natation(liste.get(4));
            }
            else if (liste.get(4).contains("Volley-Ball")){
                sport = new VolleyBall(liste.get(4));
            }
            else{
                throw new InvalidTypeException(liste.get(4) + " n'est pas considéré comme un sport");
            }
            Pays pays = new Pays(liste.get(3));
            if (this.getPays().contains(pays)){
                pays = this.getPays().get(this.getPays().indexOf(pays));
            }
            Athlete ath = new Athlete(liste.get(0), liste.get(1), sexe, Integer.valueOf(liste.get(5)), Integer.valueOf(liste.get(6)), Integer.valueOf(liste.get(7)), pays);
            this.lesAthletes.add(ath);
            // Si la catégorie de l'épreuve contient ces mots clés, c'est une épreuve collective
            if (liste.get(4).contains("relais") || liste.get(4).contains("Handball") || liste.get(4).contains("Volley-Ball")){
                Epreuve<Equipe> epv = new Epreuve<>(sexe, sport);
                if (this.lesEpreuves.contains(epv)){
                    epv = this.lesEpreuves.get(this.lesEpreuves.indexOf(epv));
                }
                else{
                    this.lesEpreuves.add(epv);
                }
                Equipe eqp = new Equipe(sport, ath.getPays());
                if (epv.getParticipants().contains(eqp)){
                    eqp = epv.getParticipants().get(epv.getParticipants().indexOf(eqp));
                }
                else{
                    try {
                        epv.addParticipant(eqp);
                    } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
                        System.out.println("Pas possible d'ajouter l'équipe " + eqp.toString() + " à l'épreuve" + epv.toString());
                    }
                }
                try {
                    eqp.addAthlete(ath);
                } catch (InvalidSexeException | AlreadyInException | FilledElementException e) {
                    System.out.println("Pas possible d'ajouter l'athlète " + ath.toString() + " à l'équipe " + eqp.toString());
                }
            }
            else{
                Epreuve<Athlete> epv = new Epreuve<>(sexe, sport);
                if (this.lesEpreuves.contains(epv)){
                    epv = this.lesEpreuves.get(this.lesEpreuves.indexOf(epv));
                }
                else{
                    this.lesEpreuves.add(epv);
                }
                try {
                    epv.addParticipant(ath);
                } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
                    System.out.println("Pas possible d'ajouter l'athlète " + epv.toString() + " à l'épreuve " + epv.toString());
                }
            }
        }
    }

    // Besoin d'une méthode pour faire la simulation des épreuves.
    /**
     * Permet de faire la simulation des épreuves, utiliser dans la version avec l'executable
     */
    public void simulation(){
        this.resetClassement();
        for (@SuppressWarnings("rawtypes") Epreuve epv: this.lesEpreuves){
            @SuppressWarnings("unchecked")
            List<Participant> classement = epv.classementEpv();
            if (classement.get(0) instanceof Athlete){
                classement.get(0).getPays().getClassement().addOr();
                classement.get(1).getPays().getClassement().addArgent();
                classement.get(2).getPays().getClassement().addBronze();
            }
            else if(classement.get(0) instanceof Equipe){
                classement.get(0).getPays().getClassement().addOr();
                classement.get(1).getPays().getClassement().addArgent();
                classement.get(2).getPays().getClassement().addBronze();
            }
        }
    }

    /**
     * Permet réinitialiser les médailles de chaque pays, permet d'éviter qu'un épreuve soit compter plusieurs fois
     */
    public void resetClassement(){
        for (Pays pays: this.getPays()){
            pays.resetClassement();
        }
    }

    /**
     * Permet de charger une base de donnée dans les données dynamiques (JeuxOlympiques)
     * @param connexion Permet une connexion à la base de données
     */
    public void load_database(ConnexionMySQL connexion) throws SQLException{
        // Récupère les données
        
        // Parcours des athlètes
        PreparedStatement ps = connexion.prepareStatement("select * from ATHLETE");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            // Création de l'athlète : nom, prenom, sexe, force, agilite, endurence, pays
            Sexe sexe;
            if (rs.getString(3).equals("F")){
                sexe = Sexe.FEMME;
            }
            else{
                sexe = Sexe.HOMME;
            }
            Pays pays = new Pays(rs.getString(7));
            if (this.getPays().contains(pays)){
                pays = this.getPays().get(this.getPays().indexOf(pays));
            }
            String nom = rs.getString(1);
            String prenom = rs.getString(2);
            int force = rs.getInt(4);
            int agilite = rs.getInt(5);
            int endurance = rs.getInt(6);
            Athlete athlete = new Athlete(nom, prenom, sexe, force, agilite, endurance, pays);
            if (this.lesAthletes.contains(athlete)){
                athlete = lesAthletes.get(lesAthletes.indexOf(athlete));
            }
            String nomSport = rs.getString(9);
            String nomCategorie = rs.getString(10);
            Sport sport;
            if (nomSport.equals("Athletisme")){
                sport = new Athletisme(nomCategorie);
            }
            else if (nomSport.equals("Escrime")){
                sport = new Escrime(nomCategorie);
            }
            else if (nomSport.equals("Handball")){
                sport = new Handball(nomCategorie);
            }
            else if (nomSport.equals("Natation")){
                sport = new Natation(nomCategorie);
            }
            else if (nomSport.equals("Volley-Ball")){
                sport = new VolleyBall(nomCategorie);
            }
            else{
                sport = new Natation(nomCategorie);
            }
            // Récupérer l'équipe de cette athlète s'il en a une
            ps = connexion.prepareStatement("select nomPays, nomSport, categorieSport from EQUIPE natural join ATHLETE where nomAthlete = ? and prenomAthlete = ?");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ResultSet rs2 = ps.executeQuery();
            if (rs2.next()){
                Equipe equipe = new Equipe(sport, pays);
                if (this.getEquipes().contains(equipe)){
                    equipe = this.getEquipes().get(this.getEquipes().indexOf(equipe));
                }
                try {
                    equipe.addAthlete(athlete);
                } catch (Exception e) {
                    System.out.println("Problème de l'équipe "+ equipe);
                }
            }
            rs2.close();
            ps = connexion.prepareStatement("select nomAthlete, prenomAthlete from ATHLETE natural join INDIVIDUELLE where nomAthlete = ? and prenomAthlete = ?");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            rs2 = ps.executeQuery();
            if (rs2.next()){
                Epreuve<Athlete> epreuve = new Epreuve<>(sexe, sport);
                if (this.lesEpreuves.contains(epreuve)){
                    epreuve = lesEpreuves.get(lesEpreuves.indexOf(epreuve));
                }
                try {
                    epreuve.addParticipant(athlete);
                } catch (Exception e) {
                    System.out.println("Impossible d'ajouter l'athlète à l'épreuve");
                }
            }
            rs2.close();
            if (athlete.getEquipe() != null){
                // Faire en sorte que si athlete à une équipe, rechercher à quelle épreuve participe l'équipe dans la BD et la faire participer dans JO
            }
        }
        rs.close();
    }

    /**
     * Permet d'enregistrer les données dynamiques dans la base de données
     * @param connexion Permet une connexion à la base de données
     */
    public void save_database(ConnexionMySQL connexion){

    }
}