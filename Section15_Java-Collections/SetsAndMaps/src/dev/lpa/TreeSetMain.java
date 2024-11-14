package dev.lpa;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        ///RETRIEVE PHONE AND EMAIL LISTS FROM THE OTHER CLASS
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        ///NavigableSet is the most specific of the interfaces, bc we want to cover all methods unique to both SortedSet and NavigableSet
//        NavigableSet<Contact> sorted = new TreeSet<>(phones);   //doesn't work because elements must be sorted first
        //create a new comparator using Name to sort
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        // Create a NavigableSet for the phones list created above
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        //create another NavigableSet from the Contact.getName() from the phones List in line 11
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        // create another for the emails list in line 12
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        ///METHOD ON THE SORTEDSET INTERFACE THAT RETURNS THE COMPARATOR USED IN THE SET
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator()); // sort using the comparator from the Sorted set
        System.out.println("-".repeat(30));
        fullList.forEach(System.out::println);

        ///min and max for the set & first and Last
        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());
        //these methods give the same results as the ones on Collections, and are the preferred way to get data.
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println("-".repeat(30));
        System.out.printf("Min = %s, first=%s %n", min.getName(), first.getName());
        System.out.printf("Max = %s, last=%s %n", max.getName(), last.getName());
        System.out.println("-".repeat(30));

        /// demonstrating that the set methods pollFirst() and pollLast() are the same as the max/min and first/last above
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet); //duplicate the set from FullSet
        System.out.println("First Element = " + copiedSet.pollFirst());
        System.out.println("Last Element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(30));


        /// METHODS UNIQUE TO THE TREESET
//        the next set of methods identify the closest match in a Set to a value you’ve passed to the method.
        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy"); // would be last if inserted in the treeset
        Contact archie = new Contact("Archie");//would be first if inserted  in the treeset

        // LOOP THROUGH LIST OF CONTACTS USING UPPER LIMIT ceiling(), higher() methods
        //Ceiling returns Daffy, because you can think of ceiling as returning the element that is either greater than or
        // equal to the element passed, but the higher method never returns the value that’s equal to it in a Set,
        // it always returns the next greater element, which is why we get Linus.
        for (Contact c : List.of(daffy, daisy, last, snoopy)){
            System.out.printf("Ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("Higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("-".repeat(20));

        //REPEATING FOR THE LOWER LIST
        //Floor is similar to ceiling, it returns the element that’s equal to the argument passed if the element is in the set.
        // I get Daffy back for the first call to floor, but lower method returns the element just lower, Charlie Brown.
        for (Contact c : List.of(daffy, daisy, first, archie)){
            System.out.printf("Floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("Lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println("-".repeat(20));


        //Get a descending set by a method of that name on TreeSet
        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(20));

        //NOTE: any changes to the original Set (fullSet) will be reflected in this Set and vice versa
        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed" + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(20));
        fullSet.forEach(System.out::println);   // the lastContact removed from the descendingSet also was removed from original Set
        System.out.println("-".repeat(20));


        //we can also get subsets from the head (beginning) or tail (ending) of the SortedSet
            // returns the elements before Maid Marion
        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion);
        headSet.forEach(System.out::println);
        System.out.println("-".repeat(20));
            //returns the elements after, and including, Maid Marion
        var tailSet = fullSet.tailSet(marion);
        tailSet.forEach(System.out::println);
        System.out.println("-".repeat(20));


    }



}