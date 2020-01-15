package battleships;

public class Computer implements PlayerActions {
    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public void shoot(TileObject[][] map) {

    }

    @Override
    public boolean placeBoats(String name, TileObject[][] map) {
        int xCoord = (int)(10.0 * Math.random());
        int yCoord = (int)(10.0 * Math.random());
        int xDirection = -1;
        int yDirection = 0;
        if ((int)(3.0 * Math.random()) > 1) {
            xDirection = 1;
            yDirection = 0;
        } else {
            xDirection = 0;
            yDirection = 1;
        }
        Boat boat = new CarrierShip(xCoord-1, yCoord-1, new int[]{xDirection, yDirection});
        switch(name) {
            case"Battleship":
                boat = new Battleship(xCoord-1, yCoord-1, new int[]{xDirection, yDirection});
                break;
            case"Destroyer":
                boat = new Destroyer(xCoord-1, yCoord-1, new int[]{xDirection, yDirection});
                break;
            case"Submarine":
                boat = new Submarine(xCoord-1, yCoord-1, new int[]{xDirection, yDirection});
                break;
            case"Patrol Boat":
                boat = new PatrolBoat(xCoord-1, yCoord-1, new int[]{xDirection, yDirection});
                break;
        }
        if(Map.placeBoat(boat, map)) {
            return true;
        }
        return false;
    }
}
