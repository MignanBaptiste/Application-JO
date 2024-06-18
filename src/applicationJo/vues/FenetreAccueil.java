package applicationJo.vues;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreAccueil extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));

        Scene scene = new Scene(root); 
        primaryStage.setTitle("Ma Fenêtre JavaFX"); // Titre de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
