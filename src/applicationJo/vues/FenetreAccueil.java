package applicationJo.vues;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreAccueil extends BorderPane{

    public FenetreAccueil() throws Exception {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreAccueil.fxml")));
        this.setCenter(loader.load());
        Button bConnexion = (Button) root

        //lookUp : faire apres le show()
    }
}
