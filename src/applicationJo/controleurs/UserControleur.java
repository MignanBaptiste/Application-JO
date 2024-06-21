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
import javafx.stage.Stage;
import jo.*;

public class UserControleur {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreConnexion.fxml"));
            Parent root = loader.load();
            ConnexionControleur controleur = loader.getController();
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
    private void handleJournaliste(ActionEvent event) {
        if (this.connexionMySQL.isConnecte()){
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
        else {
            System.out.println("Vous n'êtes pas connecté à une base de donnée");
        }
    }

    @FXML
    private void handleAdmin(ActionEvent event) { //chemin par défault
        try {
            // Charger la vue d'accueil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAdminConnexion.fxml"));
            Parent root = loader.load();
            AdminConnexionControleur controleur = loader.getController();
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
    private void handleOrga(ActionEvent event) { //chemin par défault
        if (this.connexionMySQL.isConnecte()){
            try {
                // Charger la vue d'accueil
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreOrganisateurLancerEprv.fxml"));
                Parent root = loader.load();
                OrganisateurEpreuveControleur controleur = loader.getController();
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
        else {
            System.out.println("Vous n'êtes pas connecté à une base de donnée");
        }
    }
}
