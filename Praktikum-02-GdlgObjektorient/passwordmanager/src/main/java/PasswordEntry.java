/**
 * Modelliert einen Passwort Eintrag mit Login Name, Website Name, Passwort Complexität, Passwort und dem nächsten Eintrag
 *
 * @author s-lpreit
 */
public class PasswordEntry {

    private final String website;
    private final String loginName;
    private final PasswordComplexity passwordComplexity;
    private String password;
    private PasswordEntry nextEntry;

    //Konstruktoren
    public PasswordEntry(String website, String loginName, PasswordComplexity passwordComplexity) {

        if (website == null) {
            throw new IllegalArgumentException("website darf nicht null sein!");
        } else if (website.strip().isEmpty()) {
            throw new IllegalArgumentException("website darf nicht leer sein!");
        } else {
            this.website = website;
        }

        if (passwordComplexity == null) {
            throw new IllegalArgumentException("website darf nicht null sein!");
        } else {
            this.passwordComplexity = passwordComplexity;
        }

        this.loginName = loginName;
        regeneratePassword();
        this.nextEntry = null;
    }

    public PasswordEntry(String website, PasswordComplexity passwordComplexity) {
        this(website, null, passwordComplexity);
    }

    public PasswordEntry(PasswordEntry other) {
        this.website = other.getWebsite();
        this.loginName = other.getLoginName();
        this.passwordComplexity = other.getPasswordComplexity();
        this.password = other.getPassword();
        this.nextEntry = other.getNextEntry();

        /*this = new PasswordEntry(other.website, other.loginName, other.passwordComplexity);
        this.nextEntry = other.getNextEntry();*/
    }

    //Getter, Setter Methoden
    public String getWebsite() {
        return this.website;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public PasswordComplexity getPasswordComplexity() {
        return this.passwordComplexity;
    }

    public PasswordEntry getNextEntry() {
        return this.nextEntry;
    }

    public void setNextEntry(PasswordEntry nextEntry) {
        this.nextEntry = nextEntry;
    }

    //Hilfsmethoden

    /**
     * generieren eines neuen Passworts mit der passwort complexität des Entrys
     */
    public void regeneratePassword() {
        this.password = passwordComplexity.generatePassword();
    }

    /**
     * Prüft gleichheit des PasswordEntrys mit dem uebergebenen Objekts,
     * liefert true, wenn die website, complexität und login Name übereinstimmen
     *
     * @param other Objekt
     * @return true wenn gleich, sonst false
     */
    @Override
    public boolean equals(Object other) {
        //Vergleich auf Identität, null und Klassengleichheit
        if (this == other) return true;
        else if (other == null || this.getClass() != other.getClass()) return false;

        //wenn other nicht null oder eine ander Klasse hat als this,
        //Impliziter cast von object zu passwordentry, überprüfung der drei Eigenschaften
        PasswordEntry otherEntry = (PasswordEntry) other;
        boolean eqWebsite = (website == otherEntry.getWebsite());
        boolean eqName = (loginName == otherEntry.getLoginName());
        boolean eqPC = (passwordComplexity == otherEntry.getPasswordComplexity());

        return (eqWebsite && eqName && eqPC);
    }

    /**
     * Umwandlung zu String
     * @return - Formattierter String: website L:benutzername P:passwort (passwordComplexity)
     */
    @Override
    public String toString() {
        return String.format("%s L:%s P:%s (%s)", website, loginName, password, passwordComplexity);
    }

}