package dev.lpa;

import java.util.*;

public class Main {

    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {
///Say we want to assign work days to different employees; set up the days they work

        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY,
                WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

///use a creational method (one that is responsible for creating & returning an instance of an object through a static factory method or other means)
        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName()); //get the name of the instance that we just created; RegularEnumSet
        annsDaysSet.forEach(System.out::println);   //prints in the ordinal value defined in the enum; advantage over using a HashSet with enum type
        //create a Set for all the enum values using allOf; printing all the days in the enum in order
        System.out.println("-".repeat(20));
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        allDaysSet.forEach(System.out::println);


///ComplementOf(); this is a difference of the full set of possible work days, less annsDaysSet
        System.out.println("-".repeat(20));
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        newPersonDays.forEach(System.out::println);
        ///can get the same result Set with the removeAll(), but the complementOf() was more simple
        System.out.println("-".repeat(20));
        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        anotherWay.forEach(System.out::println);

        ///Set of enum range
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(20));
        businessDays.forEach(System.out::println);


        ///enumMap; can use put, putAll, putIfAbsent, putIfPresent, replaceAll, retainAll, etc.
        //these are still ordered by Weekday without needing to use a SortedMap, nor inserting them in order;
        //more efficient and naturally ordered than a HashMap
        System.out.println("-".repeat(20));
        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"}); //add Friday's crew
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeeMap.forEach((k,v) -> System.out.println(k + ": " + Arrays.toString(v)));


        System.out.println("-".repeat(20));
    }
}
