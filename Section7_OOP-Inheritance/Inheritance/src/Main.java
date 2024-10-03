public class Main {
    public static void main(String[] args) {
        // will create an animal base class, and define all the attributes and behaviors that animals have in common
        // animals would have size, weight, move and make noise, so we declare the methods on the base class
        // create a new instance passing in: type, size, weight
        Animal animal = new Animal("Generic Animal","Huge", 400);
        doAnimalStuff(animal, "slow"); //call the mthod below with the new speed argument as slow

        Dog dog = new Dog();    // creates a new instance of dog
        doAnimalStuff(dog, "fast"); // exhibits how the new instance of Dog has attributes and methods from Animal class

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog labrador = new Dog("Labrador Retriever", 65, "Floppy","Swimmer");
        doAnimalStuff(labrador, "slow");

        Dog wolf = new Dog("Wolf",130);
        doAnimalStuff(wolf,"fast");

        // type, weight from Animal; fins,gills from Fish
        Fish goldie = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");
    }

    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise(); //demonstrating the inheritance of the Animal class methods by the Dog class.
        animal.move(speed);
        System.out.println(animal); //prints animal info
        System.out.println("_ _ _ _");
    }
}
