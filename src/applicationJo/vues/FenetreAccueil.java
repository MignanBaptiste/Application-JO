package applicationJo.vues;

import applicationJo.controleurs.ContAccueil;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreAccueil extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreAccueil(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreAccueil.fxml"));
        this.setCenter(loader.load());
        Button bHome = (Button) this.lookup("#btnHome");
        bHome.setOnAction(new ContAccueil(this));
        Button bSinscrire = (Button) this.lookup("#btnSinscrire");
        bSinscrire.setOnAction(new ContAccueil(this));
        Button bConnexion = (Button) this.lookup("#btnConnexion");
        bConnexion.setOnAction(new ContAccueil(this));
    }

    public void afficheFenetreConnexion() throws Exception {
        this.appli.afficheFenetreConnexion();
    }

    public void afficheFenetreInscription() throws Exception {
        this.appli.afficheFenetreInscription();
    }

    public void hello() {
        System.out.println("aaze");
    }
}
