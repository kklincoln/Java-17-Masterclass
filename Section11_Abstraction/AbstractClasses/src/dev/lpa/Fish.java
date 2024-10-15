package dev.lpa;

public class Fish extends Animal{
    //inherits from Aniaml, needs to have the methods overridden and the default constructor established
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow"){
            System.out.println(getExplicitType() + " lazily swimming");
        }else{
            System.out.println(getExplicitType() + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish"){
            System.out.print("swish! ");
        }else{
            System.out.print("Splash! ");
        }
    }
}
