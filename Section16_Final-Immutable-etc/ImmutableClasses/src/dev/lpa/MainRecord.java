package dev.lpa;

public class MainRecord {
    public static void main(String[] args) {
        ///create the new Record of PersonRecord
        /// SUCCINCT CODE: use new constructors to create person instances, name and dob are now protected
        PersonRecord jane = new PersonRecord("Jane", "01/01/1930");
        PersonRecord jim = new PersonRecord("Jim", "02/02/1932");
        PersonRecord joe = new PersonRecord("Joe", "03/03/1934");

        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John","05/05/1900",johnsKids);
        System.out.println(john);

        //compare without the kids
        PersonRecord johnCopy = new PersonRecord("John", "05/05/1900");
        System.out.println(johnCopy);   //prints out 19 commas
            //add two kids to the johnCopy kids array
        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(johnCopy);

//        Note: You cant use a Record and prevent side effects without implementing some defensive measures. A record satisfies several of the requirements for an immutable class design.
//        It uses private final instance fields
//        It has a constructor to set the data
//        It doesnt have any setters
//        BUT It’s not creating defensive copies..
        ///after adding this new defensive copy implementation
        johnsKids[0] = new PersonRecord("Ann", "04/04/1936");   // this allows you to change the array variable used to construct the record.
        System.out.println(john);


    }
}
