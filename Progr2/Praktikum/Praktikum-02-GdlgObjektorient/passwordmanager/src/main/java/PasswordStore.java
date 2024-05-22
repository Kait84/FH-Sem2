import java.util.ArrayList;

public class PasswordStore {

    private int size;
    private PasswordEntry firstEntry;

    private ArrayList<PasswordEntry> Store = new ArrayList<PasswordEntry>(size);

    //Konstruktor
    public PasswordStore() {
        this.size = 0;
        this.firstEntry = null;
    }

    //Getter, Setter methoden
    public int getSize() {
        return this.size;
    }

    public PasswordEntry getFirstEntry() {
        return Store.get(0);
    }

    public void setFirstEntry(PasswordEntry entry) {
        Store.add(0, entry);
    }

    //Hilfsmethoden

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!WORKINGONIT
    /**
     * Gibt false zurück, wenn der Parameter null oder nicht gleich einer Instanz der PasswordEntry ist, sonst true
     *
     * @param entry von der Instanz der PasswordEntry
     * @return true, wenn entry gleich einer Instanz von PasswordEntry ist, sonst false
     */
    public boolean contains(PasswordEntry entry) {
        boolean isequal = false;
        try {
            for (PasswordEntry pe : Store) {
                if (pe == entry) {
                    isequal = true;
                    return isequal;
                }
                if (pe.getClass() != entry.getClass()) {
                    continue;
                }

                if (entry.getWebsite() != pe.getWebsite()) {
                    continue;
                }
                if (entry.getLoginName() != entry.getLoginName()) {
                    continue;
                }
                if (entry.getPassword() != entry.getPassword()) {
                    continue;
                }
                if (entry.getPasswordComplexity() != entry.getPasswordComplexity()) {
                    continue;
                }
                isequal = true;
                break;
            }
            return isequal;

        } catch (
                NullPointerException e) {
            throw new IllegalArgumentException("null ist als Parameter nicht erlaubt");
        }
    }

    /**
     * Wenn der Parameter noch nicht in der Liste vorhanden ist, füge ihn am Anfang hinzu inkrementiere die size um 1 und
     * gebe true zurück, sonst false
     *
     * @param entry von der Instanz PasswordEntry
     * @return true, wenn Hinzufügen möglich war, sonst false
     */
    public boolean add(PasswordEntry entry) {
        boolean addingSuccessfull = false;
        //wenn der entry noch nicht in PasswordStore vorhanden, füge ihn am anfang hinzu, return false, sonst true
        try {
            if (!Store.contains(entry) && entry instanceof PasswordEntry) {
                Store.add(0, entry);
                this.size++;
                addingSuccessfull = true;
            }
            return addingSuccessfull;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("null ist als Parameter nicht erlaubt");
        }
    }

    /**
     * Ausgabe aller Enträge
     */
    public void printPasswordStore() {
        int ind = 0;
        for (PasswordEntry pe : Store) {
            System.out.printf("%d. %s \n", ind, pe.toString());
            ind++;
        }
    }

    public void printPasswordStore(String website) {
        try{
            int ind = 0;
            for (PasswordEntry pe : Store) {
                String[] currentline = pe.toString().split(" ");
                if(website.equals(currentline[1])){
                    System.out.printf("%d. %s\n", ind, pe.toString());
                }
            }
        }catch(NullPointerException e){
            throw new IllegalArgumentException("Der uebergebene Parameter darf nicht null sein");
        }
    }

    public PasswordEntry get(int index) {
        if(index < this.size && index >= 0){
            return Store.get(index);
        }else{
            throw new IllegalArgumentException("Der angegebe Index ist ungueltig!");
        }
    }
}
