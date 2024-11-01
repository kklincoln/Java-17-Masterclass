package dev.lpa.lambdaExpressions;

//this is a functional interface, one single abstract method, which can be verified by adding @FunctionalInterface
//good practice to include this; notifies devs of intention to use this interface for lambda expressions and not add new methods
@FunctionalInterface
public interface Operation<T> { //make it a generic interface with the use of type parameter <T> (any type)
//single abstract method, called operate that returns T and takes two values
    T operate(T value1, T  value2);
}
