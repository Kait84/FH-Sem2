package dungeonchase;

public class Grid {

  public static final int GRID_WIDTH = 16;
  public static final int GRID_HEIGHT = 16;

  private Character[][] grid;   // Character

  private int playerX;

  private int playerY;

  private Player player;        // Player

  private int currentIteration;

  public void updatePlayer(Direction playerMovement){
    boolean bewegung = false;
    //nur fortfahren, wenn playerMovement != null
    if(playerMovement.equals(null)){
      throw new IllegalArgumentException("Player Movement ist NULL!");
    }

    //aktualisieren des Spielers
    player.update(this, playerX, playerY, playerMovement);
    int pX = playerX;
    int pY = playerY;
    int dx = playerMovement.getDX();
    int dy = playerMovement.getDY();

    int zielX = pX + dx;
    int zielY = pY + dy;

    //TEMPORÄR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    playerX += dx;
    playerY += dy;
    return;
/*
    //ausführen, wenn:
    //neue Position innerhalb des Spielfelds
    if(zielX <= GRID_WIDTH && zielX >= 0 && zielY <= GRID_HEIGHT && zielY >= 0){
      bewegung = true;
    }
    //Zielposition leer ist
    else if(dx == 0 && dy==0){
      bewegung = true;
    }
    //Zielposition nicht leer ist und von Character Instanz belegt wird
    else if(dx!=0 && dy!=0 ){  //&& wird von Character Instanz belegt ?????????
      //if(Character.collisionFrom(player)){
      //  bewegung = true;
      //}
    }

    if(bewegung){
      playerX = zielX;
      playerY = zielY;
    }else{
      return;
    }
    */
  }



  // private TreasureChest treasureChest; // ### TreasureChest

  public Grid(){
    currentIteration = 0;
    initGrid();
  }


  @SuppressWarnings("unchecked")
  private void initGrid(){
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
    playerY = GRID_HEIGHT/2;
    player = new Player();
    grid[playerX][playerY] = player;


    /* ### TreasureChest 
    treasureChest = new TreasureChest();
    grid[GRID_WIDTH-2][GRID_HEIGHT/2] = treasureChest;
    */

  }

    // Player
   public Player getPlayer(){
    return player;
  }


  public int getPlayerX(){
    return playerX;
  }

  public int getPlayerY(){
    return playerY;
  }


  /* ### TrasureChest
  public TreasureChest getTreasureChest(){
    return treasureChest;
  }
  */

  // Character
  public Character get(int x, int y){
    if (x < 0 || x >= GRID_WIDTH)
      throw new IllegalArgumentException("x outside of range");

    if (y < 0 || y >= GRID_HEIGHT)
      throw new IllegalArgumentException("y outside of range");

    return this.grid[x][y];
  }


}
