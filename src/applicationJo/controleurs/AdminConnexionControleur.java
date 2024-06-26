package applicationJo.controleurs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import applicationJo.database.BDAjout;
import applicationJo.database.BDSelection;
import applicationJo.database.ConnexionMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jo.*;

public class AdminConnexionControleur {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;

    @FXML
    private TextField nom;
    @FXML
    private PasswordField mdp;

    private BDAjout bdAjout;
    private BDSelection bdSelection;

    public void setAjout(BDAjout bdAjout){
        this.bdAjout = bdAjout;
    }

    public void setSelection(BDSelection bdSelection){
        this.bdSelection = bdSelection;
    }

    public void setConnexionMySQL(ConnexionMySQL connexionMySQL) {
        this.connexionMySQL = connexionMySQL;
    }

    public void setJO(JeuxOlympiques jeuxOlympiques){
        this.jeuxOlympiques = jeuxOlympiques;
    }

    @FXML
    private void handleHomeButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous retourner au menu de connexion ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
                Parent root = loader.load();
                AccueilControleur controleur = loader.getController();
                controleur.setConnexionMySQL(connexionMySQL);
                controleur.setJO(jeuxOlympiques);
                controleur.setAjout(bdAjout);
                controleur.setSelection(bdSelection);

                // Changer la scène actuelle
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleRetourButton(ActionEvent event) {
        try {
            // Charger la vue d'accueil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreUser.fxml"));
            Parent root = loader.load();
            UserControleur controleur = loader.getController();
            controleur.setConnexionMySQL(connexionMySQL);
            controleur.setJO(jeuxOlympiques);
            controleur.setAjout(bdAjout);
            controleur.setSelection(bdSelection);

            // Changer la scène actuelle
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleConnecter(ActionEvent event) {
        try {
            this.connexionMySQL.connecter(nom.getText(), mdp.getText());
        }
        catch (SQLException e){
            System.out.println("Il semble y avoir un problème avec la connexion");
        }
        if(this.connexionMySQL.isConnecte()){
            // Marche pas
            // try {
            //     this.jeuxOlympiques.load_database(connexionMySQL);
            // } catch (SQLException e) {
            //     System.out.println("impossible de load");
            // }
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAdminModif.fxml"));
            Parent root = loader.load();
            AdminModifControleur controleur = loader.getController();
            controleur.setConnexionMySQL(connexionMySQL);
            controleur.setJO(jeuxOlympiques);
            controleur.setAjout(bdAjout);
            controleur.setSelection(bdSelection);


            Stage stage = (Stage) this.nom.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
