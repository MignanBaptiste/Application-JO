package applicationJo.database;

import applicationJo.vues.JeuxIUTOlympiques;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur permettant l'ajout de données à la base de données
 */
public class ControleurAjout implements EventHandler<ActionEvent> {
    /**
     * Le modèle permettant d'ajouter des données à base de données
     */
    private BDAjout modele;
    /**
     * La vue permettant de récupérer les données à ajouter à la base de données
     */
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
