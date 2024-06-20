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
import javafx.stage.Stage;
import jo.*;

public class JournalisteSportsControleur {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;

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
    private void handleEscrime(ActionEvent event) {
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteEscrime.fxml"));
                Parent root = loader.load();
                JournalisteEscrimeControleur controleur = loader.getController();
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

    @FXML
    private void handleAthletisme(ActionEvent event) {
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteAth.fxml"));
                Parent root = loader.load();
                JournalisteAthControleur controleur = loader.getController();
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

    @FXML
    private void handleHandball(ActionEvent event) { //TO DO
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteSexe.fxml"));
                Parent root = loader.load();

                JournalisteSexeControleur journalisteSexeControleur = loader.getController();
                journalisteSexeControleur.setSourceInfo("Handball", "Handball");
                journalisteSexeControleur.setConnexionMySQL(connexionMySQL);
                journalisteSexeControleur.setJO(jeuxOlympiques);

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
    private void handleNatation(ActionEvent event) { 
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteNatation.fxml"));
                Parent root = loader.load();
                JournalisteNatationControleur controleur = loader.getController();
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

    @FXML
    private void handleVolleyBall(ActionEvent event) { //TO DO
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteSexe.fxml"));
                Parent root = loader.load();

                JournalisteSexeControleur journalisteSexeControleur = loader.getController();
                journalisteSexeControleur.setSourceInfo("Volley-Ball", "Volley-Ball");
                journalisteSexeControleur.setConnexionMySQL(connexionMySQL);
                journalisteSexeControleur.setJO(jeuxOlympiques);

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
    private void handleClassement(ActionEvent event) {
        try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreJournalisteClassement.fxml"));
                Parent root = loader.load();
                JournalisteClassementControleur controleur = loader.getController();
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
