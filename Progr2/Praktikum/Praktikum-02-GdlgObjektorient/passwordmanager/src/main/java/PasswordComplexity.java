import java.util.Random;

/**
 * Deklarieren der Passwortarten mit Länge und verwendbarer Zeichen, dessen Getter methoden
 * und der Funktion zum Erstellen eines Passworts
 */
public enum PasswordComplexity {

    //Enum-Werte mit zugehöriger length und ziffern der erlaubten Zeichen
    PIN(4, "0"),
    SIMPLE(5, "aA"),
    MEDIUM(8, "aA0"),
    COMPLEX(10, "aA0!"),
    SUPER_COMPLEX(16, "aA0!");

    private int length;
    private String chars, usableChars;

    /**
     *Konstrukter, der die Passwortlänge und usableChars initialisert
     * @param length - Passwortlänge
     * @param chars - beinhaltet Ordinals, die für erlaubte Zeichen stehen, woraus usableChars generiert wird
     */
    private PasswordComplexity(int length, String chars) {
        StringBuilder charsbuilder = new StringBuilder();
        //Überprüfung auf Gültigkeit
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

        //Erstellen der Benutzbaren Zeichenkette abhängig von den Werten des chars Strings
        for(char c : chars.toCharArray()) {
            switch (c) {
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

        //Anhängen eines zufälligen Charachters von den usable chars an das passwort, bis Passwortlänge erreicht ist
        for (int i = 0; i < this.length; i++) {
            int randomInt = rndm.nextInt(0, this.usableChars.length()-1);
            char randomChar = this.usableChars.charAt(randomInt);
            password.append(randomChar);
        }
        return (password.toString());
    }
}
