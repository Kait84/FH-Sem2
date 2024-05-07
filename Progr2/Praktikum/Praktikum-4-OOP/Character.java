package dungeonchase;

public abstract class Character {
    static String name;
    boolean alive;
    int lastUpdate;

    public Character(String name){
        this.name = name;
        this.alive = true;
        this.lastUpdate = 0;
    }

    //Getter
    public String getName() {
        return this.name;
    }
    public boolean isAlive() {
        return this.alive;
    }
    public int getLastUpdate() {
        return this.lastUpdate;
    }
    public abstract String getImage();
    //Setter
    protected void setAlive(boolean alive){
        this.alive = alive;
    }
    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    //Hilfsmethoden
    public boolean collisionFrom(Character other) {         //WHATTHEFUCK!TODO
        if(this == other){
            return false;
        }else{
            this.alive = false;
            return true;
        }
    }
    public abstract Direction update(Grid grid, int x, int y, Direction playerMovement);


}
