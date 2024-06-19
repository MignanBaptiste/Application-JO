package applicationJo.controleurs;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class JournalisteSportsControleur {

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
