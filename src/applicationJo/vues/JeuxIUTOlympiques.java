package applicationJo.vues;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class JeuxIUTOlympiques extends Application {

    private Button boutonHome;

    private BorderPane centre;

    @Override
    public void init() throws Exception {
        this.centre = new BorderPane();
    }

    private Pane fenetreLogin(){
        Pane res = new Pane();
        return res;
    }

    private void modeLogin() {
        this.centre.setCenter(fenetreLogin());
    }

    private HBox header() {
        HBox haut = new HBox();
        haut.setStyle("-fx-background-color: #000000;");
        haut.setPadding(new Insets(20,10,20,10));

        this.boutonHome = new Button();
        ImageView imageMaison = new ImageView("file:home.png");
        imageMaison.setFitHeight(20);
        imageMaison.setFitWidth(20);
        this.boutonHome.setGraphic(imageMaison);

        Label titre = new Label("Jeux Olympiques 2024");
        titre.setPadding(new Insets(10));
        
        haut.getChildren().addAll(titre, this.boutonHome);
        return haut;
    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.header());
        this.centre.setPadding(new Insets(15));
        fenetre.setCenter(this.centre);
        return new Scene(fenetre, 800, 1000);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Paris 2024");
        stage.setScene(this.laScene());
        this.modeLogin();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}