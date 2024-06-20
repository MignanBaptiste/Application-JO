package applicationJo.controleurs;

import applicationJo.vues.FenetreInscription;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ContInscription implements EventHandler<ActionEvent> {

    private FenetreInscription fenetreInscription;

    public ContInscription(FenetreInscription fenetreInscription) {
        this.fenetreInscription = fenetreInscription;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getText().equals("Retour")) {
            try {
                this.fenetreInscription.retourHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnHome")) {
            try {
                this.fenetreInscription.retourHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (bouton.getId().equals("btnEnregistrer")) {
            try {
                this.fenetreInscription.retourHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
