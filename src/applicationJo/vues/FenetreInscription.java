package applicationJo.vues;

import applicationJo.controleurs.ContInscription;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreInscription extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreInscription(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../fxml/FenetreInscription.fxml"));
        this.setCenter(loader.load());
        Button bHome = (Button) this.lookup("#btnHome");
        bHome.setOnAction(new ContInscription(this));
        Button bRetour = (Button) this.lookup("#retour");
        bRetour.setOnAction(new ContInscription(this));
        Button bConnexion = (Button) this.lookup("#btnEnregistrer");
        bConnexion.setOnAction(new ContInscription(this));
    }

    public void retourHome() throws Exception {
        this.appli.afficheFenetreAccueil();
    }
}
