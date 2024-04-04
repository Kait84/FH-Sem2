import java.util.Random;

private class PasswordComplexity {

    //Strings aus allen verwendbaren Zeichen
    final String Ziffern = "0123456789";
    final String Kleinbuchst = "abcdefghijklmnopqrstuvwxyz";
    final String Grossbuchst = this.Kleinbuchst.toUpperCase();
    final String Sonderz = "!?+-;,.:";

    int length;
    String chars;
    String usableChars;

    //enum PasswordComplexity, die alle Values enthält
    enum values {PIN, SIMPLE, MEDIUM, COMPLEX, SUPER_Complex}

    //Entscheidung was die Passwortlänge und enthaltene Zeichen sind
    switch(values){
        case 0:
            this.length = 4;
            this.chars = "0";
            this.usableChars = this.Ziffern;
            break;
        case 1:
            this.length = 5;
            this.chars = "aA";
            this.usableChars = this.Kleinbuchst + this.Grossbuchst;
            break;
        case 2:
            this.length = 8;
            this.chars = "aA0";
            this.usableChars = this.Ziffern + this.Kleinbuchst + this.Grossbuchst;
            break;
        case 3:
            this.length = 10;
            this.chars = "aA0!";
            this.usableChars = this.Ziffern + this.Kleinbuchst + this.Grossbuchst + this.Sonderz;
            break;
        case 4:
            this.length = 16;
            this.chars = "aA0!";
            this.usableChars = this.Ziffern + this.Kleinbuchst + this.Grossbuchst + this.Sonderz;
            break;
    }


    public String generatePassword() {
        final Random rndm = new Random();
        final StringBuilder password = new StringBuilder();

        for (int i = 0; i < this.length; i++) {
            password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length())));
        }
        return (password.toString());
    }

    public static int getLength() {
        return this.length;
    }

    public static String getChars() {
        return this.chars;
    }
}
