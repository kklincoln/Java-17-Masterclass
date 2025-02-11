package dev.lpa.pirate;

public enum Feature {
    //constants for things someone might run into on an island
    ALLIGATOR(-45),
    ALOE(5),
    JELLYFISH(-10),
    PINEAPPLE(10),
    SNAKE(-25),
    SPRING(25),
    SUN_POISON(-15);


    public final int healthPoints;

    ///generate constructor with the healthPoints field
    Feature(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    ///generate a getter
    public int getHealthPoints() {
        return healthPoints;
    }
}
