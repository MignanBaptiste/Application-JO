package applicationJo.database;

import applicationJo.vues.JeuxIUTOlympiques;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurAjout implements EventHandler<ActionEvent> {
    private BDAjout modele;
    private JeuxIUTOlympiques vue;
    public ControleurAjout(BDAjout modele, JeuxIUTOlympiques vue){
        this.modele = modele;
        this.vue = vue;
    }
    @Override
    public void handle(ActionEvent event) {
        // Button bouton = (Button) event.getSource();
        // Faire en sorte d'activer la bonne méthode en fonction du bouton utiliser
    }
}
