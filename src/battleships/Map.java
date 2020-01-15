package battleships;

public class Map {
    TileObject [][] player1Map = new TileObject[10][10];
    TileObject [][] player2Map = new TileObject[10][10];


    public static boolean placeBoat(Boat boat, TileObject [][] map) {
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

    public static boolean shoot(Ammunition ammunition, TileObject [][] map) {
        TileObject x = map[ammunition.getX()]
                [ammunition.getY()];
            try {
                if ((map[ammunition.getX()]
                        [ammunition.getY()] instanceof Ammunition)) {
                    System.out.println("You have already shot there.");
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
            if(map[ammunition.getX()][ammunition.getY()] instanceof Boat) {
                Boat boat = (Boat)map[ammunition.getX()][ammunition.getY()];
                boat.takeDamage();

            } else {
                System.out.println("You hit water.");
            }
        map[ammunition.getX()][ammunition.getY()] = ammunition;
            return true;
    }

    public static void printMap(TileObject [][] map) {
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
