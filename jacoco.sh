#!/bin/bash
javac -d out $(find src -name "*.java" ! -name "Executable.java" ! -name "ConnexionMySQL.java")
find tests -name "*.java" -exec javac -cp out:lib/junit-platform-console-standalone-1.3.2.jar -d out {} +
java -javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp out:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --class-path out --scan-class-path
java -jar lib/jacococli.jar report jacoco.exec --classfiles out --sourcefiles src/main/java --html report