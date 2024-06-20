#!/bin/bash
javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/jo/*.java src/jo/sport/*.java src/jo/exception/*.java src/applicationJo/database/ConnexionMySQL.java src/applicationJo/vues/JeuxIUTOlympiques.java src/applicationJo/controleurs/*.java
#javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/applicationJo/vues/JeuxIUTOlympiques.java src/applicationJo/controleurs/AccueilControleur.java src/applicationJo/controleurs/InscriptionControleur.java src/applicationJo/controleurs/ConnexionControleur.java
#java -cp bin/:fxml/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques
java -cp bin/:lib/mariadb-java-client.jar:fxml/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques
