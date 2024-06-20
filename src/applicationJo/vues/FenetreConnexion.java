package applicationJo.vues;

import applicationJo.controleurs.ContConnexion;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreConnexion extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreConnexion(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreConnexion.fxml")));
        this.setCenter(loader.load());
        Button bHome = (Button) this.lookup("#btnHome");
        bHome.setOnAction(new ContConnexion(this));
        Button bRetour = (Button) this.lookup("#retour");
        bRetour.setOnAction(new ContConnexion(this));
        Button bConnexion = (Button) this.lookup("#connexion");
        bConnexion.setOnAction(new ContConnexion(this));
    }

    public void retourHome() throws Exception {
        this.appli.afficheFenetreAccueil();
    }

    public void afficheFenetreUser() throws Exception{
        this.appli.afficheFenetreUser();
    }
}
