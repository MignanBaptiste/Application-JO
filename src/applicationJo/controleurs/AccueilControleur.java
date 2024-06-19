package applicationJo.controleurs;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccueilControleur {

    @FXML
    private void handleSeConnecterButton(ActionEvent event) {
        try {
            // Charger la nouvelle vue
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreConnexion.fxml"));
            Parent root = loader.load();
            
            // Obtenir le contrôleur associé
            ConnexionControleur connexionControleur = loader.getController();

            // Optionnel: vous pouvez passer des données au nouveau contrôleur si nécessaire
            // inscriptionControleur.setSomeData(data);

            // Changer la scène actuelle
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSinscrireButton(ActionEvent event) {
        try {
            // Charger la nouvelle vue
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreInscription.fxml"));
            Parent root = loader.load();
            
            // Obtenir le contrôleur associé
            InscriptionControleur inscriptionControleur = loader.getController();

            // Optionnel: vous pouvez passer des données au nouveau contrôleur si nécessaire
            // inscriptionControleur.setSomeData(data);

            // Changer la scène actuelle
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

