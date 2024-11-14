package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        /// get list of phone and email contacts, creating a combined list
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        /// create a full list starting from the phones list and addAll from emails, print using lambda function
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(20));

        /// create first map, HashMap, which requires two arguments to be specified, key and value(collection element)
        //note: the elements aren't in any particular order, no duplicates of key/value.
        Map<String, Contact> contacts = new HashMap<>();   //contact name String, value type Contact record

        for (Contact contact : fullList){
            //note: the Map.put() method adds kv pairs where non-existent, replaces where they are; the last element in list remains
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value=" + v));

        System.out.println("-".repeat(20));
        System.out.println(contacts.get("Charlie Brown"));  // get method allows you to call the Map with the Key to return Value

        // the get method returns null when there are no values associated with desired key, but you can establish a default record
        // to avoid any downstream null reference errors. Note: it's not added to the map, it's just there as a convenience
        Contact defaultContact = new Contact("Chuck Brown");
        System.out.print(contacts.getOrDefault("Chuck Brown", defaultContact));

        /// merge the duplicate values associated with each Key
        System.out.println("-".repeat(20));
        contacts.clear();
        for (Contact contact : fullList){
            //assign the store of the return value of the put method to the variable: duplicate
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null){ //if there's additional records to be added for the key, print as the duplicate output below
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
            //Objective is to merge contacts
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value=" + v));

        ///if we didn't actually want to replace the value with each call to put
        System.out.println("-".repeat(20));
        contacts.clear();
        for (Contact contact : fullList){
            //uses putIfAbsent instead; this will maintain the first record added to the list, rather than the Maps associated with them.
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value=" + v));


        System.out.println("-".repeat(20));
        contacts.clear();
        for (Contact contact : fullList){
            //assign the putIfAbsent values into a local variable; adds the duplicate as a mergeContactData() call
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null){
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value=" + v));

        /// merges the contact after providing output indicating the pre and post update script
        System.out.println("-".repeat(20));
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(),contact,
                Contact::mergeContactData));
        //merge output here
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value= " + v));


        /// demonstrating the contacts.compute() method
        System.out.println("-".repeat(20));
        //loop through array of names, adding a new Contact record for each name in array
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            //contacts.compute() will replace the data that exists in the map already
            //computeIfAbsent() will only add new element data if there doesn't exist any currently
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }
        // print out all contacts
        contacts.forEach((k,v) -> System.out.println("key= " +k + ", Value= " + v));

        //USE COMPUTEIFPRESENT()
        System.out.println("-".repeat(20));
        //loop through array of names, adding a new Contact email record for each name in array
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfPresent(contactName, (k,v) ->{
                v.addEmail("Fun Place"); return v; });
        }
        // print out all contacts
        contacts.forEach((k,v) -> System.out.println("key= " +k + ", Value= " + v));

        ///code to replace the issue with the above code in which Daisy and Daffy duck end up with the same email address
        System.out.println("-".repeat(20));
        contacts.replaceAll((k,v) ->{
            String newEmail = k.replaceAll(" ","") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com",newEmail);
            return v;
        });
        contacts.forEach((k,v) -> System.out.println("Key=" + k + ", value= " +v));
            ///alternative to the above, in which you ONLY replace the two affected rows rather than using the replaceAll()
            ///takes a Key and returns the value that was removed; null if value doesn't exist for that key
        System.out.println("-".repeat(20));
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k,v) -> System.out.println("Key= " +k + ", value= " +v));
            ///replace values in the map ONLY if BOTH the keys and values match
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        //test to see if both the replaced contact and updatedDaisy match on key
        boolean success = contacts.replace("Daisy Duck", daisy, updatedDaisy); //not replacedContact, updatedDaisy
        if (success){
            System.out.println("Successfully replaced element");
        } else{
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k,v) -> System.out.println("Key= " +k + ", value= " +v));

        ///
        System.out.println("-".repeat(20));
        success = contacts.remove("Daisy Duck", daisy); //daisy = "Daisy Jane Duck"
        if (success){ //returns false because the value in the map is Daisy Duck
            System.out.println("Successfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", daisy));
        }
        contacts.forEach((k,v) -> System.out.println("Key= " + k + ", value= " + v));

    }

}
