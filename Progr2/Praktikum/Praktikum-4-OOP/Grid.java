package dungeonchase;

public class Grid {

    public static final int GRID_WIDTH = 16;
    public static final int GRID_HEIGHT = 16;

    private Character[][] grid;   // Character

    private int playerX;
    private int playerY;
    private int currentIteration;

    private Player player;        // Player
    //private TreasureChest treasureChest;

    public void updatePlayer(Direction playerMovement) {

        player.update(this, playerX, playerY, playerMovement);

        int zielX = playerX + playerMovement.getDX();
        int zielY = playerY + playerMovement.getDY();

        this.playerX = zielX;
        this.playerY = zielY;
        player.update(this, zielX, zielY, playerMovement);

        /*boolean bewegung = false;
        //nur fortfahren, wenn playerMovement != null
        if (playerMovement.equals(null)) {
            throw new IllegalArgumentException("Player Movement ist darf nicht null sein!");
        }

        //aktualisieren des Spielers
        Direction zielRichtung = player.update(this, playerX, playerY, playerMovement);

        int zielX = playerX + zielRichtung.getDX();
        int zielY = playerY + zielRichtung.getDY();

        //nicht ausführen, wenn:
        //neue Position nicht innerhalb des Spielfelds
        if (zielX > GRID_WIDTH || zielX < 0 || zielY > GRID_HEIGHT || zielY < 0) {
            return;
        }
        //ausführen, wenn:
        //Zielposition leer ist
        if (grid[zielX][zielY].equals(0)) {
            bewegung = true;

        //oder Zielposition nicht leer ist und von Character Instanz belegt wird
        } else {
                if (grid[zielX][zielY] instanceof Character) {
                    bewegung = true;
                }
        }

        if (bewegung) {
            player.update(this, zielX, zielY, Direction.NONE);
        }*/
    }

    /*
    public updateOthers(Direction playerMovement) {
        ++this.currentIteration;
        for (int i = 0; i < grid[].length(); i++) {
            for (int j = 0; j < grid[][].length(); j++) {
                //wenn null, vom helden belegt oder schon verarbeitet, überspringe es
                if () {

                }
                //sont: aktualisieren des characters auf dem Feld:
                else {
                    grid[i][j].setLastUpdate(currentIteration);
                    grid[i][j].super(updatePlayer(this, i, j, Direction.fromD(this.)));
                }
            }
        }
    }*/


// private TreasureChest treasureChest; // ### TreasureChest

    public Grid() {
        currentIteration = 0;
        initGrid();
    }


    @SuppressWarnings("unchecked")
    private void initGrid() {
        // Character
        grid = Helper.fillGrid(
                30  // Anzahl der zu erzeugenden Gegner
                // , () -> new Ogre(Helper.generateName("Ogre"))          // ### Ogre
                // , () -> new Wall()                                     // ### Wall
                // , () -> new BlackKnight(Helper.generateName("Knight")) // ### BlackKnight
                // , () -> new Bomb()                                     // ### Bomb
                // , () -> new Bat(Helper.generateName("Bat"))            // ### Bat
                // , () -> new Blob(Helper.generateName("Blob"), 0.05)    // ### Blob
                // , () -> new Fire(0.1)                                  // ### Fire
        );

        // Player
        playerX = 1;
        playerY = GRID_HEIGHT / 2;
        player = new Player();
        grid[playerX][playerY] = player;


    /* ### TreasureChest 
    treasureChest = new TreasureChest();
    grid[GRID_WIDTH-2][GRID_HEIGHT/2] = treasureChest;
    */

    }

    // Player
    public Player getPlayer() {
        return player;
    }


    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }


  /* ### TrasureChest
  public TreasureChest getTreasureChest(){
    return treasureChest;
  }
  */

    // Character
    public Character get(int x, int y) {
        if (x < 0 || x >= GRID_WIDTH)
            throw new IllegalArgumentException("x outside of range");

        if (y < 0 || y >= GRID_HEIGHT)
            throw new IllegalArgumentException("y outside of range");

        return this.grid[x][y];
    }


}
