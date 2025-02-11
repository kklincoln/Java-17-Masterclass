package dev.lpa.pirate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon {
    AXE(0, 10),
    KNIFE(0, 30),
    MACHETE(1, 40),
    PISTOL(1, 50);

    //private and final for these fields since they will not change; declared above
    private final int minLevel;   //determines when a player can use the weapon
    private final int hitPoints;  //damage the weapon inflicts on opponents health


    ///GENERATE CONSTRUCTOR
    Weapon(int minLevel, int hitPoints) {
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    /// GENERATE GETTERS
    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    ///HELPER METHODS.
    ///get weapon from enum values
    public static Weapon getWeaponByChar(char firstInitial){
        //loop through each enum constant through the values, getting the first value
        for (Weapon w: values()){
            if (w.name().charAt(0) == firstInitial){
                return w;
            }
        }
        return values()[0]; //if match not found, return first value in the enum
    }

    ///get available weapons based on level of play
    public static List<Weapon> getWeaponsByLevel(int levelOfPlay){
        // loop through each enum constant and check the second index for level of play, if > remove from list.  return
        List<Weapon> weapons = new ArrayList<>(EnumSet.allOf(Weapon.class));    //populate list with the full weapon list
        weapons.removeIf(w -> (w.minLevel > levelOfPlay));

        return weapons;
    }
}
