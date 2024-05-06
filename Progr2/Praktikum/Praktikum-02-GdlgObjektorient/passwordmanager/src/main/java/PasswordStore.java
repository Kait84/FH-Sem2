public class PasswordStore extends PasswordEntry{

    private int size;
    private PasswordEntry firstEntry;

    //Konstruktor
    private PasswordEntry(){
        this.size = 0;
        this.firstEntry = null;
    }

    //Getter, Setter methoden
    public int getSize(){

    }
    public PasswordEntry getFirstEntry(){

    }
    public void setFirstEntry(PasswordEntry entry){
        this.firstEntry = entry;
    }

    //Hilfsmethoden
    public boolean contains(PasswordEntry entry){

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