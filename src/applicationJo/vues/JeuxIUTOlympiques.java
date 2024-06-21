package applicationJo.vues;

import applicationJo.controleurs.AccueilControleur;
import applicationJo.database.BDAjout;
import applicationJo.database.BDSelection;
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
    private BDAjout bdAjout;
    private BDSelection bdSelection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        connexionMySQL = new ConnexionMySQL();
        jeuxOlympiques = new JeuxOlympiques(2024);
        bdAjout = new BDAjout(connexionMySQL);
        bdSelection = new BDSelection(connexionMySQL, jeuxOlympiques);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
        Parent root = loader.load();
        AccueilControleur accueilControleur = loader.getController();
        accueilControleur.setConnexionMySQL(connexionMySQL);
        accueilControleur.setJO(jeuxOlympiques);
        accueilControleur.setAjout(bdAjout);
        accueilControleur.setSelection(bdSelection);

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