import java.util.Random;

public class PasswordComplexity {

    //enum PasswordComplexity, die alle Values mit jeweiligen Werten enthält
    public enum values {
        PIN("0"), SIMPLE("aA"), MEDIUM("aA0"), COMPLEX("aA0!"), SUPER_COMPLEX("aA!");

        //Strings aus allen verwendbaren Zeichen
        final String Ziffern = "0123456789";
        final String Kleinbuchst = "abcdefghijklmnopqrstuvwxyz";
        final String Grossbuchst = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String Sonderz = "!?+-;,.:";

        int length;
        String chars, usableChars;

        PIN() {
            this.length = 4;
            this.usableChars = Ziffern;
        }

        SIMPLE() {
            this.length = 5;
            this.usableChars = Kleinbuchst + Grossbuchst;
        }

        MEDIUM {
            this.length = 8;
            this.usableChars = Ziffern + Kleinbuchst + Grossbuchst;
        }

        COMPLEX {
            this.length = 10;
            this.usableChars = Ziffern + Kleinbuchst + Grossbuchst + Sonderz;
        }

        SUPER_COMPLEX {
            this.length = 16;
            this.usableChars = Ziffern + Kleinbuchst + Grossbuchst + Sonderz;
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
            if (chars.equals("0")) {
                usableChars = Ziffern;
            } else if (chars.equals("aA")) {
                usableChars = Kleinbuchst + Grossbuchst;
            } else if (chars.equals("aA0")) {
                usableChars = Kleinbuchst + Grossbuchst + Ziffern;
            } else if (chars.equals("aA0!")) {
                usableChars = Kleinbuchst + Grossbuchst + Ziffern;
            }

            for (int i = 0; i < length; i++) {
                //append a random char from the usable char String to password
                password.append(chars.charAt(rndm.nextInt(0, chars.length())));
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
