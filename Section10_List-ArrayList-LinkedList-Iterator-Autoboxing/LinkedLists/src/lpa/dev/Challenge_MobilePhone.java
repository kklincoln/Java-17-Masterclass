package lpa.dev;
import java.util.ArrayList;

public class Challenge_MobilePhone {

//    """
//    mobile phone file below
//"""


    // Implement the master class MobilePhone, that holds the ArrayList of Contacts, with the following attributes:
        // -  Two fields, a String called myNumber and an ArrayList of type Contact called myContacts.
        private String myNumber;
        private ArrayList<Contact> myContacts;

        // -  A constructor that takes a String (the phone number) and initialises myNumber and instantiates myContacts.
        public Challenge_MobilePhone(String myNumber) {
            this.myNumber = myNumber;
            this.myContacts = new ArrayList<Contact>();
        }


        //And seven methods, they are (their functions are in their names): TIP:  In MobilePhone, use findContact() in the other methods (except printContacts()) to check if it exists before proceeding. TIP:  Two Contact objects are equal if they have the same name. TIP:  Be extremely careful about spaces in the printed message.
        //  addNewContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact doesn't exists, or false if the contact already exists.
        public boolean addNewContact(Contact contact){
            if (findContact(contact.getName()) >= 0){
                System.out.println("Contact is already on file.");
                return false; // return false if the contact already exists
            }
            myContacts.add(contact);
            return true;
        }


        // -  updateContact(), has two parameters of type Contact (the old contact that will be updated with the new contact) and returns a boolean. Returns true if the contact exists and was updated successfully, or false if the contact doesn't exists.
        public boolean updateContact(Contact oldContact, Contact newContact) {
            int foundPosition = findContact(oldContact);
            if (foundPosition < 0) { // if the oldContact doesn't exist return false
                System.out.println(oldContact.getName() + ", was not found.");
                return false;
            } else if (findContact(newContact.getName()) != -1) { //make sure the new contact doesn't exist already
                System.out.println("Contact with name " + newContact.getName() +
                        " already exists.  Update was not successful.");
                return false;
            }
            this.myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
            return true;
        }


        // -  removeContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact exists and was removed successfully, or false if the contact doesn't exists.
        public boolean removeContact(Contact contact){
            int position = findContact(contact); //search for contact
            if(position >= 0){ //remove if index exists
                myContacts.remove(contact);
                return true;
            }
            return false; //contact did not exist, cannot remove
        }


        // -  findContact(), has one parameter of type Contact and returns an int. The returned value is it's position in the ArrayList, it will either be -1 (doesn't exists) or a value greater than or equal to 0 (does exists).
        private int findContact(Contact newContact){
            return myContacts.indexOf(newContact);
        }

        // -  findContact(), same as above, only it has one parameter of type String.
        private int findContact(String name) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equals(name)) { //loop through myContacts by index, getName at each index; if matching the input String, return index
                    return i;
                }
            }
            return -1;
        }


        // -  queryContact(), has one parameter of type String and returns a Contact. Use the String to search for the name and then return the Contact. Return null otherwise.
        public Contact queryContact(String name){
            int position = findContact(name);
            if (position >= 0){ //if searching for contacts returns an index, get the contact
                return this.myContacts.get(position);
            }
            return null; //otherwise return null
        }



        // -  printContacts(), has no parameters and doesn't return anything. Print the contacts in the following format:
        // Contact List:
        // 1. Bob -> 31415926
        // 2. Alice -> 16180339
        // 3. Tom -> 11235813
        // 4. Jane -> 23571113
        public void printContacts(){
            System.out.println("Contact list:");
            for (int i = 0; i < myContacts.size(); i++){
                System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber() );
            }
        }

    public class Contact {
        // 2. Implement the Contact class with the following attributes:
        // -  Two fields, both String, one called name and the other phoneNumber.
        private String name;
        private String phoneNumber;


        // -  A constructor that takes two Strings, and initialises name and phoneNumber.
        public Contact(String name, String phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // -  And Three methods, they are:
        //     -  getName(), getter for name.
        public String getName(){
            return name;
        }

        //     -  getPhoneNumber(), getter for phoneNumber.
        public String getPhoneNumber(){
            return phoneNumber;
        }

        //     -  createContact(), has two parameters of type String (the persons name and phone number) and returns an instance of Contact. This is the only method that is static.
        public Contact createContact(String name, String phoneNumber) {
            return new Contact(name, phoneNumber);
        }
    }


    }

//"""
//contact.java file below
//"""


