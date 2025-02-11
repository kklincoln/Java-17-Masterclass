package dev.lpa;

import java.util.Arrays;

public class PersonImmutable {
    /// imagine we are creating a genealogy program tracking people, names, birth dates, and kids.
    ///create fields with basic encapsulation techniques
/// updating these fields to final to meet immutability standards; implies no setter methods
    private final String name;
    private final String dob;
    protected final PersonImmutable[] kids;

    /// generate a constructor to make creating a person easier
    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        //defensive copy of the input as well, prevents the user from maintaining a reference to it and altering it later
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    // whether we've created a true immutable class? it depends. Say someone wants to create a subclass without consulting us, called LivingPerson
    // the person would create a new protected constructor and assign its fields to those values on the person instance passed to this constructor.
    protected PersonImmutable(PersonImmutable person){
        this(person.getName(), person.getDob(), person.getKids());
    }

    ///generate getters/setters. Removing setters for fields to protect the values after initialization
/// MAKE DEFENSIVE GETTERS, see getKids
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public final PersonImmutable[] getKids() {
        //returns copy of arrays if exits and called upon
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }



    ///generate a toString to print out the person data.
    @Override
    public String toString() {
        String kidString = "n/a";
        if (kids != null){//if kids exist, populate the kidString
            String[] names = new String[kids.length];
            //the names array is populated with the index from the kids array. if null, "", else kids[index].name
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + getDob() + ", kids = " + kidString;  //this getdob() allows subclasses to override
    }
}
