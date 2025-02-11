package dev.lpa.sealed;

import java.util.function.Predicate;

public sealed interface SealedInterface permits BetterInterface, StringChecker {

    ///method could be used to test some relationship between strings
    boolean testData(Predicate<String>p, String... strings );
}
