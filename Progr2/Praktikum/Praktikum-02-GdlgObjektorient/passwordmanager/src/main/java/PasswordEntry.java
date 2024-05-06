public class PasswordEntry {

    private final String website, loginName;
    private final PasswordComplexity passwordComplexity;
    private String password;
    private PasswordEntry nextEntry = null;

    //Konstruktoren
    public PasswordEntry(String website, String loginName, PasswordComplexity passwordComplexity){
        if(!website.equals(null) && !website.isEmpty()){
            this.website = website;
        }else{
            throw new IllegalArgumentException("website ist null oder leer");
        }

        this.loginName = loginName;

        if(!passwordComplexit.equals(null)){
            this.passwordComplexity = passwordComplexity;
        }else{
            throw new IllegalArgumentException("passwordComplexity ist null");
        }
    }
    public PasswordEntry(String website, String password, PasswordComplexity passwordComplexity){
        if(!website.equals(null) && !website.isEmpty()){
            this.website = website;
        }else{
            throw new IllegalArgumentException("website ist null oder leer");
        }

        this.password = password;

        if(!passwordComplexit.equals(null)){
            this.passwordComplexity = passwordComplexity;
        }else{
            throw new IllegalArgumentException("passwordComplexity ist null");
        }
    }
    public PasswordEntry(PasswordEntry other){
        //Kopierkonstruktor
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
    public void regeneratePassword(){
        PasswordComplexity pwcp = this.getPasswordComplexity();
        this.password = PasswordComplexity.pwcp.generatePassword();
    }
    public boolean equals(Object other){
        //Zwei PasswordEntry-Instanzen sind gleich
        //wenn die Attribute website, loginName und passwordComplexity gleich sind. Gehen Sie dabei nach
        //dem in der Vorlesung gezeigten „Kochrezept “ vor. Vergessen Sie nicht @Override zu verwen-
        //den und beachten Sie, dass das Argument der Methode equals vom Typ Object und nicht vom
        //Typ PasswordEntry ist
        boolean equals = this.website.equals(other.website) && this.loginName.equals(other.loginName) && this.passwordComplexity.equals(other.passwordComplexity);
        return equals;
    }
    public String toString(){           //????
        return String.toString(this);
    }

}