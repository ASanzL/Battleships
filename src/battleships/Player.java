package battleships;

import java.util.Scanner;

public class Player implements PlayerActions {
    private String name;
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public boolean placeBoats(String name, Map map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X coordinate of " + name + ": ");
        int xCoord = scanner.nextInt();
        System.out.println("Enter Y coordinate of " + name + ": ");
        int yCoord = scanner.nextInt();
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
        switch(name){
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

        if(map.placeBoat(boat, map.player1Map)) {
            return true;
        }
        return false;
    }
}
