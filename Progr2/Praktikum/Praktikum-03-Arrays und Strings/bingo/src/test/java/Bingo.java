public class Bingo {
    static final int[][] BINGO_EXAMPLE = new int[][]{
            {4, 27, 32, 55, 73},
            {15, 25, 41, 58, 75},
            {8, 26, 0, 59, 70},
            {7, 22, 33, 54, 63},
            {13, 17, 43, 48, 67}
    };

    public static void printBingoCard(int[][] bingoCard){
        System.out.println("B\tI\tN\tG\tO\t");
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(bingoCard[i][j] + "\t");
            }
            System.out.printf("\n");
        }
    }

    public static boolean containsDuplicates(int[][] bingoCard){
        int checkedNumber;
        boolean foundDuplicate = false;

        //iterate over all numbers
        outerloop:
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                checkedNumber = (int)bingoCard[i][j];
                //control if current number equals any other number in the array and skip if the array position checks with itself
                for(int k=0; k<5; k++){
                    for(int l=0; l<5; l++){
                        if(i==k && j==l){   //skip checking if number equals checked number
                            continue;
                        }else if(checkedNumber == (int)bingoCard[j][k]){    //if the value of two numbers are equal the Card contains duplicates. quit looping and return true
                            foundDuplicate = true;
                            break outerloop;
                        }
                    }
                }
            }
        }
        return foundDuplicate;
    }


/*
    public static void main(String[] args){

        System.out.println("The array contains Duplicates: "+ containsDuplicates(BINGO_EXAMPLE));
    }

 */

}
