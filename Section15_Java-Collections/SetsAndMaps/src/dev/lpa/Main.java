package dev.lpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /// TESTING
        //CREATE A LIST OF CONTACTS
        List<Contact> emails =  ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Email List", emails);
        printData("Phone List", phones);

        /// Now imagine we want to merge these lists into a single record, merging any duplicates into a single contact
        Set<Contact> emailContacts = new HashSet<>(emails); //passes email list from above into HashSet
        Set<Contact> phoneContacts = new HashSet<>(phones); //passes phone list from above into HashSet
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        /// testing the addEmail method from Contact.
        int index = emails.indexOf(new Contact("Robin Hood")); // check the index of the emails list associated with a Robin Hood contact
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwood.forest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        /// UNION OF THE TWO SETS GENERATED IN LINES 18-19; note that a chunk of phone/emails will be lost with this approach
        Set<Contact> unionAB = new HashSet<>(); //a is emails b is phones
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A \u222A B) Union of emails (A) and phones (B)", unionAB);

        /// SET INTERSECTION: (EQUIVALENT OF AN INNER-JOIN)
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersect emails (A) and phones (B)", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B \u2229 A) Intersect phones(B) and emails (A)", intersectBA);

        /// ASYMMETRIC OPERATIONS: illustrates the differences of order of operations, subtraction
        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AminusB);

        Set<Contact> BminusA = new HashSet<>(phoneContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)", BminusA);

        ///  SYMMETRIC DIFFERENCES: the union of all sets that do not intersect
        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("Symmetric Difference: Phones and Emails", symmetricDiff);
                ///same as above
        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Difference: Phones and Emails", symmetricDiff2);
    }

    public static void printData (String header, Collection<Contact> contacts){
        System.out.println("------------------------------------------------------");
        System.out.println(header);
        System.out.println("------------------------------------------------------");
        contacts.forEach(System.out::println);
    }
}
