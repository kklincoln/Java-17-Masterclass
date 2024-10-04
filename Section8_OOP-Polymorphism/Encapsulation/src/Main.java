public class Main {
    public static void main(String[] args) {
        Player player = new Player();
//        // we can only access the fields below because they are set as public accessible
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        //testing gameplay
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Reamining health = " + player.healthRemaining());
//
//          player.health = 200;
//        //pushing through to 0 health
//        player.loseHealth(11);
//        System.out.println("Remaining health = " + player.healthRemaining());
    //commented out the above code that demonstrated the approach not using enacapsulation;
//        problem1: the downside is that without using encapsulation, technically someone could 'inject' code as done
        // in line 14, to artificially change the expected game outcome.
//        problem2: allowing direct access to fields means that calling code would need to be changed with any field change
        // in the original class, as shown in line 5
//        problem3: ommitting a constructor means that any enforcement of expected code responsibility is placed upon the calling code
        //rather than the code within the class itself.

        EnhancedPlayer tim = new EnhancedPlayer("Tim", 200,"Sword");
        //note that even though the 200 was attempted to be passed, the default values were enforced w/ encapsulation
        System.out.println("Initial health is " + tim.healthRemaining());

    }
}
