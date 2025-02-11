package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {

    public static void main(String[] args) {
        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D.", "Carol Jones",
                "Ed Green Ph.D.", "Ed Green M.D.", "Ed Black"};

        //create a local variable
        List<StringBuilder> population = getNames(names);   //will generate a long list with a lot of duplicates
        //create a Map of counts of duplicate names; treemap auto sorted, Big O(Log n)
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);   //add new name with value of 1 if not in map; else increment the value already there
        });
        System.out.println(counts);

        /// set up a stringbuilder variable to refer to Ann Jones PhD for use to search how many there are within counts Map
        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);

        /// cleaned names output
        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd); //returns Null
        System.out.println(counts); // returns counts of names in the Map without the suffixes, but there are duplicates of the names

        StringBuilder annJones = new StringBuilder("Ann Jones");
        System.out.println("There are " + counts.get(annJones) + " records for " + annJones);// this only counts ONE of the Ann Jones map entries
        System.out.println("-".repeat(20));
        counts.forEach((k,v) -> System.out.println(k + " : " + v)); // this gets all of the keys with respective counts
        System.out.println("-".repeat(20));
        counts.keySet().forEach(k -> System.out.println(k + " : " + counts.get(k)));



    }


    /// private static method that creates a random list of names from the names array
    private static List<StringBuilder> getNames(String[] names){
        List<StringBuilder> list = new ArrayList<>();
        int index = 3; // how many names to add to the list for each distinct name

        for (String name : names){
            for (int i =0; i < index; i++){
                list.add(new StringBuilder(name));
            }
            index++;    // different number of names for each name in the array
        }
        return list;
    }

    ///say it's our job to mail a flier to this population, remove suffixes for privacy.
    private static List<StringBuilder> standardizeNames(List<StringBuilder> list){
        List<StringBuilder> newList = new ArrayList<>();
        //loop through the names passed as method argument
        for (var name : list){
            // loop through possible suffixes from a new String[] of suffixes
            for (String suffix : new String[] { "Ph.D.", "M.D."}){
                int startIndex = -1;
                //set the startIndex = the indexOf from the name above
                if ((startIndex = name.indexOf(suffix)) > -1){
                    //if exists, replace the suffix with empty string
                    name.replace(startIndex - 1, startIndex + suffix.length(), "");
                }
            }
            newList.add(name);  //add to the newList
        }
        return newList;
    }

}
