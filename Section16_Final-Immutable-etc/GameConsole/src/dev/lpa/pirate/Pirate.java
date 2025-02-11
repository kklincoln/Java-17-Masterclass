package dev.lpa.pirate;

import java.util.*;

public final class Pirate extends Combatant {

    private final List<Town> townsVisited = new LinkedList<Town>();   // linkedList for insertion order, maintaining order of visit
    /// the lists below will get updated every time a pirate moves from town to town
    private List<Loot> loot;
    private List<Combatant> opponents;
    private List<Feature> features;

    ///generate constructor
    public Pirate(String name) {
        //calling the Map when pirate is initially at level 0 in town 0
        super(name, Map.of("level", 0, "townIndex",0));
    }
    //----------------------------------------------------------------------
    ///GAME RELATED METHODS
    boolean useWeapon(){
        //figure out which opponent to fight
        int count = opponents.size();
        if (count > 0){
            int opponentIndex = count - 1;
            if (count > 1){
                opponentIndex = new Random().nextInt(count);
            }
            Combatant combatant = opponents.get(opponentIndex);
            if (super.useWeapon(combatant)){ //if this returns true, the combatant has died
                opponents.remove(opponentIndex);
            }else {
                return combatant.useWeapon(this);
            }
        }
        return false; //game continues
    }

    boolean visitTown(){
        List<Town> levelTowns = PirateGame.getTowns(value("level"));
        if (levelTowns == null) return true; //game is over if no towns
        Town town = levelTowns.get(value("townIndex"));   //get town using player's townIndex from gameData map

        if (town != null){
            townsVisited.add(town);
            loot = town.loot();
            opponents = town.opponents();
            features = town.features();
            return false;   //game continues
        }
        return true; //if town not retrieved, game needs to end
    }


    ///HELPER METHODS
    boolean hasExperiences(){
        return (features != null && features.size() > 0);
    }

    boolean hasOpponents(){
        return (opponents != null && opponents.size() > 0);
    }


    @Override
    public String information() {
        //using LinkedList to utilize the methods attached to it
        var current = ((LinkedList<Town>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        //for each value at i, split the name on the comma, resulting in a simpler name;
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).name());
        return "---> " + current +
                "\nPirate " + super.information() +
                "\n\ttownsVisited" + Arrays.toString(simpleNames);
    }

    /// package private for indicating if loot has been found
    boolean findLoot(){
         //if pirate's list of loot has items, remove the first element
        if (loot.size() > 0 ){
            Loot item = loot.remove(0);
            System.out.println("Found " + item + "!");
            adjustValue("score", item.getWorth());
            System.out.println(name() + "'s score is now " + value("score"));
        }
        // if all the loot is found, visit the next town
        if (loot.size() == 0){
            return visitNextTown();
        }
        //else, game continues
        return false;
    }

    /// package private returns boolean
    boolean experienceFeature(){
        if (features.size() > 0){
            Feature item = features.remove(0);
            System.out.println("Ran into " + item + "!");
            adjustHealth(item.getHealthPoints());
            System.out.println(name() +"'s health is now " + value("health"));
        }
        //ends game if the player's health is zero or less
        return (value("health") <= 0 );
    }


    // visit next towns
    private boolean visitNextTown(){
        int townIndex = value("townIndex"); //get's town index for current pirate
        List<Town> towns = PirateGame.getTowns(value("level"));    //get towns for player's current level
        if (towns == null) return true;
        if (townIndex >= (towns.size() -1)){
            System.out.println("Leveling up! Bonus: 500 points!");
            adjustValue("score", 500);
            adjustValue("level", 1);
            setValue("townIndex", 0);   //starts at the next level's first town
        } else{
            System.out.println("Sailing to the next town! Bonus: 50 points!");
            adjustValue("townIndex", 1);
            adjustValue("score",50);
        }
        return visitTown();
    }

}
