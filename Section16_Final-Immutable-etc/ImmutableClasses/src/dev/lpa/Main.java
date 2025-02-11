package dev.lpa;

public class Main {
    public static void main(String[] args) {
        /// imagine we are creating a genealogy program tracking people, names, birth dates, and kids.
//        Person jane = new Person();
//        jane.setName("Jane");
//        Person jim = new Person();
//        jim.setName("Jim");
//        Person joe = new Person();
//        joe.setName("Joe");
//        Person john = new Person(); //father of three kids above
//        john.setName("John");
//        john.setDob("05/05/1900");
//        john.setKids(new Person[]{jane, jim, joe});
//        System.out.println(john);
//
//        john.setName("Jacob");
//        john.setKids(new Person[]{new Person(), new Person()});
//        System.out.println(john);

        /// SUCCINCT CODE: use new constructors to create person instances, name and dob are now protected
        Person jane = new Person("Jane", "01/01/1930");
        Person jim = new Person("Jim", "02/02/1932");
        Person joe = new Person("Joe", "03/03/1934");

        Person[] johnsKids = {jane, jim, joe};
        Person john = new Person("John","05/05/1900",johnsKids);
        System.out.println(john);

        john.setKids(new Person[]{new Person("Ann", "04/04/1930")});
        System.out.println(john);

        Person[] kids = john.getKids();
        kids[0] = jim;  //you can reassign kids with this, important to note
        System.out.println(john);
        kids = null;    //cannot set the kids to null this way
        System.out.println(john);

        john.setKids(kids); ///passing the null variable; can only be done when calling the method on Person.
        System.out.println(john);   //returns kids = "n/a"

    }
}
