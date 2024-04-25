import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     * @author Lukas Preitenwieser
     * @param args
     * Abfrage des kleinen Ein Mal Eins mit Prozentsatz der gelösten aufgaben und einem Motivationsspruch,
     * der abhängig davon ist.
     * Einlesen der Zahl der zu rechnenden Aufgaben und stellen random generierter
     * Mathe Aufgaben aus dem kleinen Ein Mal Eins
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int aufgabenzahl = 0;
        boolean correctinput = false;

        System.out.print("Wieviele Aufgaben wollen sie rechnen\n");
        
        //einlesen der Aufgabenanzahl, überprüfen der korrektheit der Eingabe
        do{
            try{
                aufgabenzahl = scan.nextInt();
                correctinput = true;
            } catch(InputMismatchException IME){
                System.out.println("Bitte geben sie eine positive Ganzzahl ein!");
                scan.nextLine();
            }
        }while(!correctinput);

        //erstellen der Aufgaben
        int geloesteaufgzahl = 0;
        for(int i = 0; i<aufgabenzahl; i++){
            /*Anpassen der Random Funktion zum Ausgeben eines Integers*/
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);

            //Einlesen und überprüfen der Lösung, überprüfen auf Korrektheit der Eingabe
            correctinput = false;
            int erg = 0;
            do{
                try{
                    System.out.println("Was ist " + x + " * " + y + "?");
                    erg = scan.nextInt();
                    correctinput = true;
                }catch(InputMismatchException IME){
                    System.out.println("Bitte geben sie eine positive Ganzzahl ein!");
                    scan.nextLine();
                }
            }while(!correctinput);

            if (erg == x * y) {
                geloesteaufgzahl++;
                System.out.println("Richtig!");
            } else {
                System.out.println("Leider nicht richtig!");
            }
        }

        //Ausgabe der Zahl der Richtig gelösten Aufgaben
        int anteilrichtigerlsg = (int)(((double)geloesteaufgzahl/(double)aufgabenzahl)*100);
        System.out.println("\n"+geloesteaufgzahl + " von " + aufgabenzahl +" Aufgaben sind korrekt (" + anteilrichtigerlsg + "%)");

        //Ausgabe eines vom Prozentsatz abhängigen Motivationsspruchs
        if(anteilrichtigerlsg>99){
            System.out.println("Brilliant gelöst!");
            return;
        }else if(anteilrichtigerlsg>90){
            System.out.println("Sehr gut gemacht!");
            return;
        }else if(anteilrichtigerlsg>75){
            System.out.println("Gut gemacht!");
            return;
        }
        else if(anteilrichtigerlsg>50){
            System.out.println("Versuchs gleich nochmal!");
            return;
        }
        else if(anteilrichtigerlsg>25){
            System.out.println("Dranbleiben!");
            return;
        }
        scan.close();
    }
}