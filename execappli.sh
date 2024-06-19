#!/bin/bash
javac --source-path ./src/applicationJo/vues/ -d bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/applicationJo/vues/JeuxIUTOlympiques.java
java -cp bin/:img/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml applicationJo.vues.JeuxIUTOlympiques