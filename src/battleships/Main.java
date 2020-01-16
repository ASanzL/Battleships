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

        PlayerActions player1 = new Player("");
        PlayerActions player2 = new Player("");

        System.out.print("Play against computer?: ");
        boolean playAgainstComputer;
        playAgainstComputer = scanner.next().equals("y");
        if(!playAgainstComputer) {
            System.out.println("Enter name of player 1: ");
            player1 = new Player(scanner.next());
            System.out.println("Enter name of player 2: ");
            player2 = new Player(scanner.next());
        } else {
            System.out.println("Enter name of player 1: ");
            player1 = new Player(scanner.next());
            player2 = new Computer();
        }
        placeAllBoats(player1, map.player1Map);
        placeAllBoats(player2, map.player2Map);

        boolean player1sTurn = true;
        PlayerActions player = player1;
        TileObject[][] tileMap = map.player2Map;

        // Change true to check if anyone has won
        while (true) {
            System.out.println(player.getName() + "'s turn to shoot.");
            while(!player.shoot(tileMap));
            player = (player1sTurn) ? player2 : player1;
            tileMap = (player1sTurn) ? map.player1Map : map.player2Map;
            player1sTurn = !player1sTurn;
            if(player1sTurn){
                Map.printPlayMap(map.player1Map);
            }else{
                Map.printPlayMap(map.player2Map);
            }
            //Map.printMap(!tileMap);
        }
    }

    public static void placeAllBoats(PlayerActions player, TileObject[][] map) {
        System.out.println(player.getName() + " turn to place ships.");
        boolean allShipsHasBennPlaced = false;
        int boatIndex = 1;
        while (!allShipsHasBennPlaced) {
            Boat boat;
            while(boatIndex<=2) {
                String[] boatNames = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
                if(player.placeBoats(boatNames[boatIndex-1], map)) {
                    boatIndex++;
                    if(player instanceof Player) {
                        Map.printMap(map);
                    }
                }
            }
            allShipsHasBennPlaced = true;
        }
        Map.printMap(map);
    }

    public static void shoot() {

    }
}
