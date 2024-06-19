package applicationJo.database;

import applicationJo.vues.JeuxIUTOlympiques;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSelection implements EventHandler<ActionEvent>{
    private BDSelection modele;
    private JeuxIUTOlympiques vue;
    public ControleurSelection(BDSelection modele, JeuxIUTOlympiques vue){
        this.modele = modele;
        this.vue = vue;
    }
    
    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }
}
