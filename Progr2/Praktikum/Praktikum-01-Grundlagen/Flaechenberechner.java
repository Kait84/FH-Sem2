public class Flaechenberechner {
    public static void main(String[] args) {
        
        //Überprüfen der Komandozeilenargumentenzahl
        switch (args.length) {
            case 0:
                System.out.println("Verfügbare Berechnungen \n\tKugel: Radius \n\tPyramide: Grundseite Höhe \n\tQuader: Länge Breite Höhe");
                break;
            case 1:
                //Ausrechnen, Zurückgeben des Kugelvolumens
                try{
                    double radius = Double.parseDouble(args[0]);
                    System.out.printf("Kugelvolumen: %.6f", ((4/3d * Math.PI) * (radius * radius * radius)));
                }catch(Exception nad){
                    System.err.println("Ein angegebenes Argument ist von einem ungültigen Typen");
                }
                break;
            case 2:
                try{
                    double grundseite = Integer.parseInt(args[0]);
                    double hoehe = Double.parseDouble(args[1]);
                    double volumen = grundseite*grundseite*hoehe*(1/3d);
                    System.out.println("Pyramidenvolumen: " + volumen);
                }catch(Exception nad){
                    System.err.println("Ein angegebenes Argument ist von einem ungültigen Typen");
                }
                break;
            case 3:
                try{
                    double laenge = Double.parseDouble(args[0]);
                    double breite = Double.parseDouble(args[1]);
                    double hoehe = Double.parseDouble(args[2]);
                    System.out.println("Quadervolumen: " + (laenge*breite*hoehe));
                }catch(Exception nad){
                    System.err.println("Ein angegebenes Argument ist von einem ungültigen Typen");
                }
                break;
            default:
                //Ausgabe der erlaubten Argumente
                System.out.println("Bitte geben sie Gültige Parameter an! \nVerfügbare Berechnungen \n\tKugel: Radius \n\tPyramide: Grundseite Höhe \n\tQuader: Länge Breite Höhe");
                break;
        }
    }
}