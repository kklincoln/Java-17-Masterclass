package dev.lpa;


import java.util.Arrays;

public interface Mappable {
    // one abstract method called render
    void render();

    // takes the String of latLong position and returns a double array
    static double[] stringToLatLon(String location){
    // takes the String from google maps, splits on comma, sets each = to the double value, stores them in a double array
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);
        return new double[]{lat, lng};
    }
}

////////////////////////////////
// CREATE AN ABSTRACT CLASS FOR POINT
abstract class Point implements Mappable{
    private double[] location = new double[2]; //implement a new double array with 2 elements (implemented from Mappable)

    public Point(String location){
        this.location = Mappable.stringToLatLon(location); // Use the static method on Mappable that turns String to double[]
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + locationToString() + ")"); // call location
    }

    private String locationToString(){
        return Arrays.toString(location); //returns the double[] defined above in the class
    }
}


////////////////////////////////
// CREATE AN ABSTRACT CLASS FOR LINE
abstract class Line implements Mappable{
    private double[][] locations; // array of the lat and lon doubles. (2-D array) representing all the points on the line

    // create a constructor that takes in a sequence of strings to be converted to the double[] pairs.
    public Line(String... locations){
        //instantiate locations field based on the number of Strings passed.
        this.locations = new double[locations.length][];
        // local var, index, which is the position in the array
        int index = 0;
        for (var l : locations){
            //for each String in the array, set locations using that index to what we get when using the Mappable method stringToLatLon
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

// override the method for render from Mappable
    @Override
    public void render() {
        System.out.println("Render " + this + " as Line " + locations() + ")"); // call the locations method
    }

    // return the string for the locations, simliar to the Point abstract class
    private String locations(){
        return Arrays.deepToString(locations); //deepToString because it's a multi-dimensional array being converted
    }

}

