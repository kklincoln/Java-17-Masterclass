public class Animal {
    protected String type; //the protected encapsulation allows for some limited access to fields by subclasses
    private String size;
    private double weight;

    //default constructor; added for inheritance
    public Animal(){}

    public Animal( String type, String size, double weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
    }


    // a way to print out the information about the animal (generated with code>Generate)
    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed){
        System.out.println(type + " moves " + speed);
    }

    public void makeNoise(){
        System.out.println(type + " makes some kind of noise");
    }
}
