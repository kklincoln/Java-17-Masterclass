package dev.lpa.game;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ShooterGame extends Game<Shooter>{//extends game with type arg of Shooter

    ///2) default constructor
    public ShooterGame(String gameName) {
        super(gameName);
    }

    ///1) GENERATED ABSTRACT CLASSES
    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        var map = new LinkedHashMap<>(Map.of(   //LinkedHashmap guarantees order
                'F',new GameAction('F',"Find Prize", this::findPrize),
                'S', new GameAction('S',"Use your gun", this::useWeapon)
        ));
        //get the standard actions (quit, getinfo)
        map.putAll(getStandardActions());
        return map;
    }

    ///3)  IMPLEMENT METHODS FROM ABSTRACT METHODS
    public boolean findPrize(int playerIndex){
        return getPlayer(playerIndex).findPrize();
    }

    public boolean useWeapon(int playerIndex){
        return getPlayer(playerIndex).useWeapon("pistol");
    }

}
