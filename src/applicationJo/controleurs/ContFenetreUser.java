package applicationJo.controleurs;

import applicationJo.vues.FenetreUser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ContFenetreUser implements EventHandler<ActionEvent> {

    private FenetreUser fenetreUser;

    public ContFenetreUser(FenetreUser fenetreUser) {
        this.fenetreUser = fenetreUser;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getId().equals("retour")) {
            try {
                this.fenetreUser.retour();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnHome")) {
            try {
                this.fenetreUser.home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnJournaliste")) {
            try {
                this.fenetreUser.afficheFenetreJournalisteSport();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnAdmin")) {
            try {
                this.fenetreUser.afficheFenetreAdminConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnOrga")) {
            try {
                this.fenetreUser.afficheFenetreOrganisateurLancerEprv();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
