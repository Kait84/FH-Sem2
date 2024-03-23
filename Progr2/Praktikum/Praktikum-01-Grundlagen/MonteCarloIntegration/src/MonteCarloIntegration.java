public class MonteCarloIntegration {
    public static int MAX_ITERATIONS = 100_000;     //Maximale Iterationszahl
    public static double MIN_CHANGE = 10e-5;        //Minimale Annäherungsrate der Kurve


    public static void main(String[] args) {
        //deklaration, initialisieren der benötigten Werte
        int allPoints = 0, pointsUnderCurve = 0, iterations = 1;
        double x, y, approxInt = 1;

        //Ausführschleife des Programms
        while(iterations<MAX_ITERATIONS && Math.abs(approxInt)>MIN_CHANGE){     //läuft solange die maximale Iterationsannzahl erreicht ist und die Annäherung des Integrals größer ist als die minimale Annäherungsrate
            x = Math.random();
            y = Math.random();
            allPoints++;
            if(y<=function(x)){             //Erhöhung der Zahl der Punkte unter der Kurve wenn der y-Wert kleiner gleich dem Funktionswert von x ist
                pointsUnderCurve++;
            }

            approxInt = (pointsUnderCurve/allPoints);     //berechnen der Annäherung des Integrals
            System.out.println("Iteration " + iterations + ": " + approxInt);

            iterations++;                               //Erhöhung der Iterationszahl
        }
    }

    public static double function(double x){
        return x;
    }
}
