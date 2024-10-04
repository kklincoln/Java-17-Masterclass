public class Player {

    //establish fields
    public String fullName;
    public int health;
    public String weapon;

    //create methods
    public void loseHealth(int damage){
        health -= damage;
        if(health <= 0){
            System.out.println("Player was knocked out of the game.");
        }
    }
    public int healthRemaining(){
        return health;
    }
    public void restoreHealth(int regenerate){
        health += regenerate;
        if (health > 100){
            health = 100;
            System.out.println("Player was restored to 100% health.");
        }
    }

}
