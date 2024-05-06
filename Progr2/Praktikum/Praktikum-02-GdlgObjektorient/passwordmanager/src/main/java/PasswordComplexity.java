import java.util.Random;

public enum PasswordComplexity {
    /**
     * Deklarieren der Passwortarten mit Länge und verwendbarer Zeichen, dessen Getter methoden
     * und der Funktion zum Erstellen eines Passworts
     */

    PIN( 4, "0"),
    SIMPLE( 5, "aA"),
    MEDIUM( 8, "aA0"),
    COMPLEX( 10, "aA0!"),
    SUPER_COMPLEX( 16, "aA0!");

    int length;
    String chars, usableChars;
    StringBuilder charsbuilder = new StringBuilder();

    private PasswordComplexity(int length, String chars) {
        length = length;
        chars = chars;
        for(int i=0; i<chars.length(); i++){
            switch(chars.indexOf(i)){
                case '0':
                    charsbuilder.append("0123456789");
                    break;
                case 'a':
                    charsbuilder.append("abcdefghijklmnopqrstuvwxyz");
                    break;
                case 'A':
                    charsbuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                    break;
                case '!':
                    charsbuilder.append("!?+-;,.:");
                    break;
            }
        }
        usableChars = charsbuilder.toString();
    }

    public int getLength() {
        return length;
    }

    public String getChars() {
        return chars;
    }

    public String generatePassword() {
        /**
         * @return Passwort String
         * Erstellt ein Passwort der Länge length
         * aus allen erlaubten Zeichen des Passworts
         */
        final Random rndm = new Random();
        final StringBuilder password = new StringBuilder();

        for (int i = 0; i < this.length; i++) {
            //append a random char from the usable char String to password
            password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length()-1)));
        }
        return (password.toString());
    }
}
