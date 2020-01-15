package battleships;

public interface PlayerActions {
    void setName();
    void shoot();
    boolean placeBoats(String name, Map map);
}
