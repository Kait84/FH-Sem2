package dungeonchase;

public abstract class Character{
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
    /**
     * löst Kollisionen auf
     * @param other zieht auf Feld von Character
     * @return true, wenn other auf Feld von Character gesetzt werden darf,
     * sonst false
     */
    public boolean collisionFrom(Character other) {
        this.setAlive(false);
        return true;
    }

    /**
     * aktualisiert den Zustand des Characters, gibt die Richtung, in die sich Character bewegt zurück
     * @param grid auf dem sich Char bewegt
     * @param x - Position von Char
     * @param y - Position von Char
     * @param playerMovement - aktuelle Bewegungsrichtung von Char
     * @return Bewegungsrichtung von Char
     */
    public abstract Direction update(Grid grid, int x, int y, Direction playerMovement);


}
