package applicationJo.vues;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class FenetreConnexion extends BorderPane{

    public FenetreConnexion() throws Exception {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreConnexion.fxml")));
        this.setCenter(loader.load());
        //lookUp : faire apres le show()
    }
}
