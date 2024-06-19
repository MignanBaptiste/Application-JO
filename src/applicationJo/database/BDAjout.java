package applicationJo.database;

import java.sql.*;

import jo.*;
import jo.sport.*;

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
     * Permet de connaitre le nombre d'athlète dans la base de données
     * @return le nombre d'athlète dans la base de données
     * @throws SQLException
     */
    private int nbAthlete() throws SQLException{
        st= connexion.createStatement();
		ResultSet rs = st.executeQuery("select IFNULL(count(*), 0) nbAthlete from ATHLETE");
		rs.next();
		int res = rs.getInt(1);
		rs.close();
		return res;
    }

    /**
     * Ajoute un athlète à la base de données
     * @param athlete athlète à ajouter à la base de données
     */
    public void ajoutAthlete(Athlete athlete){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into ATHLETE(nomAthlete, prenomAthlete, sexe, laForce, agilite, endurence, idPays) values (?,?,?,?,?,?,?)");
            ps.setInt(1, nbAthlete()+1);
            ps.setString(2, athlete.getNom());
            ps.setString(3, athlete.getPrenomAthlete());
            if (athlete.getSexe().equals(Sexe.HOMME)){
                ps.setString(4, "M");
            }
            else{
                ps.setString(4, "F");
            }
            ps.setInt(5, athlete.getForce());
            ps.setInt(6, athlete.getAgilite());
            ps.setInt(7, athlete.getEndurance());
            ps.setInt(7, this.getIdPays(athlete.getPays()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Athlète déjà dans la base de données");
        }
    }

    /**
     * Permet de connaître l'id d'un pays dans la base de données
     * @param pays Pays dont l'on veut connaître l'id
     * @return l'id du pays
     * @throws SQLException
     */
    private int getIdPays(Pays pays) throws SQLException{
        st= connexion.createStatement();
		ResultSet rs = st.executeQuery("select idPays from PAYS where nomPays = " + pays.getNom());
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
            PreparedStatement ps = connexion.prepareStatement(""); // Pas fini
            ps.executeUpdate();
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
            PreparedStatement ps = connexion.prepareStatement(""); // Pas fini
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
            PreparedStatement ps = connexion.prepareStatement(""); // Pas fini
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Epreuve Collective déjà dans la base de données");
        }
    }

    /**
     * Renvoie le nombre de pays dans la base de données
     * @return le nombre de pays dans la base de données
     * @throws SQLException
     */
    private int nbPays() throws SQLException{
        st= connexion.createStatement();
		ResultSet rs = st.executeQuery("select IFNULL(count(*), 0) nbPays from PAYS");
		rs.next();
		int res = rs.getInt(1);
		rs.close();
		return res;
    }
    
    /**
     * Permet d'ajouter un pays à la base de données
     * @param pays Pays à ajouter à la base de données
     */
    public void ajoutPays(Pays pays){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into PAYS values (?, ?);");
            ps.setInt(1, nbPays()+1);
            ps.setString(2, pays.getNom());
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
            PreparedStatement ps = connexion.prepareStatement(""); // Pas fini
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
            PreparedStatement ps = connexion.prepareStatement(""); // Pas fini
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Impossible de faire participer ce participant dans l'épreuve dans la base de données");
        }
    }

    /**
     * Renvoie le nombre de Sport dans la base de données
     * @return le nombre de Sport dans la base de données
     * @throws SQLException
     */
    private int nbSport() throws SQLException{
        st= connexion.createStatement();
		ResultSet rs = st.executeQuery("select IFNULL(count(*), 0) nbSport from SPORT");
		rs.next();
		int res = rs.getInt(1);
		rs.close();
		return res;
    }

    /**
     * Permet d'ajouter un sport à la base de données
     * @param sport Un sport parmis les suivants: Athlètisme, Escrime, Handball, Natation, Volley-ball
     */
    public void ajoutSport(Sport sport){
        try {
            PreparedStatement ps = connexion.prepareStatement("insert into PAYS values (?, ?);");
            ps.setInt(1, nbSport()+1);
            ps.setString(2, sport.getSport());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Pays déjà dans la base de données");
        }
    }
}
