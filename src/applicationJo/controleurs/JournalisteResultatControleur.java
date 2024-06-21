package applicationJo.controleurs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jo.*;
import jo.exception.InvalidTypeException;
import jo.sport.*;

public class JournalisteResultatControleur {

    private ConnexionMySQL connexionMySQL;
    private JeuxOlympiques jeuxOlympiques;
    private BDAjout bdAjout;
    private BDSelection bdSelection;

    @FXML
    private Label infoLabel;
    @FXML
    private Label infoLabel2;
    @FXML
    private Label infoLabel3;
    @FXML
    private GridPane resultGridPane;

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
    public void setSourceInfo(String info, String info2, String info3) {
        infoLabel.setText(info);
        infoLabel2.setText(info2);
        infoLabel3.setText(info3);
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
    private void handleResultats() throws InvalidTypeException, SQLException{
        System.out.println("Bonjour ?");
        System.out.println(this.infoLabel.getText());
        System.out.println(this.infoLabel2.getText());
        System.out.println(this.infoLabel3.getText());
        Sexe sexe;
        if (this.infoLabel3.getText().equals("F")){
            sexe = Sexe.FEMME;
            System.out.println("Sexe initialisé");
        }
        else {
            sexe = Sexe.HOMME;
            System.out.println("Sexe initialisé");}
        Sport sport;
        if (this.infoLabel.getText().contains("Ath")){
                sport = new Athletisme(this.infoLabel2.getText());
                System.out.println("Sport initialisé");
            }
            else if (this.infoLabel.getText().contains("Escrime")){
                sport = new Escrime(this.infoLabel2.getText());
                System.out.println("Sport initialisé");
            }
            else if (this.infoLabel.getText().contains("Handball")){
                sport = new Handball(this.infoLabel2.getText());
                System.out.println("Sport initialisé");
            }
            else if (this.infoLabel.getText().contains("Natation")){
                sport = new Natation(this.infoLabel2.getText());
                System.out.println("Sport initialisé");
            }
            else if (this.infoLabel.getText().contains("Volley-Ball")){
                sport = new VolleyBall(this.infoLabel2.getText());
                System.out.println("Sport initialisé");
            }
            else{
                throw new InvalidTypeException(this.infoLabel.getText() + " n'est pas considéré comme un sport");
            }

            resultGridPane.getChildren().clear();
            System.out.println("GridPane initialisé");
            

            if (this.infoLabel2.getText().contains("relais") || this.infoLabel2.getText().contains("Handball") || this.infoLabel2.getText().contains("Volley-Ball")){
                Epreuve<Equipe> epv = new Epreuve<>(sexe, sport);
                System.out.println("Collective faite");
                if (jeuxOlympiques.getEpreuves().contains(epv)){
                    System.out.println("Condition complétée");
                    HashMap<String, Integer> res;
                    res = bdSelection.classementCollective(epv);
                    int row = 0;
                    for (Map.Entry<String, Integer> entry : res.entrySet()) {
                        Label teamLabel = new Label(entry.getKey());
                        Label scoreLabel = new Label(entry.getValue().toString());
                        resultGridPane.add(teamLabel, 0, row);
                        resultGridPane.add(scoreLabel, 1, row);
                        row++;
                    }
                }
            }
            else{
                Epreuve<Athlete> epv = new Epreuve<>(sexe, sport);
                System.out.println("Individuelle faite");
                if (jeuxOlympiques.getEpreuves().contains(epv)){
                    System.out.println("Condition complétée");
                    HashMap<List<String>, Integer> res;
                    res = bdSelection.classementIndividuelle(epv);
                    int row = 0;
                    for (Map.Entry<List<String>, Integer> entry : res.entrySet()) {
                        Label athleteLabel = new Label(String.join(", ", entry.getKey()));
                        Label scoreLabel = new Label(entry.getValue().toString());
                        resultGridPane.add(athleteLabel, 0, row);
                        resultGridPane.add(scoreLabel, 1, row);
                        row++;
                    }
                }
            }
        }
}
