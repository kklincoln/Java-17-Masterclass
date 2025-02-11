package dev.lpa;

import java.time.LocalDate;

public enum Generation {
    /// ESTABLISH CONSTANTS
    /// since we know that each constant is really a Generation class, we can include a class body for each
    GEN_Z(){ //called with the no args constructor
        ///INSTANCE INITIALIZER; wrap inside another set of curly braces so you're not inserting code into a class body (not allowed)
        {
            System.out.println("-- SPECIAL FOR " + this + " --");
        }
    },
    MILLENNIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);

    /// adding new fields to be populated by the constructor; wont be a need to change these declaration statements so 'final'
    private final int startYear;
    private final int endYear;


    /// recreate no-args constructor
    Generation() {
        this(2001, LocalDate.now().getYear());
    }

    /// GENERATE A CONSTRUCTOR; Note: semicolon added to end of constants above; implicitly private
    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println(this);
    }

    /// generated toString
    @Override
    public String toString() {
        return this.name() + " " + startYear + " - " + endYear;
    }
}
