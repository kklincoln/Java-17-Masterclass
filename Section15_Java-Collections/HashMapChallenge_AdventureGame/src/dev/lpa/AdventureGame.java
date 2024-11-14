package dev.lpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGame {
    ///text block containing board location data
    private static final String GAME_LOCATIONS  = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    /// COMPASS ENUM TO PROVIDE CONSTANTS FOR NAVIGATION
    private enum Compass {E, N, S, W;
        //method within the enum to provide directions
        private static final String[] directions = {"EAST", "NORTH", "SOUTH", "WEST"};

        // Return string associated with the enum; the ordinal method on enum, gives me it's placement in the constant's list.
        public String getString(){
            return directions[this.ordinal()];
        }
    }

    private record Location(String description, Map<Compass, String> nextPlaces){}

    ///TWO FIELDS FOR THE ADVENTURE GAME: Keep track of last location, HashMap for board locations
    private String lastPlace;
    private Map<String, Location> adventureMap = new HashMap<>(); //location records are the values associated with String Keys

    //generate constructors
    public AdventureGame() {
        this(null);
    }

    public AdventureGame(String customLocations) {
        //user should be able to pass custom location instructions to the constructor
        loadLocations(GAME_LOCATIONS);
        // if customLocations are passed, load them and replace defaults
        if (customLocations !=null){
            loadLocations(customLocations);
        }
    }

    private void loadLocations(String data){
        //parse board location data
        for (String s : data.split("\\R")) {// the \\R is a bit more robust than the \n
        //split the line into three parts, first and second comma; anything else after that as a single string
            String[] parts = s.split(",", 3);
            Arrays.asList(parts).replaceAll(String::trim);  //trim leading and trailing spaces
            Map<Compass, String> nextPlaces = loadDirections(parts[2]); // create a map using the loadDirections method and the directions data
            //create a new instance of the Location record, passing the second delimited string
            Location location = new Location(parts[1], nextPlaces);
            adventureMap.put(parts[0], location);
        }
//        adventureMap.forEach((k,v) -> System.out.printf("%s:%s%n", k, v));
    }

    private Map<Compass, String> loadDirections(String nextPlaces){
        // set up a local variable that has the same type as return type of this method
        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps = Arrays.asList((nextPlaces.split(","))); //split the third segment of data by commas

        nextSteps.replaceAll(String::trim);
        //loop through each delimited string
        for (String nextPlace : nextSteps){
            String[] splits = nextPlace.split(":");
            Compass compass = Compass.valueOf(splits[0].trim()); //trim and generate a matching Compass constant
            String destination = splits[1].trim();
            directions.put(compass, destination);    //add the data into the Map; all the possible ways a player can pick to move to a new location
        }

        return directions;
    }


    ///VISIT METHOD: print info about player's current location and where you can go next
    private void visit(Location location){
        System.out.printf("*** You're standing %s *** %n", location.description);
        //what options can the player pick from?
        System.out.println("\tFrom here, you can see:");
        location.nextPlaces.forEach((k,v) -> {
            System.out.printf("\t- A %s to the %s (%S) %n", v, k.getString(), k);
        });

        System.out.print("Select Your Compass (Q to Quit) >> ");
    }

    /// LET THE PLAYER MOVE BASED ON THE DIRECTION CHOSEN
    public void move(String direction){
        var nextPlaces = adventureMap.get(lastPlace).nextPlaces;
        String nextPlace = null;
        if ("ESNW".contains(direction)){// if the direction passed is valid, move in that direction
            nextPlace = nextPlaces.get(Compass.valueOf(direction));
            if(nextPlace != null){
                play(nextPlace);    //move to the next place
            }
        }else{
            System.out.println("!! Invalid direction, try again!!");
        }
    }

    /// PLAY METHOD: starts the game and processes the next moves
    public void play(String location){
        if (adventureMap.containsKey(location)){//make sure the passed location is a valid location
            Location next = adventureMap.get(location); //store next location in a variable
            lastPlace = location;   //current location logged
            visit(next);

        }else{
            System.out.print(location + " is not a valid location, please try again!");
        }
    }
}
