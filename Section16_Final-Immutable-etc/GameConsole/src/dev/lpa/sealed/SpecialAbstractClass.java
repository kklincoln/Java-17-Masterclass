package dev.lpa.sealed;

///NOTE: do not need to include the Permits clause when all subclasses are nested classes
public sealed abstract class SpecialAbstractClass permits FinalKid,
        NonSealedKid, SealedKid, SpecialAbstractClass.Kid {

    ///before extending subclasses, creating a class Kid
    final class Kid extends SpecialAbstractClass{

    }


}
