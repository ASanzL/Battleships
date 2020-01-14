package battleships;

public class CarrierShip extends Boat {
    public CarrierShip(int x, int y, int[] direction) {
        setLength(5);
        setName('C');
        setCoord(new int[] {x, y});
        setDirection(direction);
    }
}
