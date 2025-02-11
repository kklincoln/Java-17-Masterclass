package consumer.specific;

import dev.lpa.generic.BaseClass;

public class ChildClass extends BaseClass {
    /// lets say the designer of the subclass reads specification and learns they should override the optionalMethod
    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod] EXTRA Stuff Added to @Override Method");
        super.optionalMethod();
    }

    /// visualizing what occurs when the designer doesn't refer to the dox indicating always using super to reference the method
    /// and instead replaces the whole codeline. This means that the BaseClass recommendedMethod doesn't run the mandatoryMethod()
/// **** prohibiting this change is done through the use of 'final' in the BaseClass
//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child:recommendedMethod]: I'll do things my way.");
//        optionalMethod();
//    }

    //although the method signature is the same as the one from the BaseClass, since the 'final' modifier has been added to the BaseClass, this is a separate method
    private void mandatoryMethod(){
        System.out.println("[Child:mandatoryMethod]: My own important stuff");
    }

    /// COMPARING INSTANCE v STATIC METHODS
    public static void recommendedStatic(){
        System.out.println("[Child:recommendedStatic] BEST way to do it");
        optionalStatic();
//        mandatoryStatic();  //private static method on the BaseClass, so it cannot be called on the subclass, or any class
    }


}
