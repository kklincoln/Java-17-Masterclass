package dev.lpa.pirate;

import dev.lpa.game.Player;

import java.util.*;

public sealed class Combatant implements Player
        permits Islander, Pirate, Soldier {

    private final String name; //required for Player implementation
    private final Map<String, Integer> gameData; // player list
    private Weapon currentWeapon;

    ///generate constructor
    public Combatant(String name) {
        this.name = name;
    }

    public Combatant(String name, Map<String, Integer> gameData) {
        this.name = name;
        if (gameData != null){  //mutating the gameData map by adding new values if it is currently null
            this.gameData.putAll(gameData);
        }
    }

    //----------------------------------------------------------------------
    ///INSTANCE INITIALIZER; Executed regardless of which constructor is used.
    {
        //order doesn't matter for the gameData so we use HashMap; combatant only needs health and score
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0
        ));
    }

    ///GENERATE A GETTER AND SETTER FOR THE CURRENTWEAPON
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    //removed modifier so only classes in this(pirate) package can invoke it
    void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    //---------------------------------------------
    ///GET PIRATE DATA
    //package private; pirate game can call this
    int value(String name){
        return gameData.get(name);  //returns key to the specific pirate data element in gameData
    }
    ///SET PIRATE DATA
    protected void setValue(String name, int value){
        //place a new value in the gameData map
        gameData.put(name, value);
    }
    ///MODIFY PIRATE DATA
    protected void adjustValue(String name, int adj){
        gameData.compute(name, (k,v) -> v +=adj);   //lambda function to add the adjustment amount to the map value
    }
    ///ADJUST HEALTH
    protected void adjustHealth(int adj){
        int health = value("health");   //pulls data from gameData map using key: "health"
        health += adj;
        // set 0-100 threshold
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        //setValue method into the gameData map using the String key and the new value
        setValue("health", health);
    }


    //---------------------------------------------
    ///GAME RELATED METHODS
    boolean useWeapon(Combatant opponent){
        System.out.print(name + " used the " + currentWeapon);
        if(new Random().nextBoolean()){
            System.out.println(" and HIT *** " + opponent.name() + "! ***");
            opponent.adjustHealth(-currentWeapon.getHitPoints());
            System.out.printf("%s's health=%d, %s's health=%d%n",
                    name, value("health"),
                    opponent.name(), opponent.value("health"));
            adjustValue("score", 50);
        } else {
            System.out.println(" and missed!");
        }
        return (opponent.value("health") <= 0);

    }


    @Override
    public String name() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }

    public String information(){
        return name + " " + gameData;
    }

}
