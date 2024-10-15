package dev.challenge;

// UtilityType: enum constants to be used as determinant of Utility for line on map
enum UtilityType {
    ELECTRICAL, FIBER_OPTIC, GAS, WATER, WASTE_MANAGEMENT
}

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getLabel() {
        return this.name + " (" + this.type + ") ";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (this.type){
            case ELECTRICAL -> Color.RED + " " + LineMarkers.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarkers.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarkers.SOLID;
            case WATER -> Color.BLUE + " " + LineMarkers.SOLID;
            default -> Color.BLACK + " " + LineMarkers.SOLID;
        };
    }



    //override the toJSON Method; include the name and usage attributes
    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name":"%s", "utility":"%s" """.formatted(this.name, this.type  );
    }

}
