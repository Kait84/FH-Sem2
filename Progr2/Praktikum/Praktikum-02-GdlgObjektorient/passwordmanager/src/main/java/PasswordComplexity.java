import java.util.Random;

/**
 * Deklarieren der Passwortarten mit Länge und verwendbarer Zeichen, dessen Getter methoden
 * und der Funktion zum Erstellen eines Passworts
 */
public enum PasswordComplexity {

    PIN(4, "0"),
    SIMPLE(5, "aA"),
    MEDIUM(8, "aA0"),
    COMPLEX(10, "aA0!"),
    SUPER_COMPLEX(16, "aA0!");

    private int length;
    private String chars, usableChars;

    private PasswordComplexity(int length, String chars) {
        StringBuilder charsbuilder = new StringBuilder();

        try {
            this.length = length;
        } catch (IllegalArgumentException IAE) {
            System.err.println("length ist von keinem gültigem Typ");
        }
        try {
            this.chars = chars;
        } catch (IllegalArgumentException IAE) {
            System.err.println("chars ist von keinem gültigem Typ");
        }

        //Erstellen der Benutzbaren Zeichenkette mit den Werten von chars
        for(int i = 0; i<chars.length();i++) {
            switch (chars.indexOf(i)) {
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
        this.usableChars = charsbuilder.toString();
    }

    public int getLength() {
        return length;
    }

    public String getChars() {
        return chars;
    }

    /**
     * Erstellt ein Passwort der Länge length
     * aus allen erlaubten Zeichen des Passworts
     * @return Passwort String
     */
    public String generatePassword() {
        final Random rndm = new Random();
        final StringBuilder password = new StringBuilder();

        //Anhängen eines zufälligen Charachters von den usable chars an das passwort, bis passwordlänge erreicht
        for (int i = 0; i < this.length; i++) {
            password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length() - 1)));
        }
        return (password.toString());
    }
}
