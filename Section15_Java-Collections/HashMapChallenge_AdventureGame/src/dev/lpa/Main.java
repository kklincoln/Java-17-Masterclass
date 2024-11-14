package dev.lpa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String myLocations = """
                lake,at the edge of Lake Tim, E:ocean,W:Forest,S:well house,N:cave
                ocean,on Tim's beach before an agry sea,W:lake
                cave,at the mouth of Tim's bat cave,E:ocean,W:forest,S:lake
                """;


        ///CREATE A NEW ADVENTURE GAME
        AdventureGame game = new AdventureGame();
        game.play("lake");

        /// SET UP A SCANNER TO LOG THE PLAYER RESPONSES
        Scanner scanner = new Scanner(System.in);

        while(true){
            String direction = scanner.nextLine().trim().toUpperCase().substring(0,1); //get the first char of entry, trimmed
            if (direction.equals("Q")) break;
            game.move(direction);

        }



    }
}
