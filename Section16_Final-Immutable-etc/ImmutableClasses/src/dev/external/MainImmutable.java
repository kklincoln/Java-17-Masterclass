package dev.external;

import dev.hacker.PersonOfInterest;
import dev.lpa.PersonImmutable;

public class MainImmutable {
    public static void main(String[] args) {
        ///create the new Record of PersonImmutable
        /// SUCCINCT CODE: use new constructors to create person instances, name and dob are now protected
        PersonImmutable jane = new PersonImmutable("Jane", "01/01/1930");
        PersonImmutable jim = new PersonImmutable("Jim", "02/02/1932");
        PersonImmutable joe = new PersonImmutable("Joe", "03/03/1934");

        PersonImmutable[] johnsKids = {jane, jim, joe};
        PersonImmutable john = new PersonImmutable("John","05/05/1900",johnsKids);
        System.out.println(john);

        PersonImmutable[] kids = john.getKids();
        kids[0] = jim;
        kids[1] = new PersonImmutable("Ann", "04/04/1936");
        System.out.println(john);

//        Note: You cant use a Record and prevent side effects without implementing some defensive measures. A record satisfies several of the requirements for an immutable class design.
//        It uses private final instance fields
//        It has a constructor to set the data
//        It doesnt have any setters
//        BUT It’s not creating defensive copies..
        ///after adding this new defensive copy implementation
        johnsKids[0] = new PersonImmutable("Ann", "04/04/1936");   // this allows you to change the array variable used to construct the record.
        System.out.println(john);

        /// the MainImmutable demonstrates that the instances of the class PersonImmutable were not able to be altered by any of the code within
        /// this source code. It didn't matter if we changed the variable johnsKids afterward or assigned a local variable to it.
        /// using defensive copies in the constructor and the getter has protected my array of kids on this class from side effects.
        // whether we've created a true immutable class? it depends. Say someone wants to create a subclass without consulting us, called LivingPerson
        // the person would create a new protected constructor and assign its fields to those values on the person instance passed to this constructor.

        LivingPerson johnLiving = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLiving);

        //testing code to addKid
        LivingPerson anne = new LivingPerson("Anne", null);
        johnLiving.addKid(anne);
        System.out.println(johnLiving);

        //subclass getting access to the super.kids field from the new subclass: PersonOfInterest
        PersonOfInterest johnCopy = new PersonOfInterest(john);
        System.out.println(johnCopy);   //has all the same data as john the original, as expected

        kids = johnCopy.getKids();
        kids[1] = anne;
        System.out.println(johnCopy);
        System.out.println(john);   // chaining the constructors in the PersonImmutable class protects the original instance

    }
}
