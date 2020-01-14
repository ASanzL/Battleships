package battleships;

public class Submarine extends Boat {
    public Submarine(int x, int y, int[] direction) {
        setLength(3);
        setName('S');
        setCoord(new int[] {x, y});
        setDirection(direction);
    }
}