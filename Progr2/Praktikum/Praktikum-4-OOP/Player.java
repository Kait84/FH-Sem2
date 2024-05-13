package dungeonchase;

public class Player extends Character {

    public Player(){
        super("Player");
    }

    @Override
    public String getImage(){
        return "player.png";
    }
    @Override
    public Direction update(Grid grid, int x, int y, Direction playerMovement){
        return playerMovement;
    }
}
