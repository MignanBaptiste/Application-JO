package applicationJo.database;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jo.Athlete;

public class BDAjout {
    private ConnexionMySQL connexion;
    public BDAjout(ConnexionMySQL connexion){
        this.connexion = connexion;
    }
    
    // public void ajoutAthlete(Athlete athlete){
    //     Statement st = connexion.createStatement();
    // }
    // int maxNumJoueur() throws SQLException{
	// 	st= laConnexion.createStatement();
	// 	ResultSet rs = st.executeQuery("select IFNULL(count(`numJoueur`), 0) leMax from `JOUEUR`");
	// 	rs.next();
	// 	int res = rs.getInt(1);
	// 	rs.close();
	// 	return res;
	// }
}
