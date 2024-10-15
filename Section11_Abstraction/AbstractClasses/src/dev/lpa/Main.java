package dev.lpa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Animal animal = new Animal("animal","big",100); //this does not work because we cannot instantiate an abstract class
        Dog dog = new Dog("Wolf", "Big", 100);
        dog.makeNoise();

        doAnimalStuff(dog); // even though we called the dog variable, its type is named "Wolf" so output is using that as type

        //created a new class of fish, duplicated from Dog and adjusted. Can pass any instance that inherits from Animal
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog); //add the dog instance to the ArrayList
        animals.add(new Dog("German Shepard", "Big", 150));
        animals.add(new Fish("Goldfish","Small", 1));
        animals.add(new Fish("Barracuda", "Big", 75));
        animals.add(new Dog("Pug", "Small", 25));

        animals.add(new Horse("Clydesdale","Large", 1000));
        //forLoop to process through Animals in the ArrayList
        for (Animal animal : animals){
            doAnimalStuff(animal);
        }
    }

    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
        if (animal instanceof Mammal currentMammal){
            currentMammal.shedHair();
        }
    }
}
