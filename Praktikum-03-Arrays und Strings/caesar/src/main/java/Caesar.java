import java.util.Scanner;

/**
 * @author Lukas Preitenwieser
 * applyCeasar() Codiert und Decodiert Einen übergebenen String mithilfe des Übergebenen Keys
 *    anhand der Ceasar Chiffre und gibt den veränderten String zurück
 * printStatistics() analysiert die Häufigkeit jedes vorkommenden Buchstaben in dem Übergebenen String und gibt diese aus
 */
public class Caesar{

  public final static String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public final static String EXAMPLE_KEY = "HAMNOGPQFEISTLJVWDXKCYZRBU";


  /**
   * Anwendung der Ceasar Chiffre zum Codieren des Textes mit dem Schlüssel über den angegeben Ziffern in clear
   * @param text - Der zu ver- oder entschlüsselnde Text
   * @param key - Schlüssel, mit dem verschlüsselt werden soll
   * @param clear - alle Ziffern die im Zeichensatz enthalten sein sollen
   * @return Ceasar-codierten String
   */
  public static String applyCaesar(String text, String key, String clear){
    StringBuilder encryptedString = new StringBuilder(text.length());
    //iterate over the inputed text
    for(int i=0; i<text.length(); i++){
      char c = text.charAt(i);

      //if the key contains the char at the current index from the inputed text,
      //append the char at the index of the Textchar to the encoded String
      if(key.contains(String.valueOf(c))){
        int indexOfString = clear.indexOf(String.valueOf(c));
        encryptedString.append(key.substring(indexOfString, indexOfString+1));
      }
      //if the key doesnt contain the sign, append it to the output text
      else{
        encryptedString.append(String.valueOf(c));
      }
    }
    return encryptedString.toString();
  }


  /**
   * Ausgabe der Häufigkeit der Vorkommen der Buchstaben im übergebenen Text in Prozent
   * @param text - Text auf dem die Häufigkeitsanalyse ausgeführt werden soll
   */
  private static void printStatistics(String text){
    int stringLength = text.length();
    //create counter Array with numbers of Char occurance at the position in the alphabet and initialize with 0
    int[] numberofoccurance = new int[stringLength];
    StringBuilder completedLetters = new StringBuilder();
    int countedLetters = 0;
    //initialize all values with zero
    for(int i=0; i<ABC.length(); i++){
      numberofoccurance[i]=0;
    }

    //iterate over all letters in the text
    for(int i=0; i<stringLength; i++) {
      char c = text.charAt(i);

      //if the letter is a whitespace sign skip it
      if(c == ' ' || c=='\n' || c=='\t'){
        continue;
      }
      //if the letter at the index has not been added to the list add it and increase its occurance counter
      if (completedLetters.indexOf(String.valueOf(c)) == -1 ) {
        completedLetters.append(String.valueOf(c));
        ++numberofoccurance[countedLetters];
        ++countedLetters;
      }
      //if the char at the index has been counted increase the numberofoccurance
      else{
        ++numberofoccurance[completedLetters.indexOf(String.valueOf(c))];
      }
    }

    //Output of the Occurance message and convert StringBuilder to String
    String occuredLetters = completedLetters.toString();
    for(int i=0; i<countedLetters; i++){
      System.out.printf("%s:\t%.2f %%\n", occuredLetters.substring(i, i+1), (((double)numberofoccurance[i]/(double)stringLength)*100));

    }
  }

  /**
   * Mainfunktion, in der alle Funktionen aufgerufen werden und die Nachricht Cheasar-Kodiert und dekodiert ausgegeben wird
   * @param args - nicht genutzt
   */
  public static void main(String[] args){
    String message = "PROGRAMMIEREN IN JAVA MACHT NOCH MEHR SPASS ALS IN PYTHON ODER C";

    String encrypted = applyCaesar(message, EXAMPLE_KEY, ABC);
    String decrypted = applyCaesar(encrypted, ABC, EXAMPLE_KEY);

    System.out.printf("Message: %s%n%n", message);
    System.out.printf("Encrypted: %s%n%n", encrypted);
    System.out.printf("Decrypted: %s%n%n", decrypted);

    printStatistics(encrypted);
  }

  public final static String EXAM_HINTS_ENCRYPTED = "WJ EG ULT SPDWFWT RW VLFKLNLG JÜFFLG FEL GWT HAPBLGUL NEGZLEFL VLDQNKLG:\r\n"+
" - UEL SPDWFWT ATELGKELTK FEQN DG ULG CTDSKESD!\r\n"+
" - VLDTVLEKLG FEL DPPL CTDSKESWJFDWHBDVLG FLPVFKFKÄGUEB. GWT FA OLTFKLNLG FEL UEL PÖFWGBLG WGU SÖGGLG DWQN EG ULT SPDWFWT FLPVFKFKÄGUEB DWH UEL PÖFWGB SAJJLG.\r\n"+
" - FLNLG FEL ULG PLEFKWGBFGDQNZLEF DPF LEGL BLPLBLGNLEK LEGL TÜQSJLPUWGB RW ENTLJ ZEFFLGFFKDGU RW VLSA JJLG. ZLGG FEL LEGJDP LEG CTDSKESWJ GEQNK VLFKLNLG, UDGG GWKRLG FEL UEL BLPLBLGNLEK WJ FEQN KELHLT EGUEL JDKLTEL LEGRWDTVLEKLG.\r\n"+
" - FLNLG FEL FEQN DPKL SPDWFWTLG DG WGU TLQNGLG FEL UELFL UWTQN. UEL SPDWFWTLG EG CTABTDJJELTLG 2 FEGU EJJLT ÄNGPEQN DWHBLVDWK. FEL UÜTHLG FEQN FABDT UEL DPKLG SPDWFWTLG JEK ENTLG PÖFWGBLG JEK EG UEL CTÜH WGB GLNJLG.\r\n"+
" - CTAVELTLG FEL UEL VLEFCELPL DWF ULT OATPLFWGB FLPVLT DWF, OLTÄGULTG FEL FEL, JDQNLG FEL FEL SDCWKK WGU TLCDTELTLG FEL FEL. FA VLSAJJLG FEL LEG BLHÜNP HÜT UEL CTABTDJJELTFCTDQNL.\r\n"+
"- ZLGG UDF DPPLF GEQNKF NEPHK, UDGG HEGULG FEL NELT UEL DWHBDVLG ULT GÄQNFKLG CTABTDJJJELTLG 2 SPDWFWT FDJK PÖFWGBLG: NKKCF://VEK.PY/CTAB2-SPDWFWT-FAFL24";

}
