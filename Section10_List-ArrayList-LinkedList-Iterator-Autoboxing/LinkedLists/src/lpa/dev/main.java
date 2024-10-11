package lpa.dev;

import java.util.LinkedList;
import java.util.ListIterator;

public class main {
    public static void main(String[] args) {

//      create a LinkedList of places to visit; like an Array list we include the type parameter, String in teh declaration
//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra"); //overloaded add method (positioning)
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit); //more efficient than the first approach, since you don't need to call the previous index 2x
//        printItinerary3(placesToVisit); //more efficient than the second approach, not using for loop, using iterator

        testIterator(placesToVisit);
    }

    public static void addMoreElements(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");
        //queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        //Stack methods
        list.push("Alice Springs"); //push to the start of the stack
    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");

        //no arg remove methods
        System.out.println(list);
        String s1 = list.remove(); //removes the first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); //removes the first element, but a bit clearer for readability
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); //removes the last element
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed"); //removes the first element
        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed"); //removes the first element, with better readability
        String p3 = list.pollLast();
        System.out.println(p3 + " was removed"); //removes the last element

        // Stack methods; push is pushing all the elements downward into the stack
        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop(); // removes the first element
        System.out.println(p4 + " was removed");
    }

//retrieving elements from a LinkedList
    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieved element = " + list.get(4));
//get method is on ArrayList and LinkedList; however on ArrayList the Big O Notation is O(1) at its worst
//  whereas LinkedList is at O(n). Since it's a double-ended queue java will decide where to start searching. The retrieval will
//start moving from one link to the next, either from start or end of the list, whichever is closer to the specified index
        System.out.println("First element = " + list.getFirst());
        System.out.println("Last element = " + list.getLast());

        //indexOf to see if an element is in the list
        System.out.println("Index for Sydney =" + list.indexOf("Sydney"));
        list.add("Sydney");
        System.out.println("Index of last instance of sydney = " + list.lastIndexOf("Sydney"));

        // Queue retrieval methods
        System.out.println("Element from element()" + list.element()); //gets the first element from the list
        //Stack retrieval methods
        System.out.println("Element from peek() " + list.peek()); // gets the first element
        System.out.println("Element from peekFirst() " + list.peekFirst()); // gets the first element, readability
        System.out.println("Element from peekLast()" + list.peekLast()); //gets the last element
    }

//TRAVERSE AND MANIPULATE ELEMENTS IN THE LIST
    public static void printItinerary(LinkedList<String> list)  {
        System.out.println("Trip starts at " + list.getFirst());
        //add a loop to get the places that are inbetween
        for (int i = 1; i < list.size(); i++){
            System.out.println("--> FROM: " + list.get(i - 1) + " to " + list.get(i));

        }
        System.out.println("Trip ends at " + list.getLast());
    }
    // better approach so we dont need to call the list twice for each index
    public static void printItinerary2(LinkedList<String> list)  {
        System.out.println("Trip starts at " + list.getFirst());
        //add a loop to get the places that are inbetween
        String previousTown = list.getFirst();
        for (String town : list){
            System.out.println("--> FROM: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    //third approach without using a for loop
    public static void printItinerary3(LinkedList<String> list)  {
        System.out.println("Trip starts at " + list.getFirst());
        //add a loop to get the places that are inbetween
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1); //overload at index 1 to avoid the repeat of line 1
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> FROM: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    // TEST ITERATOR TO INVESTIGATE ITERATOR FUNCIONALITY
    private static void testIterator(LinkedList<String> list){
        var iterator = list.listIterator(); //using the listIterator for added functionality: add, set.
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            //add code to remove all instances of a certain element, there may be duplicates
            if (iterator.next().equals("Brisbane")){
//                iterator.remove(); //remove it
                iterator.add("Lake Wivenhoe"); //adds a new destination after Brisbane;
            }
        }
    //if you wanted to loop through the elements again, you couldn't use the same iterator instance, it's already after the last element
//        while(iterator.hasNext()){
        while(iterator.hasPrevious()){// will need to iterate backwards instead
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3); //prints the element of index 3
        System.out.println(iterator2.next());

    }

}
