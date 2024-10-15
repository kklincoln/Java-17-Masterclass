package dev.lpa;

public class Horse extends Mammal{
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    //only need to override these two methods from the Animal class since the move() method was overridden in Mammal
    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds hair in the Spring.");
    }

    @Override
    public void makeNoise() {

    }
}
