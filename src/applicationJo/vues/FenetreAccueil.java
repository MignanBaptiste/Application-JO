package applicationJo.vues;

import applicationJo.controleurs.AccueilControleur;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreAccueil extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreAccueil(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
        this.setCenter(loader.load());
        Button bConnexion = (Button) this.lookup("#btnConnexion");
        bConnexion.setOnAction(new AccueilControleur(this.appli));
    }

    public FenetreAccueil afficheFenetreAccueil() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
        this.setCenter(loader.load());
        Button bConnexion = (Button) this.lookup("#btnConnexion");
        bConnexion.setOnAction(new AccueilControleur(this.appli));
        return this;
    }

    public FenetreAccueil afficheFenetreSinscrire() throws Exception {
        this.appli.afficheFenetreConnexion();
        return this;
    }

    public FenetreAccueil afficheFenetreConnexion() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreConnexion.fxml"));
        this.setCenter(loader.load());
        Button bConnexion = (Button) this.lookup("#btnConnexion");
        bConnexion.setOnAction(new AccueilControleur(this.appli));
        return this;
    }
}
