package battleships;

public class Battleship extends Boat {
    public Battleship(int x, int y, int[] direction) {
        setLength(4);
        setName('B');
        setCoord(new int[] {x, y});
        setDirection(direction);
    }
}
