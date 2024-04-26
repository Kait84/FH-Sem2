import java.util.Random;

public class PasswordComplexity {

    //enum PasswordComplexity, die alle Values mit jeweiligen Werten enthält
    public enum values {
        PIN( 4, "0"),
        IMPLE( 5, "aA"),
        MEDIUM( 8, "aA0"),
        COMPLEX( 10, "aA0!"),
        SUPER_COMPLEX( 16, "aA0!");

        int length;
        String chars, usableChars;

        private values(int length, String chars) {
            this.length = length;
            this.chars = chars;
            switch(chars){
                case "0":
                    this.usableChars = "0123456789";
                    break;
                case "aA":
                    this.usableChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    break;
                case "aA0":
                    this.usableChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    break;
                case "aA0!":
                    this.usableChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?+-;,.:";
                    break;
            }
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

            for (int i = 0; i < this.length; i++) {
                //append a random char from the usable char String to password
                password.append(this.usableChars.charAt(rndm.nextInt(0, this.usableChars.length())));
            }
            return (password.toString());
        }

    }
}
