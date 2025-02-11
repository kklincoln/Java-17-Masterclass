package dev.lpa;


import dev.lpa.game.GameConsole;
import dev.lpa.pirate.PirateGame;

//since gameConsole is generic, this will also be declared the same way
//class SpecialGameConsole<T extends Game<? extends Player>>
//    extends GameConsole<Game<? extends Player>> {
//
//    public SpecialGameConsole(Game<? extends Player> game){
//        super(game);
//    }
//}

//--------------------------------MAIN METHOD--------------------------------------
public class MainFinal {
    public static void main(String[] args) {

        ///SET UP A LOCAL VARIABLE TO USE THE NEW CLASS ABOVE IN THE MAIN METHOD
        GameConsole<PirateGame> game = new GameConsole<>(new PirateGame("Pirate Game"));
    }

}
