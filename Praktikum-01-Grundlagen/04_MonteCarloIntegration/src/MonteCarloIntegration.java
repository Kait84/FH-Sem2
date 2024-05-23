/**
 * @author Lukas Preitenwieser
 */
public class  MonteCarloIntegration {
    public static int MAX_ITERATIONS = 100_000;     //Maximale Iterationszahl
    public static double MIN_CHANGE = 10e-5;        //Minimale Annäherungsrate der Kurve


    /**
     * Berechnung der Integrals der angegebenen Funktion in der Klasse function() durch Annäherung
     * @param args - nicht benötigt
     */
    public static void main(String[] args) {

        //deklaration, initialisieren der benötigten Werte
        int allPoints = 0, pointsUnderCurve = 0, iterations = 1;
        double x, y, changeRationBefore, approxInt = 1;

        //Ausführschleife des Programms: läuft solange die maximale Iterationsannzahl nicht erreicht ist und
        // die Annäherung des Integrals größer ist als die minimale Annäherungsrate
        do{
            //Erhöhung der Iterationszahl, und der allgemeinen Punktzahl, Zwischenspeichern der letzten Änderungsrate und
            // Erstellen zweier Punke x,y zwischen [0,1]
            ++iterations;
            x = Math.random();
            y = Math.random();
            ++allPoints;
            changeRationBefore = approxInt;

            //Erhöhung der Zahl der Punkte unter der Kurve wenn der y-Wert kleiner gleich dem Funktionswert von x ist und Ausgabe der Werte
            if(y<=function(x)){
                pointsUnderCurve++;
                //berechnen der Annäherung des Integrals
                approxInt = ((double)pointsUnderCurve/(double)allPoints);
                //Ausgabe der Iterationzahl, Änderungsrate und der Veränderung dieser zu der vorhereigen
                System.out.printf("Iteration %d: %.5f (%f) %n", iterations, approxInt, Math.abs(changeRationBefore - approxInt));
            }

        }while(iterations<MAX_ITERATIONS && Math.abs(approxInt)>=MIN_CHANGE);
    }

    /**
     * Funktionsberechnung anhand der Funktionsgleichung
     * @param x - X-Wert der Funktion
     * @return Y- Korrdinate der Funktion
     */
    public static double function(double x){
        return Math.sin((Math.PI)*x);
    }
}
