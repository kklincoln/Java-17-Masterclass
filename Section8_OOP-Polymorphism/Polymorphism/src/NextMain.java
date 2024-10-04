public class NextMain {
    public static void main(String[] args) {
        //creating a variable with the Movie type, called movie
            //assigned the result of that static method call Movie.getMovie to that variable
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie(); // runs the method to print movie details

        // the only way we can change the variable type associated with the Adventure, is if we cast the Movie method as
        //Adventure. That's because the code getMovie that consideres type and title is not found in Adventure class
        Adventure jaws = (Adventure) Movie.getMovie("A","Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        // in order to not get the error on comedy.watchMovie(); since it's an object instance,
        Movie comedyMovie = (Movie) comedy;
        comedyMovie.watchMovie();


        //TYPE INFERENCE
        // since var was established as the return for the static method from the Movie class, JVM can infer that var is type Movie
        var airplane = Movie.getMovie("C","Airplane");
        airplane.watchMovie();
        //assigning a new instance. This has an easier time trying to infer which type the movie is, since we used new Comedy
        var plane = new Comedy("Airplane");
        plane.watchComedy();
        var jaws2 = new ScienceFiction("Jaws 2");
        jaws2.watchScienceFiction();
        System.out.println("_ _ _ _ _");


        //TESTING THE RUNTIME TYPE OF OBJECT
        Object unknownObject = Movie.getMovie("S", "Star Wars");
        if (unknownObject.getClass().getSimpleName() == "Comedy"){
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
            //second approach to verify instance type using instanceof
        }else if (unknownObject instanceof Adventure){
            // cast the unknownObject as an Adventure class and then call the method with method chaining
            ((Adventure) unknownObject).watchAdventure();
            // another approach, used in Java16+ called Pattern Matching for the instanceof operator
        }else if (unknownObject instanceof ScienceFiction syfy){
            syfy.watchScienceFiction(); //this approach removes the need to convert or cast the variable, it was done in ln40
        }
    }
}
