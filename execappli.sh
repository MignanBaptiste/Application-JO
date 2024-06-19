#!/bin/bash
javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/applicationJo/vues/JeuxIUTOlympiques.java
java -cp bin/:img/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques

javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/applicationJo/vues/*.java
java -cp bin/:fxml/:img/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques

javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/applicationJo/controleurs/AccueilControleur.java src/applicationJo/vues/JeuxIUTOlympiques.java src/applicationJo/vues/FenetreAccueil.java src/applicationJo/vues/FenetreConnexion.java
java -cp bin/:fxml/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques