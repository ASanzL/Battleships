package battleships;

public class PatrolBoat extends Boat {
    public PatrolBoat(int x, int y, int[] direction) {
        setLength(2);
        setName('P');
        setCoord(new int[] {x, y});
        setDirection(direction);
    }
}