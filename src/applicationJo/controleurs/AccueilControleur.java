package applicationJo.controleurs;

import applicationJo.vues.FenetreAccueil;
import applicationJo.vues.JeuxIUTOlympiques;
// import applicationJo.vues.FenetreAccueil;
// import applicationJo.vues.JeuxIUTOlympiques;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AccueilControleur implements EventHandler<ActionEvent> {

    private JeuxIUTOlympiques appli;

    public AccueilControleur(JeuxIUTOlympiques appli) {
        System.out.println("création du controleur");
        this.appli = appli;
        System.out.println("Controleur créé");
    }

    public void handle(ActionEvent event) {
        Button bouton = (Button) event.getTarget();
        if (bouton.getText().equals("Se connecter")) {
            try {
                this.appli.afficheFenetreConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
