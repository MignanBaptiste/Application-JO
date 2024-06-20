package applicationJo.controleurs;

import applicationJo.vues.FenetreAccueil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ContAccueil implements EventHandler<ActionEvent> {

    private FenetreAccueil fenetreAccueil;

    public ContAccueil(FenetreAccueil fenetreAccueil) {
        this.fenetreAccueil = fenetreAccueil;
    }

    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getText().equals("Se connecter")) {
            try {
                this.fenetreAccueil.afficheFenetreConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getText().equals("S'inscrire")) {
            try {
                this.fenetreAccueil.afficheFenetreInscription();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnHome")) {
            try {
                this.fenetreAccueil.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
