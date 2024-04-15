import java.util.Random;

public class PasswordComplexity {

    //enum PasswordComplexity, die alle Values mit jeweiligen Werten enthält
    public enum values {
        PIN( 4, "0", Ziffern),
        IMPLE( 5, "aA", Kleinbuchst+Grossbuchst),
        MEDIUM( 8, "aA0", Kleinbuchst+Grossbuchst+Ziffern),
        COMPLEX( 10, "aA0!", Kleinbuchst+Grossbuchst+Ziffern+Sonderz),
        SUPER_COMPLEX( 16, "aA!", Kleinbuchst+Grossbuchst+Ziffern+Sonderz);

        //Strings aus allen verwendbaren Zeichen
        final String Ziffern = "0123456789";
        final String Kleinbuchst = "abcdefghijklmnopqrstuvwxyz";
        final String Grossbuchst = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String Sonderz = "!?+-;,.:";

        int length;
        String chars, usableChars;

        private values(int length, String chars, string usableChars) {
            this.length = length;
            this.chars = chars
            this.usableChars = usableChars;
        }

        public int getLength() {
            return this.length;
        }

        public String getChars() {
            return this.chars;
        }

        public String generatePassword() {
            final Random rndm = new Random();
            final StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                //append a random char from the usable char String to password
                password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length())));
            }
            return (password.toString());
        }

    }


    /*
    //Entscheidung was die Passwortlänge und enthaltene Zeichen sind
    switch(values){
        case 0:
            length = 4;
            chars = "0";
            usableChars = this.Ziffern;
            break;
        case 1:
            length = 5;
            chars = "aA";
            usableChars = Kleinbuchst + Grossbuchst;
            break;
        case 2:
            length = 8;
            chars = "aA0";
            usableChars = Ziffern + Kleinbuchst + Grossbuchst;
            break;
        case 3:
            length = 10;
            chars = "aA0!";
            usableChars = Ziffern + Kleinbuchst + Grossbuchst + Sonderz;
            break;
        case 4:
            length = 16;
            chars = "aA0!";
            usableChars = Ziffern + Kleinbuchst + Grossbuchst + Sonderz;
            break;
        default:
            System.out.println("Select a valid value!");
    }*/

}
