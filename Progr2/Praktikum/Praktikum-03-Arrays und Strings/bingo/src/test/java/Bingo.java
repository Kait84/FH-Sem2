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
    public static void printBingoCard(int[][] bingoCard){
        System.out.println("B\tI\tN\tG\tO\t");
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(bingoCard[i][j] + "\t");
            }
            System.out.printf("\n");
        }
    }

    //////RICHTIG
    public static boolean containsDuplicates(int[][] bingoCard){
        int checkedNumber;
        boolean foundDuplicate = false;

        //iterate over all numbers
        outerloop:
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                checkedNumber = (int)bingoCard[i][j];
                //check if current number equals any other number in the array and skip if the array position compares with itself
                for(int k=0; k<5; k++){
                    for(int l=0; l<5; l++){
                        //skip if the number is compare with itself
                        if((int)i==(int)k && (int)j==(int)l){
                            continue;
                        }
                        //if the numbers are identical and none of the values are zero set foundduplicate to true and break loop
                        if(checkedNumber==bingoCard[k][l] && checkedNumber!=0 && bingoCard[k][l]!=0){
                            foundDuplicate = true;
                            break outerloop;
                        }
                    }
                }
            }
        }
        return foundDuplicate;
    }


    //////WORKINGONIT
    public static void checkBingoCard(int[][] bingoCard){
        //Check if array is null
        if(bingoCard == null){
            throw new IllegalArgumentException("Die Karte ist NULL!");
        }
        //check if a row is null or empty
        for(int i=0; i<5; i++){
            if(bingoCard[i] == null){
                throw new IllegalArgumentException("Eine Zeile ist NULL!");
            }
            if(bingoCard[i][0] == 0){
                throw new IllegalArgumentException("Eine Zeile ist leer!");
            }
        }
        //TOOOOOOODOOOOOOOOOOO: check if array is 2D Square array 5x5
        for(int i=0; i<5; i++){
                if(bingoCard.length != 5 || bingoCard[i].length != 5 ){
                    throw new IllegalArgumentException("Die Arraygröße beträgt nicht 5x5!");
                }
                if(!bingoCard.getClass().isArray()) {
                    throw new IllegalArgumentException("Die Karte ist kein Array!");
                }
                if(bingoCard[0].length < 1 && bingoCard[0].length > 2) {
                    throw new IllegalArgumentException("Das Array ist nicht zweidimensional!");
                }
        }

        /////////////////////Additional/////////////////////
        //check if number in center is zero
        if(bingoCard[2][2] != 0){
            throw new IllegalArgumentException("Der mittlere Eintrag ist nicht gestrichen!");
        }
        //check if 1.row contains numbers between 1-15
        for(int i=0; i<5; i++){
            if(bingoCard[i][0] < 1 || bingoCard[i][0] > 15){
                throw new IllegalArgumentException("Die erste Spalte enthält Werte kleiner 1 oder Größer 15!");
            }
        }
        //check if 2.row contains numbers between 16-30
        for(int i=0; i<5; i++){
            if(bingoCard[i][1] < 16 || bingoCard[i][1] > 30){
                throw new IllegalArgumentException("Die zweite Spalte enthält Werte kleiner 16 oder Größer 30!");
            }
        }
        //check if 3.row contains numbers between 31-45
        for(int i=0; i<5; i++){
            if(bingoCard[i][2] < 31 || bingoCard[i][2] > 45){
                throw new IllegalArgumentException("Die dritte Spalte enthält Werte kleiner 31 oder Größer 45!");
            }
        }
        //check if 4.row contains numbers between 46-60
        for(int i=0; i<5; i++){
            if(bingoCard[i][3] < 46 || bingoCard[i][3] > 60){
                throw new IllegalArgumentException("Die vierte Spalte enthält Werte kleiner 46 oder Größer 60!");
            }
        }
        //check if 5.row contains numbers between 61-75
        for(int i=0; i<5; i++){
            if(bingoCard[i][4] < 61 || bingoCard[i][4] > 75){
                throw new IllegalArgumentException("Die fünfte Spalte enthält Werte kleiner 61 oder Größer 75!");
            }
        }
        //check if contains duplicates
        if(containsDuplicates(bingoCard)){
            throw new IllegalArgumentException("Die Karte enthält Duplikate!");
        }


    }
}
