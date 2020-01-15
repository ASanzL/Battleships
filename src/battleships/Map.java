package battleships;

public class Map {
    Boat [][] player1Map = new Boat[10][10];
    Boat [][] player2Map = new Boat[10][10];

    public boolean placeBoat(Boat boat, Boat [][] map) {
        for(int i = 0; i < boat.getLength(); i++) {
            try {
                if (map[boat.getX() + i * boat.getDirectionX()]
                        [boat.getY() + i * boat.getDirectionY()] != null) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }

        for(int i = 0; i < boat.getLength(); i++) {
            map[boat.getX() + i*boat.getDirectionX()]
                    [boat.getY() + i*boat.getDirectionY()] = boat;
        }
        return true;
    }
    public void printMap(Boat [][] map) {
        System.out.print(" ");
        for (int i = 1; i < map.length + 1; i++) {
            System.out.print(" " + i  + " ");
        }

        System.out.println("");
        for (int i = 1; i < map.length + 1; i++) {
            System.out.print((char)(64+i));
            for (int j = 1; j < map.length + 1; j++) {
                if (map[j-1][i-1] != null) {
                    System.out.print(" " + map[j-1][i-1].getName() + " ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
