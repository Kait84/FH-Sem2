package dungeonchase;

public class Player extends Character {
    @Override
    public abstract String getImage(){
        return "app/src/main/resources/player.png";
    }
    @Override
    public abstract Direction update(Direction playerMovement){
        return Player.playerMovement;
    }
}
