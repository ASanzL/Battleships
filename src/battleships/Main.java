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
            Boat boat;
            while(boatIndex<=5) {
                String[] boatNames = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
                if(player1.placeBoats(boatNames[boatIndex-1], map)) {
                    map.printMap(map.player1Map);
                    boatIndex++;
                }
            }
            allShipsHasBennPlaced = true;
        }
    }
}
