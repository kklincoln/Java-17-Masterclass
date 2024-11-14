package dev.lpa;

import java.time.LocalDate;
import java.util.*;

public class Main {
///     set up maps
    /// treemap stores the keys in a sorted order, natural order.   O(log n) time complexity due to sorting Red-Black tree structure
    /// linkedHashMap maintains insertion order         O(1) time complexity, only extra cost is maintaining the linked list for insertion order
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>(); //tre



///     main method
    public static void main(String[] args) {
        //create courses: record Course(String courseId, String name, String subject)
        Course jmc = new Course("jmc101","Java Master Class", "Java");
        Course python = new Course("pyt101","Python Master Class", "Python");

        //create purchases: private static void addPurchase(String name, Course course, double price)
        addPurchase("Mary Martin",jmc,129.99);
        addPurchase("Andy Martin",jmc,139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        addPurchase("Chuck Cheese",python,119.99);
        addPurchase("Davy Jones",jmc,139.99);
        addPurchase("Eva East", python, 149.99);
        addPurchase("Fred Forker ", jmc, 139.99);
        addPurchase("Greg Brady", python, 129.99);

        purchases.forEach((key,value) -> System.out.println(key + ": " + value));
        System.out.println("-".repeat(20));
        students.forEach((key,value) -> System.out.println(key + ": " + value));

        // create a sorted navigableMap of the purchases, since they're not currently purchased
        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>(); //treeMap sorts on natural order, time complexity O(log n)
            //loop through purchases and add to the list
        for (Purchase p : purchases.values()){
            //key is the Purchase record's method purchaseDate; value is the list of purchases on that date
            datedPurchases.compute(p.purchaseDate(), (pdate, plist) ->{
                List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;  // create list named plist if first purchase
                list.add(p); //add the current purchase record to the list
                return list;
            });
        }
        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));



        //new adds
        System.out.println("-".repeat(20));
        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear,1);
        LocalDate week1 = firstDay.plusDays(7);
        //create two sorted Maps of the purchases before and after the selected date, created from jan1- week1 end
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);  //non-inclusive
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);  //includes value passed

//        week1Purchases.forEach((key,value) -> System.out.println(key + ": " + value));
//        System.out.println("-".repeat(20));
//        week2Purchases.forEach((key,value) -> System.out.println(key + ": " + value));
        //call to the new method with each of these maps instead
        displayStats(1, week1Purchases);
        displayStats(2, week2Purchases);


        System.out.println("-".repeat(20));
///Additional methods on TreeMap, very similar to TreeSet.
    ///TreeSet has: Last, first, pollLast, pollFirst; pollLastKey, pollFirstKey
    ///TreeMap has: lastKey, firstKey methods, and lastEntry and FirstEntry
    ///LASTKEY & LASTENTRY
        LocalDate lastDate = datedPurchases.lastKey();  //get the key for the last Map entry from datedPurchases.
        var previousEntry =  datedPurchases.lastEntry();   // get the lastEntry pair from the Map
            //to get the list of purchases, we need to call the getValue method on previousEntry

        while(previousEntry != null){
            List<Purchase> lastDaysData = previousEntry.getValue();       //from the lastEntry pair, get the data with getValue()
            System.out.println(lastDate + " purchases: " + lastDaysData.size());    //size indicates how many value entries, aka purchases

            ///lowerKey & LowerEntry; lower method always returned the element < the method arg, but floor returns <= method arg
            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = prevDate;
        }


///There's a key difference between the firstEntry/pollFirstEntry and higherEntry/pollFirstEntry:
    ///the pollFirstEntry and pollLastEntry remove data from the map on each subsequent call. These arent just alternate ways to get first/last entry
    ///they're also mutating the map, and the reversed map is a view. the true source is my datedPurchases map.
//entrySet, keySet, values() methods return keys and values respectively. These are views available to any map,
// and not just the TreeMap. these are still views. Manipulating the collections returned from these methods will be manipulating the source map.
        System.out.println("-".repeat(20));
        var reversed = datedPurchases.descendingMap();
        LocalDate firstDate = reversed.firstKey();
//        var nextEntry = reversed.firstEntry();
        var nextEntry = reversed.pollFirstEntry();

        while(nextEntry != null){
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases : " + lastDaysData.size());

            LocalDate nextDate = reversed.higherKey(firstDate);
//            nextEntry = reversed.higherEntry(firstDate);
            nextEntry = reversed.pollFirstEntry();
            firstDate = nextDate;
        }
        System.out.println("-".repeat(20));
        datedPurchases.forEach((key,value) -> System.out.println(key + ": " + value));

    }


///     include a method to add purchases
    private static void addPurchase(String name, Course course, double price){
        Student existingStudent = students.get(name);   // check students NavigableMap to see if they exist
        if (existingStudent == null){
            existingStudent = new Student(name, course); // create if doesn't exist.
            students.put(name,existingStudent);
        }else{
            existingStudent.addCourse(course);  //add course if the student was found
        }

        // CREATE A NEW PURCHASE INSTANCE, will first need to create variables for the missing params
        int day = new Random().nextInt(1,15);    // jan 1 - jan 4
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day );
        // put the purchase instance into the purchases map, using the key and purchase instance
        purchases.put(key, purchase);

    }

    /// NEW METHOD: HOW MANY OF EACH COURSE WERE SOLD IN EACH WEEK?
    private static void displayStats(int period, //period is 1-52 for week, 1-12 for month, etc.
                                     Map<LocalDate, List<Purchase>> periodData ){
        System.out.println("-".repeat(20));
        Map<String, Integer>  weeklyCounts = new TreeMap<>();   //String for courseID, Integer for course counts; sorted: treemap, timecomplexity O(log n)
        periodData.forEach((key,value)->{
            System.out.println(key + ": " + value);
            //code that tracks the counts for course in this period; loop through purchases
            for (Purchase p : value){
                weeklyCounts.merge(p.courseId(), 1, (prev, current) ->{ //default to 1 if not yet existing in map
                    return prev + current;
                });
            }
        });
        System.out.printf("Week %d Purchases = %s%n", period, weeklyCounts);

    }

}
