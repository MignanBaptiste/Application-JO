package applicationJo.controleurs;

import applicationJo.vues.FenetreConnexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ContConnexion implements EventHandler<ActionEvent> {

    private FenetreConnexion fenetreConnexion;

    public ContConnexion(FenetreConnexion fenetreConnexion) {
        this.fenetreConnexion = fenetreConnexion;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getText().equals("Retour")) {
            try {
                this.fenetreConnexion.retourHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getText().equals("Connexion")) {
            try {
                this.fenetreConnexion.afficheFenetreUser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnHome")) {
            try {
                this.fenetreConnexion.retourHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
