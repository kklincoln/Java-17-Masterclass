import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie theMovie = new Movie("Star Wars");
//        theMovie.watchMovie(); // prints "Star Wars is a Movie film" // returns the instance type associated with the title

        //testing the polymorphism method override associated with the Adventure movies
//        Movie theAdventureMovie = new Adventure("Star Wars");
//        theAdventureMovie.watchMovie(); // prints "Star Wars is a Movie film" // returns the instance type associated with the title

        //testing the switch method to instantiate a movie class from the Movie class
//        Movie theMovie = Movie.getMovie("Science", "Star Wars");
//        theMovie.watchMovie(); // prints "Star Wars is a Movie film"

        // creating an interactive approach that lets the user signal what type of movie and what movie to watch
        Scanner s = new Scanner(System.in); // create a new scanner that will monitor user input
        // create a loop to keep scanning for user input until the loop is exited:
        while (true){
            System.out.println("What genre of movie do you want to watch? (A for Adventure, C for Comedy," +
                    " S for Science Fiction, or Q to quit)");
            String type = s.nextLine(); // store the user input as the variable: type
            // if user enters either a capital or lowercase Q, break the while loop
            if ("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine(); // store the user input as title
             //get an appropriate instance of the movie using the two parameters gathered
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie(); // runs the method to print movie details
        }

    }
}
