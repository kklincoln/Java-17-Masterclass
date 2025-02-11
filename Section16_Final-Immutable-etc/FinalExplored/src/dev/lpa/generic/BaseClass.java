package dev.lpa.generic;

public class BaseClass {
    /// write a library class, should be extensible, but not everything should be customizable

    ///three methods: control workflow, expected to always be called
    public final void recommendedMethod(){
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    /// protected, meaning that only classes that can call it are subclasses, or classes in the same package as this class.
    protected void optionalMethod(){
        System.out.println("[BaseClass.optionalMethod]: Customize Optional Method");
    }

    /// private; subclasses shouldn't alter or override this code.
    private void mandatoryMethod(){
        System.out.println("[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!");
    }


    /// COMPARING INSTANCE v STATIC METHODS
    public static void recommendedStatic(){
        System.out.println("[BaseClass:recommendedStatic] BEST way to do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic(){
        System.out.println("[BaseClass:optionalStatic]: Optional");
    }

    private static void mandatoryStatic(){
        System.out.println("[BaseClass:mandatoryStatic]: MANDATORY");
    }

}
