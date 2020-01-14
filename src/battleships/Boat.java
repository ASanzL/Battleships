package battleships;

public abstract class Boat {
    private int length;
    private int[] coordinates;
    private int[] direction;
    private char name;

    public int getLength() {
        return length;
    }

    protected void setLength(int i) {
        length = i;
    }

    public int getDirectionX() {
        return direction[0];
    }

    public int getDirectionY() {
        return direction[1];
    }

    public void setDirectionX(int direction) {
        this.direction[0] = direction;
    }

    public void setDirectionY(int direction) {
        this.direction[1] = direction;
    }

    public void setDirection(int[] direction) {
        this.direction = direction;
    }

    public int[] getCoord() {
        return coordinates;
    }

    protected void setCoord(int[] i) {
        coordinates = i;
    }

    public int getX() {
        return coordinates[0];
    }

    public int getY() {
        return coordinates[1];
    }
    public char getName() {
        return name;
    }
    protected void setName(char c) {
        name = c;
    }
}
