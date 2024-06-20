package applicationJo.vues;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JeuxIUTOlympiques extends Application {

    private Scene scene;
    private BorderPane centre;

    @Override
    public void init() throws Exception {
        this.centre = new BorderPane();
        this.scene = new Scene(this.centre);
    }

    public void afficheFenetreAccueil() throws Exception {
        this.centre.setCenter(new FenetreAccueil(this));
    }

    public void afficheFenetreConnexion() throws Exception {
        this.centre.setCenter(new FenetreConnexion(this));
    }

    public void afficheFenetreInscription() throws Exception {
        this.centre.setCenter(new FenetreInscription(this));
    }

    public void afficheFenetreUser() throws Exception {
        this.centre.setCenter(new FenetreUser(this));
    }

    public void afficheFenetreJournalisteSport() throws Exception {
        this.centre.setCenter(new FenetreJournalisteSport(this));
    }

    public void afficheFenetreAdminConnexion() throws Exception {
        this.centre.setCenter(new FenetreAdminConnexion(this));
    }

    public void afficheFenetreOrganisateurLancerEprv() throws Exception {
        this.centre.setCenter(new FenetreOrganisateurLancerEprv(this));
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