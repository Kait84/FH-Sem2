import java.util.Random;

public class PasswordComplexity {

    //Strings aus allen verwendbaren Zeichen
    final String Ziffern = "0123456789";
    final String Kleinbuchst = "abcdefghijklmnopqrstuvwxyz";
    final String Grossbuchst = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String Sonderz = "!?+-;,.:";

    int length;
    String chars, usableChars;
    //enum PasswordComplexity, die alle Values enthält
    enum values {PIN, SIMPLE, MEDIUM, COMPLEX, SUPER_COMPLEX}

    private PIN(){
        int length = 4;
        String chars = "0";
        String usableChars = Ziffern;

        public int getLength() {
            return this.length;
        }
        public String getChars() {
            return this.usableChars;
        }
    }


/*
    public PasswordComplexity(PasswordComplexity values){
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
            default:
                System.out.println("Select a valid value!");
                break;
        }
    }

    public String generatePassword(String chars, int length) {
        final Random rndm = new Random();
        final StringBuilder password = new StringBuilder();

        for (int i = 0; i < this.length; i++) {
            //append a random char from the usable char String to password
            password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length())));
        }
        return (password.toString());
    }


}

 */
