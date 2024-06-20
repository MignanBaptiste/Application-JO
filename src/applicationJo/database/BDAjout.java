package applicationJo.database;

import java.sql.*;
import java.util.HashMap;

import jo.*;
import jo.sport.*;

/**
 * Permet d'ajouter des données à la base de données
 */
public class BDAjout {
    private ConnexionMySQL connexion;
    private Statement st; 

    /**
     * Builder de BDajout, permet d'ajouter des éléments à la base de données
     * @param connexion
     */
    public BDAjout(ConnexionMySQL connexion){
        this.connexion = connexion;
    }

    /**
     * Ajoute un athlète à la base de données
     * @param athlete athlète à ajouter à la base de données
     */
    public void ajoutAthlete(Athlete athlete){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into ATHLETE(nomAthlete, prenomAthlete, sexe, laForce, agilite, endurance, nomPays, score) values (?,?,?,?,?,?,?, -1)");
            ps.setString(1, athlete.getNom());
            ps.setString(2, athlete.getPrenomAthlete());
            if (athlete.getSexe().equals(Sexe.HOMME)){
                ps.setString(3, "M");
            }
            else{
                ps.setString(3, "F");
            }
            ps.setInt(4, athlete.getForce());
            ps.setInt(5, athlete.getAgilite());
            ps.setInt(6, athlete.getEndurance());
            ps.setString(7, athlete.getPays().getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Athlète déjà dans la base de données");
        }
    }

    private int nbEquipe(Equipe equipe) throws SQLException{
        PreparedStatement ps = connexion.prepareStatement("select IFNULL(count(*), 0) nbEquipe from EQUIPE where nomPays = ?, nomSport = ?, categorieSport = ?");
        ps.setString(1, equipe.getPays().getNom());
        ps.setString(2, equipe.getSport().getSport());
        ps.setString(3, equipe.getSport().getCategorie());
        ResultSet rs = ps.executeQuery();
        rs.next();
        int res = rs.getInt(1);
        rs.close();
        return res;
    }

    /**
     * Permet d'ajouter une équipe à la base de données
     * @param equipe L'équipe à ajouter à la base de données
     */
    public void ajoutEquipe(Equipe equipe){
        try {
            if (nbEquipe(equipe) < 2){
                PreparedStatement ps = connexion.prepareStatement("insert into EQUIPE(nomPays, nomSport, categorieSport, score) values (?, ?, ?, -1)");
                ps.setString(1, equipe.getPays().getNom());
                ps.setString(2, equipe.getSport().getSport());
                ps.setString(2, equipe.getSport().getCategorie());
                ps.executeUpdate();
            }
            else{
                // Renvoyer qqc pour déclencher une alerte pour annoncer que ce pays à déjà assez d'équipe dans ce sport.
            }
        } catch (SQLException e) {
            System.out.println("Equipe déjà dans la base de données");
        }
    }

    /**
     * Permet d'ajouter une épreuve individuelle dans la base de données
     * @param epreuve Une épreuve individuelle
     */
    public void ajoutIndividuelle(Epreuve<Athlete> epreuve){
        try {
            String sexe;
            if (epreuve.getSexe().equals(Sexe.FEMME)){
                sexe = "F";
            }
            else{
                sexe = "M";
            }
            String sport = epreuve.getSport().getSport();
            String catégorie = epreuve.getSport().getCategorie();
            PreparedStatement ps = connexion.prepareStatement("insert into EPREUVE(sexe, nomSport, categorieSport) values (?, ?, ?)");
            ps.setString(1, sexe);
            ps.setString(2, sport);
            ps.setString(3, catégorie);
            ps.executeUpdate();
            ps = connexion.prepareStatement("insert into INDIVIDUELLE(sexe, nomSport, categorieSport) values (?, ?, ?)");
            ps.setString(1, sexe);
            ps.setString(2, sport);
            ps.setString(3, catégorie);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Epreuve Individuelle déjà dans la base de données");
        }
    }

    /**
     * Permet d'ajouter une épreuve collective dans la base de données
     * @param epreuve Une épreuve collective
     */
    public void ajoutCollective(Epreuve<Equipe> epreuve){
        try {
            String sexe;
            if (epreuve.getSexe().equals(Sexe.FEMME)){
                sexe = "F";
            }
            else{
                sexe = "M";
            }
            String sport = epreuve.getSport().getSport();
            String catégorie = epreuve.getSport().getCategorie();
            PreparedStatement ps = connexion.prepareStatement("insert into EPREUVE(sexe, nomSport, categorieSport) values (?, ?, ?)");
            ps.setString(1, sexe);
            ps.setString(2, sport);
            ps.setString(3, catégorie);
            ps.executeUpdate();
            ps = connexion.prepareStatement("insert into COLLECTIVE(sexe, nomSport, categorieSport) values (?, ?, ?)");
            ps.setString(1, sexe);
            ps.setString(2, sport);
            ps.setString(3, catégorie);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Epreuve Collective déjà dans la base de données");
        }
    }
    
