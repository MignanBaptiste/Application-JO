package applicationJo.controleurs;

import applicationJo.vues.FenetreJournalisteSport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ContJournalisteSport implements EventHandler<ActionEvent> {

    private FenetreJournalisteSport fenetreJournalisteSport;

    public ContJournalisteSport(FenetreJournalisteSport fenetreInscription) {
        this.fenetreJournalisteSport = fenetreInscription;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getId().equals("btnHome")) {
            try {
                this.fenetreJournalisteSport.home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("retour")) {
            try {
                this.fenetreJournalisteSport.retour();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnAthletisme")) {
            try {
                this.fenetreJournalisteSport.afficheFenetreJournalisteAth();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnHandball")) {
            try {
                this.fenetreJournalisteSport.afficheFenetreJournalisteSexe();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnNatation")) {
            try {
                this.fenetreJournalisteSport.FenetreJournalisteNatation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnEscrime")) {
            try {
                this.fenetreJournalisteSport.afficheFenetreJournalisteEscrime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnVolleyBall")) {
            try {
                this.fenetreJournalisteSport.afficheFenetreJournalisteSexe();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnGeneral")) {
            try {
                this.fenetreJournalisteSport.afficheFenetreJournalisteClassement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
