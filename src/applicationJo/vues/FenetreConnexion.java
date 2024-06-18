package applicationJo.vues;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreConnexion extends BorderPane{

    public FenetreConnexion() throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("../../../fxml/FenetreConnexion.fxml"));
        this.setCenter(root);
        
        //lookUp : faire apres le show()
    }
}
