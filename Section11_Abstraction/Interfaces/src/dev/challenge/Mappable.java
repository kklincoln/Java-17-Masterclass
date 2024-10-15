package dev.challenge;

enum Color {//Color enum: constants associated to provide options for the colors of markers in the map
    BLACK, BLUE, GREEN, ORANGE, RED
}
enum Geometry{// Geometry: enum constants to be used as determinant of marker type on the map
    POINT, LINE, POLYGON
}
enum LineMarkers {//LineMarkers enum: constants to be used to indicate which types of markers are optional for the map
    DOTTED, DASHED, SOLID
}


public interface Mappable {
        //a constant string value called JSON_PROPERTY, equal to "properties":{%s} //public, static, and final
        String JSON_PROPERTY = """
                "properties" :{%s}""";

//forces classes to implement three methods
    //one method should return a label (how the item will be described on a map)
    String getLabel();

    //one returns a geometry type (POINT or LINE) which is what the type looks like on the map
    Geometry getShape();    //creates enum type: Geometry

    // last should return an icon type (map marker)
    String getMarker();


    //include a default method called toJSON() that prints out type, label, and marker
        default String toJSON(){
            return """
                    {"Type": "%s", "label": "%s", "marker": "%s" """
                    .formatted(getShape(), getLabel(), getMarker());
        }

        // static method that takes a Mappable instance as an arg; print our properties for each mappable type,
        // including those mentioned above, but also any other fields on the business classes
        static void mapIt(Mappable mappable) {
            //static method will first format the JSON_PROPERTY static string, the string to be replaced is the one we get back from the toJSON method
            System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
        }

}
