package applicationJo.vues;

import applicationJo.controleurs.ContJournalisteSport;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FenetreJournalisteSport extends BorderPane{

    private JeuxIUTOlympiques appli;

    public FenetreJournalisteSport(JeuxIUTOlympiques appli) throws Exception {
        this.appli = appli;
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../../fxml/FenetreJournalisteSport.fxml")));
        this.setCenter(loader.load());
        Button bHome = (Button) this.lookup("#btnHome");
        bHome.setOnAction(new ContJournalisteSport(this));
        Button bRetour = (Button) this.lookup("#retour");
        bRetour.setOnAction(new ContJournalisteSport(this));
        Button bAthletisme = (Button) this.lookup("#btnAthletisme");
        bAthletisme.setOnAction(new ContJournalisteSport(this));
        Button bHandball = (Button) this.lookup("#btnHandball");
        bHandball.setOnAction(new ContJournalisteSport(this));
        Button bNatation = (Button) this.lookup("#btnNatation");
        bNatation.setOnAction(new ContJournalisteSport(this));
        Button bEscrime = (Button) this.lookup("#btnEscrime");
        bEscrime.setOnAction(new ContJournalisteSport(this));
        Button bVolleyBall = (Button) this.lookup("#btnVolleyBall");
        bVolleyBall.setOnAction(new ContJournalisteSport(this));
        Button bGeneral = (Button) this.lookup("#btnGeneral");
        bGeneral.setOnAction(new ContJournalisteSport(this));
    }

    public void home() throws Exception {
        this.appli.afficheFenetreAccueil();
    }

    public void retour() throws Exception {
        this.appli.afficheFenetreUser();
    }

    public void afficheFenetreJournalisteAth() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }
    
    public void FenetreJournalisteNatation() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }

    public void afficheFenetreJournalisteEscrime() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }

    public void afficheFenetreJournalisteSexe() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }

    public void afficheFenetreJournalisteClassement() throws Exception{
        this.appli.afficheFenetreJournalisteSport();
    }
}
