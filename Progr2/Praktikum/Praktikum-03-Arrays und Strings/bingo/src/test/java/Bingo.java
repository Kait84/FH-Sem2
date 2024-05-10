import static org.junit.Assert.assertThrows;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bingo {
    static final int[][] BINGO_EXAMPLE = new int[][]{
            {4, 27, 32, 55, 73},
            {15, 25, 41, 58, 75},
            {8, 26, 0, 59, 70},
            {7, 22, 33, 54, 63},
            {13, 17, 43, 48, 67}
    };

    //////RICHTIG
    /**
     * @param bingoCard, die dann Auf den Bildschirm geschrieben wird
     */
    public static void printBingoCard(int[][] bingoCard) {
        System.out.println("B\tI\tN\tG\tO\t");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(bingoCard[i][j] + "\t");
            }
            System.out.printf("\n");
        }
    }

    //////RICHTIG
    /**
     * @param bingoCard wird übergeben, und auf Duplikate geprüft.
     * Sind Duplikate vorhanden, wird
     * @return true zurückgegeben, ansonsten false.
     */
    public static boolean containsDuplicates(int[][] bingoCard) {
        int checkedNumber;
        boolean foundDuplicate = false;

        //iterate over all numbers
        outerloop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                checkedNumber = (int) bingoCard[i][j];
                //check if current number equals any other number in the array and skip if the array position compares with itself
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        //skip if the number is compare with itself
                        if ((int) i == (int) k && (int) j == (int) l) {
                            continue;
                        }
                        //if the numbers are identical and none of the values are zero set foundduplicate to true and break loop
                        if (checkedNumber == bingoCard[k][l] && checkedNumber != 0 && bingoCard[k][l] != 0) {
                            foundDuplicate = true;
                            break outerloop;
                        }
                    }
                }
            }
        }
        return foundDuplicate;
    }

    //////RICHTIG
    /**
     * @param BingoCard wird übergeben, und auf Korrektheit geprüft.
     * Bei nicht Erfüllung wird eine
     * @trows IllegalArgumentException mit Fehlermeldung geworfen
     *
     * Kriterien auf die die Karte geprüft wird, sind:
     *                  Die Karte oder eine Zeile ist null
     *                  Die Karte ist zweidimensional von der Dimension 5x5
     *                  Der Eintrag in der Mitte ist gestrichen
     *                  Alle Spalten enthalten valide Nummern
     *                  Die Karte enthält keine Duplikate
     *
     */
    public static void checkBingoCard(int[][] bingoCard) {
        //Check if array is null
        if (bingoCard == null) {
            throw new IllegalArgumentException("Die Karte ist NULL!");
        }

        //check if array is 2D Square array 5x5
        if (!bingoCard.getClass().isArray()) {
            throw new IllegalArgumentException("Die Karte ist kein Array!");
        }
        //check if a row is null
        if (bingoCard.length == 0) {
            throw new IllegalArgumentException("Eine Zeile ist NULL!");
        }
        //check if there are 5 rows
        if (bingoCard.length < 5 || bingoCard.length > 5) {
            String message = "Dass Array hat " + (bingoCard.length) + " Zeilen, statt den erlaubten 5!";
            throw new IllegalArgumentException(message);
        }
        for (int i = 0; i < 5; i++) {
            //check if a column is null
            if (bingoCard[i].equals(null)) {
                throw new IllegalArgumentException("Eine Spalte ist Null!");
            }
            //check if each column contains 5 elements
            if (bingoCard[i].length != 5) {
                throw new IllegalArgumentException("Die Spalten müssen 5 Elemente besizten");
            }
        }

        /////////////////////Additional/////////////////////
        //check if number in center is zero
        if (bingoCard[2][2] != 0) {
            throw new IllegalArgumentException("Der mittlere Eintrag ist nicht gestrichen!");
        }

        //check row values
        for (int i = 0; i < 5; i++) {
            //check if 1.column contains numbers between 1-15
            if (bingoCard[i][0] != 0 && (bingoCard[i][0] < 1 || bingoCard[i][0] > 15)) {
                throw new IllegalArgumentException("Die erste Spalte enthaelt Werte kleiner 1 oder Groesser 15!");
            }
            //check if 2.column contains numbers between 16-30
            if (bingoCard[i][1] != 0 && (bingoCard[i][1] < 16 || bingoCard[i][1] > 30)) {
                throw new IllegalArgumentException("Die zweite Spalte enthaelt Werte kleiner 16 oder Groesser 30!");
            }
            //check if 3.column contains numbers between 31-45
            if (bingoCard[i][2] != 0 && (bingoCard[i][2] < 31 || bingoCard[i][2] > 45)){
                throw new IllegalArgumentException("Die dritte Spalte enthaelt Werte kleiner 31 oder Groesser 45!");
            }
            //check if 4.column contains numbers between 46-60
            if (bingoCard[i][3] != 0 && (bingoCard[i][3] < 46 || bingoCard[i][3] > 60)) {
                throw new IllegalArgumentException("Die vierte Spalte enthaelt Werte kleiner 46 oder Groesser 60!");
            }
            //check if 5.column contains numbers between 61-75
            if (bingoCard[i][4] != 0 && (bingoCard[i][4] < 61 || bingoCard[i][4] > 75)) {
                throw new IllegalArgumentException("Die fünfte Spalte enthaelt Werte kleiner 61 oder Groesser 75!");
            }
        }

        //check if contains duplicates
        if (containsDuplicates(bingoCard)) {
            throw new IllegalArgumentException("Die Karte enthaelt Duplikate!");
        }
    }


    //////RICHTIG
    /**
     * @param bingoCard und Nummer, die gestrichen werden soll werden Übergeben.
     *
     * Wenn die Nummer in der Karte vorhanden ist wird
     * @return true zurückgegeben und die Nummer in der richtigen Spalte gestrichen.
     * Ist das nicht der Fall, wird
     * @return false zurückgegeben und nichts an der Karte verändert
     */
    public static boolean fillBingoCard(int[][] bingoCard, int number) {
        boolean foundNumber = false;

        checkBingoCard(bingoCard);

        //check if number meets the criteria, set row the number must be i
        if (number >= 1 && number <= 75) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingoCard[i][j] == number) {
                        bingoCard[i][j] = 0;
                        foundNumber = true;
                    }
                }
            }
        }else if(number == 0){
            foundNumber = false;
            throw new IllegalArgumentException("Die Nummer darf nicht Null sein!");
        }
        else if(number < 0){
            foundNumber = false;
            throw new IllegalArgumentException("Die Nummer muss positiv sein!");
        }else if(number > 75){
            foundNumber = false;
            throw new IllegalArgumentException("Die Nummer muss kleiner 75 sein!");
        }
        return foundNumber;
    }


    //////RICHTIG
    /**
     * @param bingoCard wird auf diagonales, vertikales und horizontales Bingo geprüft
     */
    public static boolean bingo(int[][] bingoCard){
        if(leftDiag(bingoCard) || rightDiag(bingoCard) || row(bingoCard) || column(bingoCard)){
            return true;
        }else{
            return false;
        }

    }

    private static boolean leftDiag(int[][] bingoCard){
        /**
         * Hilfsmethode von bingo
         * @param bingoCard wird auf Diagonales Bingo von links oben nach rechts unten geprüft
         */
        for(int i=0; i<5; i++){
            if(bingoCard[i][i] == 0){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    private static boolean rightDiag(int[][] bingoCard){
        /**
         * Hilfsmethode von bingo
         * @param bingoCard wird auf Diagonales Bingo von rechts oben nach links unten geprüft
         */
        for(int i=0, j=4; i<5; i++, j--){
            if(bingoCard[i][j] == 0){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    private static boolean row(int[][] bingoCard) {
        /**
         * Hilfsmethode von bingo
         * @param bingoCard wird auf Waagrachtes Bingo geprüft
         */
        int foundErased=0;
        for (int i = 0; i < 5; i++) {
            innerLoop:
            for (int j = 0; j < 5 || foundErased<5; j++){
                if (bingoCard[i][j] == 0) {
                    foundErased++;
                } else {
                    break innerLoop;
                }
            }
            if(foundErased==5){
                return true;
            }
        }
        return false;
    }

    private static boolean column(int[][] bingoCard) {
        /**
         * Hilfsmethode von bingo
         * @param bingoCard wird auf Senkrechtes Bingo geprüft
         */
        int foundErased = 0;
        for (int i = 0; i < 5; i++) {
            innerLoop:
            for (int j = 0; j < 5 || foundErased < 5; j++){
                if (bingoCard[j][i] == 0) {
                    foundErased++;
                } else {
                    break innerLoop;
                }
            }
            if (foundErased == 5) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[][] bingoCard = BINGO_EXAMPLE;
        int inputNumber;

        //Programmloop bis Bingo erreicht wurde
        do{
            //anzeigen der Karte und Benutzer nach Zahl zum streichen fragen
            printBingoCard(bingoCard);
            inputNumber = 0;
            do{
                try{
                    System.out.println("Bitte geben Sie eine positive Ganzzahl zwischen 1 und 75 (inklusive) ein...");
                    inputNumber = scan.nextInt();
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Sie haben eine falsche Zahl eingegeben!\nVersuchen Sie es erneut: \n");
                }
            }while(inputNumber<1 || inputNumber>75);

            //Eintrag der eingegebenen Nummer streichen wenn enthalten, informieren ob sie enthalten war
            if(fillBingoCard(bingoCard, inputNumber)){
                System.out.println("\nDie angegeben Nummer war in der Bingokarte enthalten und wurde jetzt gestrichen.");
            }else{
                System.out.println("\nDie angegeben Nummer war nicht in der Bingokarte enthalten.");
            }
        }while(!bingo(bingoCard));

        scan.close();
        //Ausgabe eines Spruchs und der Karte, wenn ein Bingo erreicht wurde
        System.out.println("\n\nGLÜCKWUNSCH \nEin Bingo wurde erreicht!!\n\n-BINGO--BINGO--BINGO--BINGO--BINGO-\n-BINGO--BINGO--BINGO--BINGO--BINGO-");
        printBingoCard(bingoCard);
        System.out.println("-BINGO--BINGO--BINGO--BINGO--BINGO-\n-BINGO--BINGO--BINGO--BINGO--BINGO-");

    }
}
