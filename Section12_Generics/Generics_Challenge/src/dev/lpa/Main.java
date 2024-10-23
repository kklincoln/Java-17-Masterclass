package dev.lpa;

// your main method should create some instances of your specific classes that include some location data.
//these should get added to a typed Layer, and the renderLayer method called on that.
public class Main {
    public static void main(String[] args) {
        var nationalUSParks = new Park[]{
                new Park("Yosemite","37.8855,-119.5360"),
                new Park("Yellowstone", "44.4882,-110.5916"),
                new Park("Grand Canyon","36.1085,-112.0965")
        };

        //pass the Park[] previously created into the new Layer<> and render
        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new River[]{
                new River("Mississippi","47.2160, -95.2348", "35.1556, -90.0659", "29.1566, -89.2495"),
                new River("Missouri","45.9239, -111.4983","38.8146, -90.1218")
        };
        // pass the River[] previously created into a new layer and render
        Layer<River> riverLayer = new Layer<>(majorUSRivers);
        riverLayer.renderLayer();
    }

}
