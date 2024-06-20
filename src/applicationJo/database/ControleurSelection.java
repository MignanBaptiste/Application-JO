package applicationJo.database;

import applicationJo.vues.JeuxIUTOlympiques;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Le contrôleur permettant de récupérer des donénes
 */
public class ControleurSelection implements EventHandler<ActionEvent>{
    /**
     * le modèle permettant de récupérer des données pour l'affichage
     */
    private BDSelection modele;
    /**
     * la vue permettant l'affichage
     */
    private JeuxIUTOlympiques vue;
    /**
     * Constructeur du contrôleur
     * @param modele
     * @param vue
     */
    public ControleurSelection(BDSelection modele, JeuxIUTOlympiques vue){
        this.modele = modele;
        this.vue = vue;
    }
    
    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }
}
