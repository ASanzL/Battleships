package battleships;

public class Destroyer extends Boat {
    public Destroyer(int x, int y, int[] direction) {
        setLength(3);
        setName('D');
        setCoord(new int[] {x, y});
        setDirection(direction);
    }
}
