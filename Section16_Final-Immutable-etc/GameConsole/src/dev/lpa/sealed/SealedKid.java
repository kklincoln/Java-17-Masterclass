package dev.lpa.sealed;

public sealed class SealedKid extends SpecialAbstractClass{

    ///nested class instead of using the permits clause
    final class GrandKid extends SealedKid {

    }
}
