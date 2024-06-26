package applicationJo.controleurs;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jo.*;

public class JournalisteSexeControleur {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;
    private BDAjout bdAjout;
    private BDSelection bdSelection;

    @FXML
    private Label infoLabel;
    @FXML
    private Label infoLabel2;

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

    // Méthode pour recevoir les informations de la première page
    public void setSourceInfo(String info, String info2) {
        infoLabel.setText(info);
        infoLabel2.setText(info2);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteSport.fxml"));
            Parent root = loader.load();
            JournalisteSportsControleur controleur = loader.getController();
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
    private void handleHomme(ActionEvent event){
        try {
            // Charger la vue d'accueil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteResultat.fxml"));
            Parent root = loader.load();

            JournalisteResultatControleur controleur = loader.getController();
            controleur.setSourceInfo(infoLabel.getText(), infoLabel2.getText(), "H");
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
    private void handleFemme(ActionEvent event){
        try {
            // Charger la vue d'accueil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteResultat.fxml"));
            Parent root = loader.load();

            JournalisteResultatControleur controleur = loader.getController();
            controleur.setSourceInfo(infoLabel.getText(), infoLabel2.getText(), "F");
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
