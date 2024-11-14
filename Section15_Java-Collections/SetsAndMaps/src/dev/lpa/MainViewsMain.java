package dev.lpa;

import java.util.*;

public class MainViewsMain {
    public static void main(String[] args) {
        ///generate a new map with the phone and email contact data
        Map<String, Contact> contacts = new HashMap<>();
        // from contactData get the phone data and for each contact store in the Map as Key Value pair
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(),c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(),c));

///KEYSET: Map's View Collection
        ///get value of keys with keySet method on the Map
        //keySet returns a set, so you only need one Type arg declaration, type of the key
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);
    ///You can see the keys printed in no particular order, if using a constructor, we would get a copy of the keys not a view. (shown below)
        //pass the result of the contacts.keySet() to the TreeSet constructor, this will give keys in alphabetical order
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        /// LOOKUP KEYS WITH containsKey : see if element exists by key
        if (contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus and I go way back, so of course I have info");
        }
        System.out.println("-".repeat(10));
        /// REMOVING ELEMENT: THIS REMOVES IT FROM BOTH THE SET AND MAP
        keysView.remove("Daffy Duck");
        System.out.println(keysView); // print keysView Set
        contacts.forEach((k,v) -> System.out.println("Key= " + k + ", value= " +v));// print contacts Map
        System.out.println("-".repeat(10));
        /// THIS REMOVES IT FROM JUST COPY SET, NO AFFECT ON ORIGINAL MAP
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys); // print keysView Set
        contacts.forEach((k,v) -> System.out.println("Key= " + k + ", value= " +v));// print contacts Map
        System.out.println("-".repeat(10));
        ///RETAINALL: REMOVES ALL EXCEPT ...
        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView); // print keysView Set
        contacts.forEach((k,v) -> System.out.println("Key= " + k + ", value= " +v));// print contacts Map

        ///DEMONSTRATING THE SET REFLECTING THE UNDERLYING MAP DATA
        System.out.println("-".repeat(20));
        keysView.clear();
        System.out.println(contacts);   // this map is now empty: {}
//        keysView.add("Daffy Duck"); // cannot use add() because adding just the key is only part of the operation
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c)); // add each of the contacts from contactData into kv pair
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysView);   //view is auto refreshed since the Map underlying was repopulated

///Values: Map's View Collection
        var values = contacts.values();
        values.forEach(System.out::println);
        //retainAll() on the values collection
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));


        /// GENERATE A NEW LIST TO POPULATE THE OUTPUT OF THE DATA AS OUTLINED BELOW
        System.out.println("-".repeat(20));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst)); //sort using the method to get lastname
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));


        /// inputting a new contact element to demonstrate the difference between the
        System.out.println("-".repeat(20));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(),first);//use the lastname method as the key, passing first as the value
        values.forEach(System.out::println);    // print values collection view
        keysView.forEach(System.out::println);//print the keys in the keysview
            //this output has two Daffy Duck keys, because Daffy Duck is different than Duck, Daffy


        /// can also pass the values into a HashSet which also takes a collection as an argument to the constructor
        System.out.println("-".repeat(20));
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()){
            System.out.println("Duplicate Values are in my Map");
        }


/// ENTRYSET: final view collection
        var nodeSet = contacts.entrySet();  //this type is a Set of Map.Entry, type String, value is Contact
        //on any node or map.entry instance, theres a getkey and getvalue method which return the key val pair of the node
        for (var node : nodeSet){
            System.out.println(nodeSet.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){//compare the key with the value's name field
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " + node.getKey() + ": " + node.getValue());
            }
        }



    }
}
