package applicationJo.database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import applicationJo.vues.JeuxIUTOlympiques;

public class ControleurConnexion implements EventHandler<ActionEvent> {
    private ConnexionMySQL modele;
    private JeuxIUTOlympiques vue;
    ControleurConnexion(ConnexionMySQL modele, JeuxIUTOlympiques vue){
        this.modele = modele;
        this.vue = vue;
    }
    @Override
    public void handle(ActionEvent event) {
        // En attente d'avoir une fonction pour récupérer des champs de la page de connexion à la JDBC
        // this.modele.connecter(null, null, null, null);
    }
}
