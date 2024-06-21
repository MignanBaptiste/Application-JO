package applicationJo.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jo.*;
import jo.sport.*;

/**
 * Permet de récupérer les classements pour l'affichage
 */
public class BDSelection {
    private ConnexionMySQL connexion;
    private JeuxOlympiques jo;
    /**
     * Constructeur de la classe permettant de récupérer des classements des pays et des athlètes
     * @param connexion Connexion à la base de données
     * @param jo Les données une fois chargées
     */
    public BDSelection(ConnexionMySQL connexion, JeuxOlympiques jo){
        this.connexion = connexion;
        this.jo = jo;
    }

    /**
     * Permet d'obtenir le classement des athlètes dans une épreuve individuelle
     * @param epreuve Epreuve individuelle dont l'on veut connaître le classement
     * @return  Le nom de l'athlète, son prénom et le nom du pays en clé ainsi que son score en valeur
     * @throws SQLException
     */
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
        rs.close();
        return res;
    }

    /**
     * Permet d'obtenir le classement des équipes dans une épreuve collective
     * @param epreuve Epreuve collective dont l'on veut connaître le classement
     * @return Le nom du pays en clé et son score en valeur
     * @throws SQLException
     */
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
        rs.close();
        return res;
    }

    /**
     * Méthode pour ajouter les médailles aux classements des pays de façon dynamique
     * @throws SQLException
     */
    private void ajoutMedailles() throws SQLException{
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
                sport = new Escrime(rs.getString(3)); // Juste histoire d'avoir quelque chose
            }
            Epreuve<Equipe> epreuve = new Epreuve<>(sexe, sport);

            for (Epreuve epreuve2 : jo.getEpreuves()){
                if (epreuve.equals(epreuve2)){
                    // Si on trouve la bonne épreuve on récupère les équipes et leur score trier par score
                    ps = connexion.prepareStatement("select nomPays, score from EQUIPE natural join COLLECTIVE where sexe = ? and nomSport = ? and nomCategorie = ? order by score");
                    ps.setString(1, rs.getString(1));
                    ps.setString(2, rs.getString(2));
                    ps.setString(3, rs.getString(3));
                    ResultSet rs2 = ps.executeQuery();
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addOr();
                        }
                    }
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addArgent();
                        }
                    }
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addArgent();
                        }
                    }
                }
            }
        }
        ps = connexion.prepareStatement("select * from INDIVIDUELLE");
        rs = ps.executeQuery();
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
                sport = new Escrime(rs.getString(3)); // Juste histoire d'avoir quelque chose
            }
            Epreuve<Athlete> epreuve = new Epreuve<>(sexe, sport);

            for (Epreuve epreuve2 : jo.getEpreuves()){
                if (epreuve.equals(epreuve2)){
                    // Si on trouve la bonne épreuve on récupère les équipes et leur score trier par score
                    ps = connexion.prepareStatement("select nomPays, score from ATHLETE natural join INDIVIDUELLE where sexe = ? and nomSport = ? and nomCategorie = ? order by score");
                    ps.setString(1, rs.getString(1));
                    ps.setString(2, rs.getString(2));
                    ps.setString(3, rs.getString(3));
                    ResultSet rs2 = ps.executeQuery();
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addOr();
                        }
                    }
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addArgent();
                        }
                    }
                    rs2.next();
                    for (Pays pays : jo.getPays()){
                        if (pays.equals(new Pays(rs2.getString(1)))){
                            pays.getClassement().addArgent();
                        }
                    }
                    rs2.close();
                }
            }
        }
    rs.close();
    }

    /**
     * Permet d'obtenir toutes les médailles de chaque pays
     * @return Le pays et son classement
     */
    public HashMap<Pays, Classement> getTotalMedailles(){
        jo.resetClassement();
        try {
            ajoutMedailles();
        } catch (SQLException e) {
            // Alerte problèmes
        }
        return jo.medaillesParPays();
    }

    /**
     * Permet d'obtenir un classement des pays en fonction du nombre de médailles d'or de chaque pays
     * @return Le pays et son nombre de médaille d'or
     */
    public HashMap<Pays, Integer> getMedaillesOR(){
        HashMap<Pays, Integer> res = new HashMap<>();
        HashMap<Pays, Classement> medailles = getTotalMedailles();
        for (Pays pays : jo.medaillesOr()){
            res.put(pays, medailles.get(pays).getOr());
        }
        return res;
    }

    /**
     * Permet d'obtenir un classement des pays en fonction du nombre de médailles de chaque pays
     * @return Le pays et son nombre de médailles
     */
    public HashMap<Pays, Integer> getNbMedailles(){
        HashMap<Pays, Integer> res = new HashMap<>();
        HashMap<Pays, Classement> medailles = getTotalMedailles();
        for (Pays pays : jo.medaillesTotales()){
            res.put(pays, medailles.get(pays).getOr() + medailles.get(pays).getArgent() + medailles.get(pays).getBronze());
        }
        return res;
    }
}
