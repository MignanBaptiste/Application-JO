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

    public void afficheFenetreAccueil() throws Exception{
        this.centre.setCenter(new FenetreAccueil());
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
        ImageView imageMaison = new ImageView("home.png");
        imageMaison.setFitHeight(20);
        imageMaison.setFitWidth(20);
        this.boutonHome.setGraphic(imageMaison);

        Label titre = new Label("Jeux Olympiques 2024");
        titre.setPadding(new Insets(10));
        
        haut.getChildren().addAll(titre, this.boutonHome);
        return haut;
    }

    private Scene laScene() throws Exception{
        BorderPane fenetre = new FenetreAccueil();
        return new Scene(fenetre);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Paris 2024");
        stage.setScene(this.laScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}