package dev.challenge;

////UsageType enum: constants to indicate the types of buildings present in the map
enum UsageType {
    ENTERTAINMENT, GOVERNMENT, SPORTS, HOSPITAL, GROCERY, RESTAURANT, RESIDENTIAL, WAREHOUSE, PARKING_GARAGE
}

public class Building implements Mappable {
    private String name;
    private UsageType usage;


    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }


    @Override
    public String getLabel() {
        return this.name + " (" + this.usage + ") ";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (this.usage){
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarkers.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarkers.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarkers.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointMarkers.PUSH_PIN;
            default -> Color.BLACK + " " + PointMarkers.CIRCLE;
        };
    }

    //override the toJSON Method; include the name and usage attributes
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name":"%s", "usage":"%s" """.formatted(this.name, this.usage);
    }
}
