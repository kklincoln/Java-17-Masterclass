public class EnhancedPlayer {
// create fields with private accessibility for encapsulation
    private String fullName;
    private int healthPercentage;
    private String weapon;


    //overloading constructor
    public EnhancedPlayer(String fullName){
        this(fullName, 100,"Sword"); // calls the other constructor using the args provided with defaults
    }

    // constructor
    public EnhancedPlayer(String fullName, int health, String weapon){
        this.fullName = fullName;
        //add validation for the health argument to stay within the range of 1-100
        if (health <= 0 ) {
            this.healthPercentage = 1;
        }else if (health > 100){
            this.healthPercentage = 100;
        }else{
            this.healthPercentage = health;
        }
        this.weapon = weapon;
        }


    //create methods
    public void loseHealth(int damage){
        healthPercentage -= damage;
        if(healthPercentage <= 0){
            System.out.println("Player was knocked out of the game.");
        }
    }
    public int healthRemaining(){
        return healthPercentage;
    }
    public void restoreHealth(int regenerate){
        healthPercentage += regenerate;
        if (healthPercentage > 100){
            healthPercentage = 100;
            System.out.println("Player was restored to 100% health.");
        }
    }
}
