package dungeonchase;

import java.util.Random;

public enum Direction {
    NONE(0, 0),
    NORTH(0, 1),
    NORTH_EAST(1, 1),
    EAST(1, 0),
    SOUTH_EAST(1, -1),
    SOUTH(0, -1),
    SOUTH_WEST(-1, -1),
    WEST(-1, 0),
    NORTH_WEST(-1, 1);

    int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    //Getter
    public int getDX() {
        return this.dx;
    }
    public int getDY() {
        return this.dy;
    }

    /**
     * Rückgabe der zu dx und dy passenden Richtung
     * @param dx:
     * @param dy
     * @return zu dx und dy passende Richtung
     */
    public static Direction fromD(int dx, int dy) {
        Direction direction = null;
        for (Direction d : Direction.values()) {
            try {
                if (dx == d.dx && dy == d.dy) {
                    direction = d;
                }
            } catch (IllegalArgumentException IAE) {
                System.out.println("Angabe eines falschen Parameters!");
            }
        }
        return direction;
    }

    /**
     * @return entgegengesetzte Richtung von aufgerufener Richtung
     */
    public Direction opposite() {
        return fromD(-dx, -dy);
    }

    /**
     * Zufällige Generierung einer Geografischen Richtung
     * @return Richtung
     */
    public static Direction random4() {
        Random r = new Random();
        Direction dir;
        //create random int between 1 and 4
        int rand = r.nextInt(4) + 1;
        //assign a direction to the integer and return it
        if (rand == 1)
            dir = EAST;
        else if (rand == 2)
            dir = WEST;
        else if (rand == 3)
            dir = SOUTH;
        else
            dir = NORTH;
        return dir;
    }
}