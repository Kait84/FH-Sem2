public class Flaechenberechner {
    public static void main(String[] args) {
        //Überprüfen der Komandozeilenargumentenzahl
        double radius, grundseite, hoehe, laenge, breite;
        switch (args.length()) {
            case 1:
                //Ausrechnen, Zurückgeben des Kugelvolumens
                radius = Double.parseDouble(args[0]);
                System.out.println("Kugelvolumen: " + (4 / 3 * Math.PI * radius * radius * radius));
                break;
            case 2:
                grundseite = Double.parseDouble(args[0]);
                hoehe = Double.parseDouble(args[1]);
                System.out.println("Pyramidenvolumen: " + (1/3*grundseite*grundseite*hoehe));
            case 3:
                laenge = Double.parseDouble(args[0]);
                breite = Double.parseDouble(args[1]);
                hoehe = Double.parseDouble(args[2]);
                System.out.println("Quadervolumen: " + (laenge*breite*hoehe));
            default:
                //Ausgabe der erlaubten Argumente
                System.out.println("Verfügbare Berechnungen \n\tKugel: Radius \n\tPyramide: Grundseite Höhe \n\tQuader: Länge Breite Höhe");
                break;
        }
    }
}