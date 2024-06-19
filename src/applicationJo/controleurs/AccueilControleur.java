package applicationJo.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AccueilControleur {

    @FXML
    private void handleSeConnecterButton() {
        afficherPopup("Se Connecter");
    }

    @FXML
    private void handleSinscrireButton() {
        afficherPopup("S'inscrire");
    }

    private void afficherPopup(String action) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action effectuée");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez choisi de " + action);
        alert.showAndWait();
    }
}

