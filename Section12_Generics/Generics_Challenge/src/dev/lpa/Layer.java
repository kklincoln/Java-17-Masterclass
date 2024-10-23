package dev.lpa;

import java.util.ArrayList;
import java.util.List;

//Create a generic class called layer.
//Your layer class should have one type parameter, and should only allow Mappable elements as that type
public class Layer<T extends Mappable> {// can use methods on Mappable without casting
    //This generic class should have a single private field, a list of elements to be mapped.
    private List<T> layerElements;

    //GENERATE A CONSTRUCTOR THAT INCLUDES layerElements//This class should have a method or constructor, or both, to add elements.
    public Layer(T[] layerElements) {
        // lets calling code pass an array to create a new Layer
        this.layerElements = new ArrayList<T>(List.of(layerElements));
    }

    public void addElements(T... elements){//expect args of type T called elements
        // add to the List<T> declared above, a list of elements
        layerElements.addAll(List.of(elements));
    }

//you should create a method, called renderLayer, that loops through all elements and executes the method render on each element
    public void renderLayer(){
        for (T element : layerElements){    //since the T extends Mappable, we can call the render() method on T parameter
            element.render();
        }
    }

}
