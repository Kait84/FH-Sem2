public class PasswordStore extends PasswordEntry{
    private int size;
    private PasswordEntry firstEntry;

    ArrayList<PasswordEntry> Store = new ArrayList<String>(size);

    //Konstruktor
    private PasswordEntry(){
        this.size = 0;
        this.firstEntry = null;
    }

    //Getter, Setter methoden
    public int getSize(){

    }
    public PasswordEntry getFirstEntry(){
        return Store[0];
    }
    public void setFirstEntry(PasswordEntry entry){
        this.firstEntry = entry;
    }

    //Hilfsmethoden
    public boolean contains(PasswordEntry entry){       //Workingonit
        for(PasswordEntry pe : Store){
            if(entry ==  pe) return true
            if(entry == null || pe.getClass != entry.getClass()) return false

            PasswordEntry other
        }
    }
    public boolean add(PasswordEntry entry){

    }
    public void printPasswordStore(){

    }
    public void printPasswordStore(String website){

    }
    public PasswordEntry get(int index){

    }
    public void remove(int index){

    }
}
