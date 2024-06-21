package applicationJo.database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import applicationJo.vues.JeuxIUTOlympiques;

public class ControleurConnexion implements EventHandler<ActionEvent> {
    private ConnexionMySQL modele;
    private Parent vue;
    public ControleurConnexion(ConnexionMySQL modele, Parent vue){
        this.modele = modele;
        this.vue = vue;
    }
    @Override
    public void handle(ActionEvent event) {
        // En attente d'avoir une fonction pour récupérer des champs de la page de connexion à la JDBC
        // this.modele.connecter(this.vue.getLogin(), this.vue.getPassword());
    }
}
