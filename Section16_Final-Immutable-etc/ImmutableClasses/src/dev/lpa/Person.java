package dev.lpa;

import java.util.Arrays;

public class Person {
    /// imagine we are creating a genealogy program tracking people, names, birth dates, and kids.
    ///create fields with basic encapsulation techniques
    private String name;
    private String dob;
    private Person[] kids;

    /// generate a constructor to make creating a person easier
    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    ///generate getters/setters. Removing setters for fields to protect the values after initialization
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Person[] getKids() {
        return kids;
    }
    public void setKids(Person[] kids) {
        this.kids = kids;
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
        return name + ", dob = " + dob + ", kids = " + kidString;
    }
}
