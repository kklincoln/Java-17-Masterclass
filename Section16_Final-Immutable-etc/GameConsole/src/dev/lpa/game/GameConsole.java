package dev.lpa.game;

import java.util.Scanner;

public final class GameConsole<T extends Game<? extends Player>>{
    //Game is also a generic, so we need to use a wildcard and Player as upper bound
    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    ///generate constructor with game instance
    public GameConsole(T game) {
        this.game = game;
    }


    ///METHODS
    // Addplayer
    public int addPlayer(){
        System.out.println("Enter your playing name: ");
        String name = scanner.nextLine();

        System.out.printf("Welcome to %s, %s!%n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    // playgame
    public void playGame(int playerIndex){
        boolean done = false;
        while(!done){
            var gameActions = game.getGameActions(playerIndex);
            //print available options
            System.out.println("Select from one of the following Actions: ");
            // for each character within the keyset of the map, print the prompt from each keyset value
            for (Character c: gameActions.keySet()){
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }

            System.out.println("Enter Next Action: ");
            //get the character at index 0 for the next input and then print the action from gameActions map
            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            //if there's a gameAction in the map from the key entered, executeGameAction on it. continue until returns true
            if(gameAction != null){
                System.out.println("-".repeat(20));
                done = game.executeGameAction(playerIndex, gameAction);
                if (!done){
                    System.out.println("-".repeat(20));
                }
            }
        }
    }

}
