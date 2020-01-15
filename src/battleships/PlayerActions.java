package battleships;

public interface PlayerActions {
    String getName();
    void shoot(TileObject[][] map);
    boolean placeBoats(String name, TileObject[][] map);
}
