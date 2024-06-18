package applicationJo.vues;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;;

public class ApplicationTest extends Application{
    
    @Override
    public void start(Stage arg0) throws Exception {
        VBox root = new VBox();

        Scene scene = new Scene(root);
        arg0.setTitle("Test");
        arg0.setScene(scene);
        arg0.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
