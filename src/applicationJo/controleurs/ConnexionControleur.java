package applicationJo.controleurs;

import java.io.IOException;
import java.util.Optional;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import jo.*;

public class ConnexionControleur {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private PasswordField mdp;

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;

    public void setConnexionMySQL(ConnexionMySQL connexionMySQL) {
        this.connexionMySQL = connexionMySQL;
    }

    public void setJO(JeuxOlympiques jeuxOlympiques){
        this.jeuxOlympiques = jeuxOlympiques;
    }

    @FXML
    private void initialize() {
        nom.setOnKeyPressed(this::handleEnterKey);
        prenom.setOnKeyPressed(this::handleEnterKey);
        mdp.setOnKeyPressed(this::handleEnterKey);
    }

    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            handleConnecter();
        }
    }

    @FXML
    private void handleConnecter(){
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String motDePasse = this.mdp.getText();

        if (nom.isEmpty() || prenom.isEmpty() || motDePasse.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs incomplets");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant de continuer.");
            alert.showAndWait();
        } else {
            try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreUser.fxml"));
                Parent root = loader.load();
                UserControleur controleur = loader.getController();
                controleur.setConnexionMySQL(connexionMySQL);
                controleur.setJO(jeuxOlympiques);

                // Changer la scène actuelle
                Stage stage = (Stage) this.nom.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
            Parent root = loader.load();
            AccueilControleur controleur = loader.getController();
            controleur.setConnexionMySQL(connexionMySQL);
            controleur.setJO(jeuxOlympiques);

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
