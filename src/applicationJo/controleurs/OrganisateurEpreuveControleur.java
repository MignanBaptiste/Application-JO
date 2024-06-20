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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import jo.*;

public class OrganisateurEpreuveControleur {

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
    private void handleLancer(ActionEvent event) {
        if (comboSport.getValue().contains("Choisir") || comboEpreuve.getValue().contains("Choisir") || comboSexe.getValue().contains("Choisir")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs incomplets");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant de continuer.");
            alert.showAndWait();
                try {
                    // Charger la vue d'accueil
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreOrganisateurLancerEprv.fxml"));
                    Parent root = loader.load();
                    OrganisateurResultatControleur controleur = loader.getController();
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
        else {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation des choix");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Êtes vous sûr de vos choix ?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    // Charger la vue d'accueil
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreOrganisateurResultat.fxml"));
                    Parent root = loader.load();
                    OrganisateurResultatControleur controleur = loader.getController();
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
    }


    @FXML
    private ComboBox<String> comboSport;

    @FXML
    private ComboBox<String> comboEpreuve;

    @FXML
    private ComboBox<String> comboSexe;


    @FXML
    private void initialize() {
        comboSport.getItems().addAll("Athlétisme", "Escrime", "Natation", "HandBall", "VolleyBall");
        comboSport.setValue("Choisir un sport");

        comboEpreuve.setValue("Choisir une épreuve");

        comboSexe.setValue("Choisir un Sexe");
        comboSexe.getItems().addAll("Homme","Femme");

        comboSport.setOnAction(event -> {
            String sport = comboSport.getSelectionModel().getSelectedItem();
            comboSport.setValue(sport);
            System.out.println("Sport sélectionné : " + sport);
        });

        comboEpreuve.setOnAction(event -> {
            if(comboSport.getValue().equals("Athlétisme")){
                comboEpreuve.getItems().addAll("110m haies","4 X 100m relais");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
                System.out.println("Épreuve sélectionnée : " + epv);
            }
            else if(comboSport.getValue().equals("Escrime")){
                comboEpreuve.getItems().clear();
                comboEpreuve.getItems().addAll("Fleuret","Épée");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
                System.out.println("Épreuve sélectionnée : " + epv);
            }
            else if(comboSport.getValue().equals("Natation")){
                comboEpreuve.getItems().clear();
                comboEpreuve.getItems().addAll("Fleuret","Épée");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
                System.out.println("Épreuve sélectionnée : " + epv);
            }
            else if(comboSport.getValue().equals("HandBall")){
                comboEpreuve.getItems().clear();
                comboEpreuve.getItems().addAll("Match");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
                System.out.println("Épreuve sélectionnée : " + epv);
            }
            else if(comboSport.getValue().equals("VolleyBall")){
                comboEpreuve.getItems().clear();
                comboEpreuve.getItems().addAll("Match");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
                System.out.println("Épreuve sélectionnée : " + epv);
            }
        });
    }

   /*  @FXML
    private void updateComboEpreuve(String sport) {
        if(!(comboSport.getValue().equals("Choisir un sport"))){
            if(comboSport.getValue().equals("Ahtlétisme")){
                comboEpreuve.getItems().addAll("110m haies","4 X 100m relais");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
            }
            else if(comboSport.getValue().equals("Escrime")){
                comboEpreuve.getItems().clear();
                comboEpreuve.getItems().addAll("Fleuret","Épée");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
            }
            else if(comboSport.getValue().equals("Natation")){
                comboEpreuve.getItems().addAll("Fleuret","Épée");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
            }
            else if(comboSport.getValue().equals("HandBall")){
                comboEpreuve.getItems().addAll("Match");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
            }
            else if(comboSport.getValue().equals("VolleyBall")){
                comboEpreuve.getItems().addAll("Match");
                String epv = comboSport.getSelectionModel().getSelectedItem();
                comboEpreuve.setValue(epv);
            }
        }
        else{
            if (comboSport.getValue().equals("Choisir un sport")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs incomplets");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez choisir une sport pour choisir l'épreuve.");
                alert.showAndWait();
            }
        }

    } */

    
}
