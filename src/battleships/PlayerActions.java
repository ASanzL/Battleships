package battleships;

public interface PlayerActions {
    String getName();
    boolean shoot(TileObject[][] map);
    boolean placeBoats(String name, TileObject[][] map);
}
