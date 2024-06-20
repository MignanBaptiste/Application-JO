package applicationJo.vues;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class FenetreOrganisateurLancerEprv extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreOrganisateurLancerEprv(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreOrganisateurLancerEprv.fxml")));
        this.setCenter(loader.load());
    }

    // public void retourHome() throws Exception {
    //     this.appli.afficheFenetreAccueil();
    // }

    // public void afficheFenetreJournalisteSport() throws Exception{
    //     this.appli.afficheFenetreJournalisteSport();
    // }
}
