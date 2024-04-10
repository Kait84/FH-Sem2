import java.util.Scanner;

public class Caesar{

  public final static String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public final static String EXAMPLE_KEY = "HAMNOGPQFEISTLJVWDXKCYZRBU";

  public static String applyCaesar(String text, String key, String clear){
    StringBuilder encryptedString = new StringBuilder(text.length());
    //iterate over the inputed text
    for(int i=0; i<text.length(); i++){
      char c = text.charAt(i);

      //check if the key contains the char at the current index from the inputed text
      if(key.contains(String.valueOf(c))){
        int indexOfString = clear.indexOf(String.valueOf(c));
        encryptedString.append(key.substring(indexOfString, indexOfString+1));  //append the key Character at the index of the Text Character to the encoded String
      }
      //if the key doesnt contain the sign append it to the output text
      else{
        encryptedString.append(String.valueOf(c));
      }
    }
    return encryptedString.toString();
  }


  public static void printStatistics(String text){
    //Relative Häufigkeit: absoluteHäufigkeit/Anzahlallerzeichen
    int stringLength = text.length();
    String completedLetters = new String();
    //create counter Array with numbers of Char occurance at the position in the alphabet and initialize with 0
    int[] numberofoccurance = new int[ABC.length()];
    for(int i=0; i<ABC.length(); i++){
      numberofoccurance[i]=0;
    }

    //iterate over all letters in the text
    for(int i=0; i<stringLength; i++){
      char c = text.charAt(i);
      //check if char at the index has already been counted
      if(completedLetters.contains(String.valueOf(c)) || !(ABC.contains(String.valueOf(c)))){
        continue;
      }
      //if the char at the index has not been counted add it to the list and increase occurance counter
      else{
        completedLetters+=(String.valueOf(c));
        ++numberofoccurance[ABC.indexOf(String.valueOf(c))];
      }
    }

    //Output of the Occurance message
    for(int i=0; i<ABC.length(); i++){
      System.out.println(ABC.substring(i, i+1) +" "+ ((float)numberofoccurance[i]/(float)stringLength) +  " %");
    }

  }

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
