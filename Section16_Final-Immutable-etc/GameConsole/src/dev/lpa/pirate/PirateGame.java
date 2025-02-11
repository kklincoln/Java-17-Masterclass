package dev.lpa.pirate;

import dev.lpa.game.Game;
import dev.lpa.game.GameAction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//type argument for the game is a Pirate player
public class PirateGame extends Game<Pirate> {

    private static final List<List<Town>> levelMap;   //2D list (levelOfPlay, list<towns>)

    //--------------------------------
    static{
        levelMap = new ArrayList<>();
        System.out.println("Loading Data...");
        loadData(); //populates levelMap with data

        if (levelMap.size() == 0){
            throw new RuntimeException("Could not load data, try later.");  //nobody can use the PirateGame class if no level data
        }
        System.out.println("Finished Loading Data.");
    }

    ///GENERATE CONSTRUCTOR MATCHING SUPER
    public PirateGame(String gameName) {
        super(gameName);
    }


    //--------------------------------------------
    ///IMPLEMENT ABSTRACT METHODS (FROM THE Game CLASS); modified to include the Pirate returns
    @Override
    public Pirate createNewPlayer(String name) {
        Pirate pirate = new Pirate(name);
        pirate.visitTown();
        return pirate;
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Pirate pirate = getPlayer(playerIndex);
        System.out.println(pirate);
        List<Weapon> weapons = Weapon.getWeaponsByLevel(pirate.value("level")); //passing the pirate's current level

        Map<Character, GameAction> map = new LinkedHashMap<>(); //retains ordered functionality

        //only print weapons if the pirate has opponents
        if (pirate.hasOpponents()){
            //loop through weapons available at the player's level
            for (Weapon weapon : weapons){
                char init = weapon.name().charAt(0);   //menu key for this weapon
                map.put(init, new GameAction(init, "Use " + weapon, this::useWeapon));
            }
        }

        map.put('F', new GameAction('F', "Find Loot", this::findLoot));
        if (pirate.hasExperiences()){
            map.put('X', new GameAction('X', "Experience Town Feature", this::experienceFeature));
        }

        map.putAll(getStandardActions()); // quit & getPlayerInfo
        return map;
    }

    //static because it's called from static initializer
    private static void loadData(){
        //LEVEL 1 TOWNS
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Bridgetown", "Barbados" ,0),
                new Town("Fitts Village", "Barbados", 0),
                new Town("Holetown", "Barbados", 0)

        )));
        //LEVEL 2 TOWNS
        levelMap.add(new ArrayList<Town>(List.of(
                new Town("Fort-de-France", "Martinique", 1),
                new Town("Sainte-Anne", "Martinique", 1),
                new Town("Le Vauclin", "Martinique",1)
        )));
    }

    /// METHOD TO RETURN TOWNS FROM A SPECIFIED LEVEL
    public static List<Town> getTowns(int level){
        if (level <= (levelMap.size() - 1)){
            return levelMap.get(level);
        }
        return null;    //cannot return level data for greater level than exists
    }

    ///delegates to the useWeapon method in Pirate class
    private boolean useWeapon(int playerIndex){
        return getPlayer(playerIndex).useWeapon();
    }
    //to make the above work, override the executeGameAction method from Game class; also update the getGameActions method above
    @Override
    public boolean executeGameAction(int player, GameAction action) {
        //set weapon before executing the useWeapon method
        getPlayer(player).setCurrentWeapon(Weapon.getWeaponByChar(action.key()));
        return super.executeGameAction(player, action);
    }


    @Override
    public boolean printPlayer(int playerIndex) {

        System.out.println(getPlayer(playerIndex).information());
        return false;
    }

    public boolean findLoot(int playerIndex){
        return getPlayer(playerIndex).findLoot();
    }

    public boolean experienceFeature(int playerIndex){
        return getPlayer(playerIndex).experienceFeature();
    }
}
