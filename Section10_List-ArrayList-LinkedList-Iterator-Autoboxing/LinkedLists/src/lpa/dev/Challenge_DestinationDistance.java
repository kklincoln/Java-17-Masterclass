//first, create a type that has a field for a town or place name and a field for storing distance from starting pt
//use a listiterator to move backward and forward through the ordered itineary of places
//create an itinterary of places or towns to visit, but this tume instead of strings, create a LinkedList of your place or town
//here, I show a list of a few places in Australia and their distances from sydney
// you'll create a linkedList ordered by the distance from the starting point (Sydney) which is the first element in the list
//do not allow duplicates
//use a scanner and nextline method to get input from the console
//use a listiterator to move forward and backward through the list of places in the itinerary

package lpa.dev;

import java.util.LinkedList;
import java.util.Scanner;

//record to establish the table constructor
record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance); //change the format of the print toString method to name(distance)
    }
}

public class Challenge_DestinationDistance {
    public static void main(String[] args) {
        //create a LinkedList of the records; LinkedList<Place> placesToVisit
        LinkedList<Place> placesToVisit = new LinkedList<>();

        //Add places
        Place adelaide = new Place("Adelaide", 1374); //create place
        addPlace(placesToVisit,adelaide); //add the place to the LinkedList
//        addPlace(placesToVisit, new Place("adelaide", 1374)); //testing duplicate addition
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));

        placesToVisit.addFirst(new Place("Sydney", 0)); //confirm that Sydney is added as the first destination
        System.out.println(placesToVisit);

        // create an instance of iterator to navigate through the list
        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true; //boolean to note direction of iterator
        printMenu();
        while (!quitLoop) {
            if(!iterator.hasPrevious()){//if at start of the list, print the next element
                System.out.println("Originating : " + iterator.next());
                forward=true;
            }
            if(!iterator.hasNext()){ //if at end of the list, print the previous element
                System.out.println("Final : " + iterator.hasPrevious());
                forward=false;
            }

            System.out.println("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);
            // switch cases to be created for any of the scenarios that the user selects
            switch(menuItem){//scan console for user input of first letter or whole word
                case "F" -> {
                    System.out.println("User wants to go forward");
                    if(!forward){//if user isn't already going forward, change their direction to prevent duplicate element print
                        forward= true;
                        if(iterator.hasNext()){
                            iterator.next();}
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                }
                case "B"-> {
                    System.out.println("User wants to go backward");
                    if(forward){//if user isn't already going forward, change their direction to prevent duplicate element print
                        forward= false;
                        if(iterator.hasPrevious()){
                            iterator.previous();}
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                }
                case "L"-> System.out.println(placesToVisit);
                case "M" -> printMenu();
                case "Q" -> System.exit(0); //exit, return code 0
                default -> quitLoop = true; //switcch the flag so that the loop ends
            }
        }
    }

    //method to print the prompt; code cleanliness
    public static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");
    }

    //method to add a Place record to the LinkedList of places
    public static void addPlace(LinkedList<Place> list, Place place){
        //if the place already exists in the list, do not add; else add
        if (list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }
        for (Place p : list){ //loop through the list, if element from list = newPlace from argument, do not add
            if (p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }

        int matchedIndex =0;
        for (var listPlace : list){
            //if the distance of place we want to add to the list is closer than the currently looped element,
            if(place.distance() < listPlace.distance()){
                list.add(matchedIndex,place);// add place at the matchedIndex
                return;
            }
            matchedIndex++;
        }

        list.add(place);
    }

}
