package applicationJo.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jo.*;
import jo.sport.*;

public class BDSelection {
    private ConnexionMySQL connexion;
    private JeuxOlympiques jo;
    private Statement st;

    public BDSelection(ConnexionMySQL connexion, JeuxOlympiques jo){
        this.connexion = connexion;
        this.jo = jo;
    }

    public HashMap<List<String>, Integer> classementIndividuelle(Epreuve<Athlete> epreuve) throws SQLException{
        HashMap<List<String>, Integer> res = new HashMap<>();
        // Parcourir la liste des participants d'une épreuve

        PreparedStatement ps = connexion.prepareStatement("select score, nomAthlete, prenomAthlete, nomPays from ATHLETE natural join EPREUVE where sexe = ? and nomSport = ? and categorieSport = ? order by score");
        if (epreuve.getSexe().equals(Sexe.FEMME)){
            ps.setString(1, "F");
        }
        else{
            ps.setString(1, "M");
        }
        ps.setString(2, epreuve.getSport().getSport());
        ps.setString(3, epreuve.getSport().getCategorie());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int score = rs.getInt(1);
            List<String> athlete = Arrays.asList(rs.getString(2), rs.getString(3), rs.getString(4)); 
            res.put(athlete, score);
        }
        return res;
    }

    public HashMap<String, Integer> classementCollective(Epreuve<Equipe> epreuve) throws SQLException{
        HashMap<String, Integer> res = new HashMap<>();
        // Parcourir la liste des participants d'une épreuve

        PreparedStatement ps = connexion.prepareStatement("select nomPays, score from EQUIPE natural join EPREUVE where sexe = ? and nomSport = ? and categorieSport = ? order by score");
        if (epreuve.getSexe().equals(Sexe.FEMME)){
            ps.setString(1, "F");
        }
        else{
            ps.setString(1, "M");
        }
        ps.setString(2, epreuve.getSport().getSport());
        ps.setString(3, epreuve.getSport().getCategorie());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            res.put(rs.getString(1), rs.getInt(2));
        }
        return res;
    }

    // Méthode pour ajouter les médailles aux classements des pays de façon dynamique
    public void ajoutMedailles() throws SQLException{
        PreparedStatement ps = connexion.prepareStatement("select * from COLLECTIVE");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Sexe sexe;
            if (rs.getString(1).equals("F")){
                sexe = Sexe.FEMME;
            }
            else{
                sexe = Sexe.HOMME;
            }
            Sport sport;
            if (rs.getString(2).equals("Athletisme")){
                sport = new Athletisme(rs.getString(3));
            }
            else if (rs.getString(2).equals("Escrime")){
                sport = new Escrime(rs.getString(3));
            }
            else if (rs.getString(2).equals("Handball")){
                sport = new Handball(rs.getString(3));
            }
            else if (rs.getString(2).equals("Natation")){
                sport = new Natation(rs.getString(3));
            }
            else if (rs.getString(2).equals("Volley-Ball")){
                sport = new VolleyBall(rs.getString(3));
            }
            else{
                sport = new Escrime(rs.getString(3));
            }
            Epreuve<Equipe> epreuve = new Epreuve<>(sexe, sport);
        }
    }
}
