package jo;

import java.util.Map.Entry;
import java.util.Scanner;

import jo.exception.InvalidTypeException;

public class Executable {
    public static void main(String[] args) {
        JeuxOlympiques jo = new JeuxOlympiques(2021);
        try {
            jo.load_csv("./donnees.csv");
        } catch (InvalidTypeException e) {
            System.out.println("Problème de chargement des données");
        }
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter){

            // Menu
            System.out.println("┌─────────────────────────────────────────────────────────────────┐");
            System.out.println("| Que voulez-vous faire ? (écrivez simplement la première lettre) |");
            System.out.println("| V - Voir les données                                            |");
            System.out.println("| S - Simulation des épreuves                                     |");
            System.out.println("| M - Modifier les données (TO DO)                                |");
            System.out.println("| A - Afficher les médailles des pays                             |");
            System.out.println("| C - Consultation statistiques des résultats (TO DO)             |");
            System.out.println("| Q - Quitter                                                     |");
            System.out.println("└─────────────────────────────────────────────────────────────────┘");

            String entrer = scanner.next();
            entrer = entrer.toUpperCase();
            // récupération, saisie et modification des données
            if (entrer.equals("V")){
                System.out.println("Il y a " + jo.getNbEpreuves() + " épreuves aux " + jo);
                System.out.println("Il y a " + jo.getNbAthletes() + " athlètes qui participent aux " + jo);
                System.out.println("Il y a " + jo.getNbEquipes() + " équipes qui participent aux " + jo);
                System.out.println("Il y a " + jo.getNbPays() + " pays qui participent aux " + jo);
                System.out.println("Voulez-vous plus d'informations ? Y/N");
                entrer = scanner.next();
                entrer = entrer.toUpperCase();
                if (entrer.equals("Y")){
                    while (!quitter){
                        System.out.println("┌──────────────────────────────────────────────────────────────────┐");
                        System.out.println("| Que voulez-vous savoir ? (écrivez simplement la première lettre) |");
                        System.out.println("| E - les Epreuves                                                 |");
                        System.out.println("| A - les Athlètes                                                 |");
                        System.out.println("| U - les Equipes                                                  |");
                        System.out.println("| P - les Pays                                                     |");
                        System.out.println("| Q - Quitter                                                      |");
                        System.out.println("└──────────────────────────────────────────────────────────────────┘");
                        entrer = scanner.next();
                        entrer = entrer.toUpperCase();
                        if (entrer.equals("E")){
                            System.out.println("Les épreuves aux " + jo + " sont : ");
                            for (@SuppressWarnings("rawtypes") Epreuve epv: jo.getEpreuves()){
                                System.out.println(epv);
                            }
                        }
                        else if (entrer.equals("A")){
                            System.out.println("Les athlètes participant aux " + jo + " sont : ");
                            for (Athlete ath : jo.getAthletes()){
                                System.out.println(ath);
                            }
                        }
                        else if (entrer.equals("U")){
                            System.out.println("Les équipes participant aux " + jo + " sont : ");
                            for (Equipe eqp : jo.getEquipes()){
                                System.out.println(eqp);
                            }
                        }
                        else if (entrer.equals("P")){
                            System.out.print("Les pays participant aux " + jo + " sont : ");
                            for (Pays pays : jo.getPays()){
                                System.out.print(pays + " ");
                            }
                            System.out.println("");
                        }
                        else{quitter = true;}
                    }
                    quitter = false;
                }
            }
            else if (entrer.equals("M")){ // Potentielement à retirer au vue de la complexité.
                System.out.println("NE MARCHE PAS POUR LE MOMENT");
            }

            // Simulation des épreuves.
            else if (entrer.equals("S")){
                jo.simulation();
                System.out.println("Les épreuves se sont bien déroulées.");
            }

            // Consultation statistiques des résultats selon divers critères.
            else if (entrer.equals("C")){
                System.out.println("NE MARCHE PAS POUR LE MOMENT");
            }

            // Récupérer les médailles pour les pays.
            else if (entrer.equals("A")){
                System.out.println("Pays               Or         Argent       Bronze");
                for (Entry<Pays, Classement> paysClassement : jo.medaillesParPays().entrySet()){
                    Pays pays = paysClassement.getKey();
                    String paysChaine = pays.toString();
                    for (int i = 0; i < 20 - pays.toString().length(); ++i){
                        paysChaine += " ";
                    }
                    Classement classement = paysClassement.getValue();
                    System.out.println(paysChaine + classement.getOr() + "           " + classement.getArgent() + "            " + classement.getBronze());
                }
            }

            else if (entrer.equals("Q")){
                quitter = true;
            }

            else{
                System.out.println(entrer + " n'est pas une option");
            }

        }
        scanner.close();
    }
}
