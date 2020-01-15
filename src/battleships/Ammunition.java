package battleships;

public class Ammunition implements TileObject {
    public Ammunition(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }

    @Override
    public char getName() {
        return '@';
    }

    public int getX() {
        return coordinates[0];
    }

    public int getY() {
        return coordinates[1];
    }
}