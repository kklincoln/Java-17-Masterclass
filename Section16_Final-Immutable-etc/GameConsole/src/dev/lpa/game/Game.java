package dev.lpa.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends Player>{///Game is a container for Players
/// first two are final to make this game as immutable as possible; keymap varies by game and user
    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions = null;  //VARIES BY GAME AND USER

    ///GENERATE CONSTRUCTORS
    public Game(String gameName) {
        this.gameName = gameName;
    }

    ///generate getter
    public String getGameName() {
        return gameName;
    }

    public Map<Character, GameAction> getStandardActions() {
        if(standardActions == null){
            standardActions = new LinkedHashMap<>(Map.of(
                    'I', new GameAction('I',"Print Player Info",
                            i -> this.printPlayer(i)),
                    'Q', new GameAction('Q', "Quit Game",
                            this::quitGame)
            ));
        }
        return standardActions;
    }

    /// create abstract methods
    public abstract T createNewPlayer(String name);

    public abstract Map<Character, GameAction> getGameActions(int playerIndex); //game actionsa unique by player

    /// PLAYER METHODS
    // ADD PLAYER
    //game console should have access to it so no access modifier
    final int addPlayer(String name){ //subclasses shouldn't have their own versions, final
        T player = createNewPlayer(name);
        if (player != null){
            players.add(player);    // if name exists, add to the players list
            return players.size() - 1;
        }
        return -1;
    }

    //GET PLAYER BY INDEX
    protected final T getPlayer(int playerIndex){
        return players.get(playerIndex);    //from players list, get with playerIndex
    }

    //EXECUTE ACTION
    public boolean executeGameAction(int player, GameAction action){//not final, subclasses may need addtl funcs
        return action.action().test(player);
    }

    // PRINT PLAYER
    public boolean printPlayer(int playerIndex){
        Player player = players.get(playerIndex);
        System.out.println(player);
        return false;
    }

    // QUIT GAME
    public boolean quitGame(int playerIndex){
        Player player = players.get(playerIndex);
        System.out.println("Sorry to see you go, " + player.name());
        return true;
    }

}
