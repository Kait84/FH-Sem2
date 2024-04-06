public class Bingo {
    static final int[][] BINGO_EXAMPLE = new int[][]{
            {4, 27, 32, 55, 73},
            {15, 25, 41, 58, 75},
            {8, 26, 0, 59, 70},
            {7, 22, 33, 54, 63},
            {13, 17, 43, 48, 67}
    };

    public static void printBingoCard(int[][] bingoCard){
        System.out.println("\rB\rI\rN\rG\rO");
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(String.valueOf(bingoCard[i][j]) + "\r");
            }
            System.out.println();
        }
    }

    /*
    public containsDuplicates{

    }
     */

    public static void main(String[] args){
        printBingoCard(BINGO_EXAMPLE);
    }

}
