//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wieviele Aufgaben wollen sie rechnen");
        
        //einlesen der Aufgabenanzahl, überprüfen der korrektheit der Eingabe
        int aufgabenzahl = scan.nextInt();
        if(aufgabenzahl!=(int)aufgabenzahl || aufgabenzahl>20){
            System.out.println("Bitte geben sie eine positive Ganzzahl kleiner 20 ein!");
            return;
        }

        //erstellen der Aufgaben
        int geloesteaufgzahl = 0;
        for(int i = 0; i<aufgabenzahl; i++){
            int x = (int)(Math.random()*10);                /*Anpassen der Random Funktion*/
            int y = (int)(Math.random()*10);                   /*zum Ausgaben eines Int */
            System.out.println("Was ist " + x + " * " + y + "?");
            //Einlesen und überprüfen der Lösung
            int erg = scan.nextInt();
            if (erg == x * y) {
                geloesteaufgzahl++;
                System.out.println("Richtig!");
            } else {
                System.out.println("Leider nicht richtig!");
            }
        }

        //Ausgabe der Zahl der Richtig gelösten Aufgaben
        int anteilrichtigerlsg = (int)(((double)geloesteaufgzahl/(double)aufgabenzahl)*100);
        System.out.println(geloesteaufgzahl + " von " + aufgabenzahl +" Aufgaben sind korrekt (" + anteilrichtigerlsg + "%)");

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
    }
}