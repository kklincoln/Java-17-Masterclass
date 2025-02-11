package dev.external;

import dev.lpa.PersonImmutable;

import java.util.Arrays;

public class LivingPerson extends PersonImmutable {

    /// generate constructors that call the super constructors with the same set of args
    public LivingPerson(String name, PersonImmutable[] kids) {
        //ability to add kids; add into new 10 element array, otherwise create array
        super(name, null, kids == null ? new PersonImmutable[10] :
                Arrays.copyOf(kids, 10));
    }

    public LivingPerson(PersonImmutable person) {
        super(person);
    }
    /// override getter for DOB
    @Override
    public String getDob() {
        return null;    // not to expose the dob
    }

    ///new method to consider adding a new person born or adopted
    public void addKid(PersonImmutable person){
        for (int i = 0; i < kids.length; i++){
            if (kids[i] == null){
                kids[i] = person;
                break;
            }
        }
    }

}