    /**
     * Permet d'ajouter un pays à la base de données
     * @param pays Pays à ajouter à la base de données
     */
    public void ajoutPays(Pays pays){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into PAYS values (?);");
            ps.setString(1, pays.getNom());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Pays déjà dans la base de données");
        }
    }

    /**
     * Permet d'ajouter un athlète à une équipe
     * @param athlete Athlète à ajouter à l'équipe
     * @param equipe L'équipe à laquelle il faut ajouter l'athlète
     */
    public void athleteParticipeEquipe(Athlete athlete, Equipe equipe){
        try {
            PreparedStatement ps;
            // Mettre à jour le sexe d'un équipe s'il n'est pas défini car sinon le natural join ne fonctionne pas
            st= connexion.createStatement();
		    ResultSet rs = st.executeQuery("select IFNULL(sexe, 'N') sexe, nomSport, categorieSport, nomPays from EQUIPE where nomPays = "+equipe.getPays().getNom()+ " and sexe = NULL");
            String sexe = "";
            while (!rs.isLast() && !sexe.equals("N")){
                rs.next();
		        sexe = rs.getString(1);
                if (sexe.equals("N")){
                    ps = connexion.prepareStatement("UPDATE EQUIPE SET sexe = ? WHERE nomSport = ? and categorieSport = ? and nomPays = ?");
                    if (athlete.getSexe().equals(Sexe.FEMME)){
                        ps.setString(1, "F");
                    }
                    else{
                        ps.setString(1, "M");
                    }
                    ps.setString(2, rs.getString(2));
                    ps.setString(3, rs.getString(3));
                    ps.setString(4, rs.getString(4));
                    ps.executeUpdate();
                }
            }
            rs.close();
            ps = connexion.prepareStatement("UPDATE ATHLETE SET nomSport = ? WHERE nomAthlete = ? and prenomAthlete = ?");
            ps.setString(1, equipe.getSport().getSport());
            ps.setString(2, athlete.getNom());
            ps.setString(3, athlete.getPrenomAthlete());
            ps.executeUpdate();
            ps = connexion.prepareStatement("UPDATE ATHLETE SET categorieSport = ? WHERE nomAthlete = ? and prenomAthlete = ?");
            ps.setString(1, equipe.getSport().getCategorie());
            ps.setString(2, athlete.getNom());
            ps.setString(3, athlete.getPrenomAthlete());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Impossible de faire entrer cet athlète dans l'équipe dans la base de données");
        }
    }

    /**
     * Permet d'ajouter un participant à une épreuve 
     * @param participant Le participant à ajouter à l'épreuve
     * @param epreuve L'épreuve à laquelle il faut ajouter le participant
     */
    public void participantEpreuve(Participant participant, Epreuve epreuve){
        try {
            PreparedStatement ps;
            if (participant instanceof Athlete){
                Athlete athlete = (Athlete) participant;
                ps = connexion.prepareStatement("UPDATE ATHLETE SET nomSport = ? WHERE nomAthlete = ? and prenomAthlete = ?");
                ps.setString(1, epreuve.getSport().getSport());
                ps.setString(2, athlete.getNom());
                ps.setString(3, athlete.getPrenomAthlete());
                ps.executeUpdate();
                ps = connexion.prepareStatement("UPDATE ATHLETE SET categorieSport = ? WHERE nomAthlete = ? and prenomAthlete = ?");
                ps.setString(1, epreuve.getSport().getCategorie());
                ps.setString(2, athlete.getNom());
                ps.setString(3, athlete.getPrenomAthlete());
                ps.executeUpdate();
            }
            else{
                // Alerte pour demander d'ajouter au moins un athlète à l'équipe avant de l'ajouter à l'épreuve car sinon ça le fait tout seul. 
            }
        } catch (Exception e) {
            System.out.println("Impossible de faire participer ce participant dans l'épreuve dans la base de données");
        }
    }

    /**
     * Permet d'ajouter un sport à la base de données
     * @param sport Un sport parmis les suivants: Athlètisme, Escrime, Handball, Natation, Volley-ball
     */
    public void ajoutSport(Sport sport){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into SPORT values (?, ?);");
            ps.setString(1, sport.getSport());
            ps.setString(2, sport.getCategorie());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Pays déjà dans la base de données");
        }
    }

    /**
     * Permet de simuler une épreuve et ajoute les scores
     * @param epreuve L'épreuve à simuler
     */
    public void simulation(Epreuve epreuve){
        try {
            PreparedStatement ps;
            HashMap<Object, Integer> res = epreuve.resultats();
            for (Object participant : res.keySet()){
                if (participant instanceof Athlete){
                    Athlete athlete = (Athlete) participant;
                    ps = connexion.prepareStatement("UPDATE ATHLETE SET score = ? WHERE nomAthlete = ? and prenomAthlete = ?");
                    ps.setString(2, athlete.getNom());
                    ps.setString(3, athlete.getPrenomAthlete());
                }
                else{
                    Equipe equipe = (Equipe) participant;
                    ps = connexion.prepareStatement("UPDATE EQUIPE SET score = ? WHERE nomSport = ? and categorieSport = ? and nomPays = ?");
                    ps.setString(2, equipe.getSport().getSport());
                    ps.setString(3, equipe.getSport().getCategorie());
                    ps.setString(4, equipe.getPays().getNom());
                }
                ps.setInt(1, res.get(participant));
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Impossible de faire la simulation de cette épreuve");
        }
    }
}
