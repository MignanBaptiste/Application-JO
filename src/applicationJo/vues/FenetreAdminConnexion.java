package applicationJo.vues;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class FenetreAdminConnexion extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreAdminConnexion(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreAdminConnexion.fxml")));
        this.setCenter(loader.load());
    }

    // public void retourHome() throws Exception {
    //     this.appli.afficheFenetreAccueil();
    // }

    // public void afficheFenetreJournalisteSport() throws Exception{
    //     this.appli.afficheFenetreJournalisteSport();
    // }
}
