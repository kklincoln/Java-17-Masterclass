package dev.lpa;

public record Person(String name, String dob) {
    /// CANONICAL CONSTRUCTOR: Establishing a new constructor in the Person class
//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace("-","/");
//    }

    /// non-canonical record constructor must delegate to another constructor
    public Person(Person p) {
        this(p.name, p.dob);
    }

    /// COMPACT CONSTRUCTOR; this code gets inserted into the implicit canonical constructor before final fields are assigned
    public Person {
        //note: we can refer to constructor args that aren't explicitly declared by this compact constructor (name, dob)
        if (dob == null) throw new IllegalArgumentException("Bad data");
        dob = dob.replace("-","/");
    }
}
