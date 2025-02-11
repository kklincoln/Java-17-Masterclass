package dev.lpa.pirate;

public enum Loot {
    SILVER_COIN(5),
    GOLD_COIN(10),
    GOLD_RING(125),
    PEARL_NECKLACE(250),
    GOLD_BAR(500);

    public final int worth;

    ///generate constructor with the worth field
    Loot(int worth) {
        this.worth = worth;
    }
    ///generate a getter
    public int getWorth() {
        return worth;
    }
}
