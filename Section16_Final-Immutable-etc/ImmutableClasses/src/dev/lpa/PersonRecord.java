package dev.lpa;


import java.util.Arrays;

///solves a lot of the problems for designing an immutable object, but not all.
/// this will have the same three fields.
public record PersonRecord(String name, String dob, PersonRecord[] kids) {
    public PersonRecord(String name, String dob) {
        this(name, dob, new PersonRecord[20]);  //placeholder for 20 possible kids
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

    /// CREATE DEFENSIVE COPIES; add a getter picking kids field
    @Override
    public PersonRecord[] kids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }
}


