package dev.lpa;

public class PlayingCard {

    private String suit;
    private String face;
    private int internalHash;

    ///GENERATE CONSTRUCTOR W/ FIRST TWO ARGUMENTS
    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
//        this.internalHash = 1;//in test code, the algo returns the same bucket identifier for all cards so it assumes they're all equal;
        this.internalHash = (suit.equals("Hearts")) ? 11 : 12;
    }

    ///GENERATE A TOSTRING
    @Override
    public String toString() {
        return face + " of " + suit;
    }


    ///OVERRIDE THE HASHCODE AND EQUALS METHODS; ensure that the last screen with 'null' options are checked
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // two references pointing to the same object is the surest test for equality.
        if (o == null || getClass() != o.getClass()) return false; // compares result of get classes,

        PlayingCard that = (PlayingCard) o; //if equal, cast result to a playingcard
        return suit.equals(that.suit) && face.equals(that.face);    //checks suit and then face for equality as well
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }
}
