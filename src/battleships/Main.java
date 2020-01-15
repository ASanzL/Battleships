package battleships;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map map = new Map();
        /*map.placeBoat(new Battleship(2, 7, new int[]{0, -1}), map.player1Map);
        map.placeBoat(new CarrierShip(1, 2, new int[]{1, 0}), map.player1Map);
        map.placeBoat(new Destroyer(7, 5, new int[]{-1, 0}), map.player1Map);
        map.placeBoat(new Submarine(9, 4, new int[]{-1, 0}), map.player1Map);
        map.placeBoat(new PatrolBoat(9, 7, new int[]{-1, 0}), map.player1Map);
        map.printMap(map.player1Map);*/

        Player player1 = new Player("");
        Player player2 = new Player("");

        System.out.print("Play against computer?: ");
        boolean playAgainstComputer;
        playAgainstComputer = scanner.next().equals("y");
        if(!playAgainstComputer) {
            System.out.println("Enter name of player 1: ");
            player1 = new Player(scanner.next());
            player2 = new Player("Computer");
        } else {
            // 2 players
        }

        boolean allShipsHasBennPlaced = false;
        int boatIndex = 1;
        while (!allShipsHasBennPlaced) {
            int xCoord;
            int yCoord;
            int xDirection;
            int yDirection;

            Boat boat;
            while(boatIndex<=5){
                String[] boatNames = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
                if(placeBoat(boatNames[boatIndex-1], map)) {
                    map.printMap(map.player1Map);
                    boatIndex++;
                }
            }
            allShipsHasBennPlaced = true;
        }
    }

    public static boolean placeBoat(String name, Map map) {
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
