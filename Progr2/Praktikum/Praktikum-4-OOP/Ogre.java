package dungeonchase;

public class Ogre extends Character{
    public Ogre(){
        super("Oger");
    }

    @Override
    public String getImage(){
        return "ogre.png";
    }

    @Override
    public Direction update(Grid grid, int x, int y, Direction playerMovement){
        Direction dir = null;
        int dx = Math.abs(x - grid.getPlayerX());
        int dy = Math.abs(y - grid.getPlayerY());

        //Move West or EAst
        if(dx > dy){
            if(grid.getPlayerX() > x){
                dir = Direction.EAST;
            }else{
                dir = Direction.WEST;
            }
        }
        //Move North or South
        else if(dy > dx){
            if(grid.getPlayerY() > y){
                dir = Direction.NORTH;
            }else{
                dir = Direction.SOUTH;
            }
        }

        return dir;
    }
}
