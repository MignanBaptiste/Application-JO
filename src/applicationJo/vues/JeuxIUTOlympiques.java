package applicationJo.vues;

import applicationJo.controleurs.AccueilControleur;
import applicationJo.database.ConnexionMySQL;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jo.JeuxOlympiques;

public class JeuxIUTOlympiques extends Application {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;

    @Override
    public void start(Stage primaryStage) throws Exception {
        connexionMySQL = new ConnexionMySQL();
        jeuxOlympiques = new JeuxOlympiques(2024);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
        Parent root = loader.load();
        AccueilControleur accueilControleur = loader.getController();
        accueilControleur.setConnexionMySQL(connexionMySQL);
        accueilControleur.setJO(jeuxOlympiques);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // Fermer la connexion MySQL lors de la fermeture de l'application
        if (connexionMySQL != null && connexionMySQL.isConnecte()) {
            connexionMySQL.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}