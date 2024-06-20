package applicationJo.database;
import java.sql.*;

public class ConnexionMySQL {

	private Connection mysql;
	private boolean connecte;

	public ConnexionMySQL() throws ClassNotFoundException{
		Class.forName("org.mariadb.jdbc.Driver");
		this.mysql = null;
		this.connecte = false;
	}

	public void connecter(String nomServeur, String nomBase, String nomLogin, String motDePasse) throws SQLException {
		this.mysql = DriverManager.getConnection("jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin,motDePasse);
		this.connecte = true;
	}
	public void connecter(String nomLogin, String motDePasse) throws SQLException {
		// si tout c'est bien passé la connexion n'est plus nulle
		this.mysql = DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/DB"+nomLogin,nomLogin,motDePasse);
		this.connecte = true;
	}
	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}
	public boolean isConnecte() { return this.connecte;}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}
	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
}
