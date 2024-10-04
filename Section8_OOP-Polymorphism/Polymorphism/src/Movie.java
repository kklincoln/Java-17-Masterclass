public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }
    //add public movie method
    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }
        //creating a method that will initialize an instance of movie, so we don't have to do that in the Main file
    public static Movie getMovie(String type, String title){
        return switch(type.toUpperCase().charAt(0)){    //evaluate a single character at index 0 in capital to use the class
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title) ;
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }

}


//create new class for Adventure films
class Adventure extends Movie {
    //generate a constructor for the Movie extension
    public Adventure(String title) {
        super(title);
    }

    //override the watchMovie method for the Adventure class, use code generation method override
    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something bad happens");
    }
    //adding a simple method
    public void watchAdventure(){
        System.out.println("Watching an Adventure!");
    }
}

//create new class for Comedy films
class Comedy extends Movie{
    //generate a constructor for the Movie extension
    public Comedy(String title) {
        super(title);
    }

    //override the watchMovie method for the Adventure class, use code generation method override
    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy ending");
    }
    //adding a simple method
    public void watchComedy(){
        System.out.println("Watching a Comedy!");
    }
}


//create new class for Sci-Fi films
class ScienceFiction extends Movie{
    //generate a constructor for the Movie extension
    public ScienceFiction(String title) {
        super(title);
    }

    //override the watchMovie method for the Adventure class, use code generation method override
    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet Blows Up");
    }
    //adding a simple method
    public void watchScienceFiction(){
        System.out.println("Watching a Sci-Fi!");
    }
}


