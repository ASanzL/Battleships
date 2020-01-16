package battleships;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements PlayerActions {
    private String name;
    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean shoot(TileObject[][] map) {
        Scanner scanner = new Scanner(System.in);
        int xCoord = -1;
        int yCoord = -1;
        System.out.println("Enter X coordinate to shoot at: ");
        try {
            xCoord = scanner.nextInt();
        } catch (InputMismatchException e) {
            return false;
        }
        System.out.println("Enter Y coordinate to shoot at: ");
        try {
            xCoord = scanner.nextInt();
        } catch (InputMismatchException e) {
            return false;
        }
        Map.shoot(new Ammunition(xCoord-1, yCoord-1), map);
        return true;
    }

    @Override
    public boolean placeBoats(String name, TileObject[][] map) {
        Scanner scanner = new Scanner(System.in);
        int xCoord = -1;
        int yCoord = -1;
        System.out.println("Enter X coordinate of " + name + ": ");
        try {
            xCoord = scanner.nextInt();
        } catch (InputMismatchException e) {
            return false;
        }
        System.out.println("Enter Y coordinate of " + name + ": ");
        try {
            yCoord = scanner.nextInt();
        } catch (InputMismatchException e) {
            return false;
        }
        System.out.println("Enter direction of " + name + ": (n/e/s/w)");
        String direction = scanner.next();
        int xDirection = -1;
        int yDirection = 0;

        switch(direction){
            case"n":
                xDirection = 0;
                yDirection = -1;
                break;
            case"e":
                xDirection = 1;
                yDirection = 0;
                break;
            case"s":
                xDirection = 0;
                yDirection = 1;
                break;
            case"w":
                xDirection = -1;
                yDirection = 0;
                break;
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
