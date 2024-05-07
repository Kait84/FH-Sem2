import static org.junit.Assert.assertThrows;

public class Bingo {
    static final int[][] BINGO_EXAMPLE = new int[][]{
            {4, 27, 32, 55, 73},
            {15, 25, 41, 58, 75},
            {8, 26, 0, 59, 70},
            {7, 22, 33, 54, 63},
            {13, 17, 43, 48, 67}
    };

    //////RICHTIG
    public static void printBingoCard(int[][] bingoCard) {
        /**
         * @param bingoCard, die dann Auf den Bildschirm geschrieben wird
         */
        System.out.println("B\tI\tN\tG\tO\t");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(bingoCard[i][j] + "\t");
            }
            System.out.printf("\n");
        }
    }

    //////RICHTIG
    public static boolean containsDuplicates(int[][] bingoCard) {
        /**
         * @param bingoCard wird übergeben, und auf Duplikate geprüft.
         * Sind Duplikate vorhanden, wird
         * @return true zurückgegeben, ansonsten false.
         */
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
    public static void checkBingoCard(int[][] bingoCard) {
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
            //check if 1.row contains numbers between 1-15
            if (bingoCard[i][0] < 1 || bingoCard[i][0] > 15) {
                throw new IllegalArgumentException("Die erste Spalte enthaelt Werte kleiner 1 oder Groesser 15!");
            }
            //check if 2.row contains numbers between 16-30
            if (bingoCard[i][1] < 16 || bingoCard[i][1] > 30) {
                throw new IllegalArgumentException("Die zweite Spalte enthaelt Werte kleiner 16 oder Groesser 30!");
            }
            //check if 3.row contains numbers between 31-45
            if (bingoCard[i][2] < 31 || bingoCard[i][2] > 45) {
                throw new IllegalArgumentException("Die dritte Spalte enthaelt Werte kleiner 31 oder Groesser 45!");
            }
            //check if 4.row contains numbers between 46-60
            if (bingoCard[i][3] < 46 || bingoCard[i][3] > 60) {
                throw new IllegalArgumentException("Die vierte Spalte enthaelt Werte kleiner 46 oder Groesser 60!");
            }
            //check if 5.row contains numbers between 61-75
            if (bingoCard[i][4] < 61 || bingoCard[i][4] > 75) {
                throw new IllegalArgumentException("Die fünfte Spalte enthaelt Werte kleiner 61 oder Groesser 75!");
            }
        }

        //check if contains duplicates
        if (containsDuplicates(bingoCard)) {
            throw new IllegalArgumentException("Die Karte enthaelt Duplikate!");
        }
    }


    public static boolean fillBingoCard(int[][] bingoCard, int number) {
        /**
         * @param bingoCard und number, die gestrichen werden soll werden Übergeben.
         *
         * Wenn die Nummer in der Karte vorhanden ist wird
         * @return true zurückgegeben und die Nummer in der richtigen Spalte gestrichen.
         * Ist das nicht der Fall, wird
         * @return false zurückgegeben und nichts an der Karte verändert
         */
        checkBingoCard(bingoCard);

        //check if number meets the criteria, set row the number must be i
        if (number >= 1 && number <= 75) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingoCard[i][j] == number) {
                        bingoCard[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    private static boolean bingo(int[][] bingoCard){
        if(leftDiag(bingoCard) || rightDiag(bingoCard) || row(bingoCard) || column(bingoCard)){
            return true;
        }else{
            return false;
        }

    }

    private static boolean leftDiag(int[][] bingoCard){
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
        for(int i=0, j=4; i<5; i++, j--){
            if(bingoCard[i][j] == 0){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    ////WORKINGONIT
    private static boolean row(int[][] bingoCard){
        boolean foundBingo = false;
        int foundErazed = 0;
        while(!foundBingo) {
            for (int i = 0; i < 5; i++) {
                innerLoop:
                for (int j = 0; j < 5; j++) {
                    if (bingoCard[i][j] == 0) {
                        continue;
                    } else {
                        break innerLoop;
                    }
                }
            }
        }
    }
    private static boolean column(int[][] bingoCard){

    }
     */

}
