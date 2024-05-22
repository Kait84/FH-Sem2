/**
 * Modelliert einen Passwort Eintrag mit Login Name, Website Name, Passwort Complexität, Passwort und dem nächsten Eintrag
 * @author s-lpreit
 */
public class PasswordEntry{

    private final String website;
    private final String loginName;
    private final PasswordComplexity passwordComplexity;
    private String password;
    private PasswordEntry nextEntry;

    //Konstruktoren
    public PasswordEntry(String website, String loginName, PasswordComplexity passwordComplexity){
        if(website.equals(null)){
            throw new IllegalArgumentException("website ist null");
        }else if(website.isEmpty()){
            throw new IllegalArgumentException("website ist leer");
        }else{
            this.website = website;
        }

        if(!passwordComplexity.equals(null)){
            this.passwordComplexity = passwordComplexity;
        }else{
            throw new IllegalArgumentException("passwordComplexity ist null");
        }

        this.loginName = loginName;
        this.password = passwordComplexity.generatePassword();
        this.nextEntry = null;
    }

    public PasswordEntry(String website, PasswordComplexity passwordComplexity){
        this(website, null, passwordComplexity);
    }

    public PasswordEntry(PasswordEntry other){
        this.website = other.website;
        this.loginName = other.loginName;
        this.passwordComplexity = other.passwordComplexity;
        this.password = other.password;
        this.nextEntry = other.nextEntry;
    }

    //Getter, Setter Methoden
    public String getWebsite(){
        return this.website;
    }
    public String getLoginName(){
        return this.loginName;
    }
    public String getPassword(){
        return this.password;
    }
    public PasswordComplexity getPasswordComplexity(){
        return this.passwordComplexity;
    }
    public PasswordEntry getNextEntry(){
        return this.nextEntry;
    }
    public void setNextEntry(PasswordEntry nextEntry){

    }

    //Hilfsmethoden

    /**
     * generieren eines neuen Passworts mit der passwort complexität des Entrys
     */
    public void regeneratePassword(){
        this.password = passwordComplexity.generatePassword();
    }

    /**
     * Prüft gleichheit des Objekts mit dem Passwort Entry,
     * liefert true, wenn die website, complexität und login Name übereinstimmen
     * @param other Objekt
     * @return istgleich
     */
    @Override
    public boolean equals(Object other){
        //Vergleich auf Identität, null und KlassengleichheitS
        if(this == other) return true;
        else if(other==null || this.getClass() != other.getClass()) return false;

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
     * @return
     */
    @Override
    public String toString(){
        return String.format("%s. L:%s P:%s (%s)", website, loginName, password, passwordComplexity);
    }

}