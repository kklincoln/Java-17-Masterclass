package dev.lpa.game;

public record Shooter(String name) implements Player {
    boolean findPrize(){
        System.out.println("Prize found, score should be adjusted.");
        return false; // game shouldn't end if prize found
    }

    boolean useWeapon(String weapon){
        System.out.println("You shot your " + weapon);
        return false;
    }


}
