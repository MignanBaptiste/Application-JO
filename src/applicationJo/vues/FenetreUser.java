package applicationJo.vues;

import applicationJo.controleurs.ContFenetreUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreUser extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreUser(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreUser.fxml")));
        this.setCenter(loader.load());
        Button bHome = (Button) this.lookup("#btnHome");
        bHome.setOnAction(new ContFenetreUser(this));
        Button bRetour = (Button) this.lookup("#retour");
        bRetour.setOnAction(new ContFenetreUser(this));
        Button bJournaliste = (Button) this.lookup("#btnJournaliste");
        bJournaliste.setOnAction(new ContFenetreUser(this));
        Button bAdmin = (Button) this.lookup("#btnAdmin");
        bAdmin.setOnAction(new ContFenetreUser(this));
        Button bOrga = (Button) this.lookup("#btnOrga");
        bOrga.setOnAction(new ContFenetreUser(this));
    }

    public void home() throws Exception {
        this.appli.afficheFenetreAccueil();
    }

    public void retour() throws Exception {
        this.appli.afficheFenetreConnexion();
    }

    public void afficheFenetreJournalisteSport() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }

    public void afficheFenetreAdminConnexion() throws Exception{
        this.appli.afficheFenetreAdminConnexion();
    }

    public void afficheFenetreOrganisateurLancerEprv() throws Exception{
        this.appli.afficheFenetreOrganisateurLancerEprv();
    }

    public JeuxIUTOlympiques getAppli() {
        return this.appli;
    }
}
