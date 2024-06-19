package applicationJo.vues;

import java.io.IOException;

import applicationJo.controleurs.AccueilControleur;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class JeuxIUTOlympiques extends Application {

    private Scene scene;
    private BorderPane centre;
    private FenetreAccueil fenetreAccueil;

    @Override
    public void init() throws Exception {
        this.centre = new BorderPane();
        this.scene = new Scene(this.centre);
        this.fenetreAccueil = new FenetreAccueil(this, new AccueilControleur(this));
    }

    // public void creationDuLoader() {
    //     this.loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
    // }

    // public void creationControleur() throws Exception {
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
    //     this.scene = new Scene(loader.load());

    //     System.out.println("creation bouton");
    //     Button bConnexion = (Button) this.scene.lookup("#btnConnexion");

    //     if (bConnexion != null) {
    //         bConnexion.setOnAction(new AccueilControleur(this));
    //         System.out.println("bouton créé");
    //     } else {
    //         System.out.println("aegnip");
    //     }
    // }

    public void afficheHello() {
        System.out.println("hello");
    }

    public void afficheFenetreAccueil() throws Exception {
        this.centre.setCenter(new FenetreAccueil(this, new AccueilControleur(this)));
    }

    public void afficheFenetreConnexion() throws Exception {
        FenetreAccueil fenetreAccueil = new FenetreAccueil(this, new AccueilControleur(this));
        this.centre.setCenter(fenetreAccueil.afficheFenetreConnexion());
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Paris 2024");
        this.afficheFenetreAccueil();
        stage.setScene(this.scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}