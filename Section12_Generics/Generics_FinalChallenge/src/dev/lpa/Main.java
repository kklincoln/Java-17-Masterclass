package dev.lpa;

//XXX change QueryList to extend ArrayList, removing the items field
//  add a student id field to the Student class, implement a way to compare Students, so that students are naturally ordered by id
// implement at least one other mechanism for comparing Students by course or year, or for LPAStudents, by percent complete
//override the matchFieldValue method on LPAStudent class, so that you return students not matched on percent complete = to a value,
//but on percent less than or equal to a submitted value. note: an LPAStudent should be searchable by the same fields as Students
//run code for 25 random students selecting students who have completed <=50% of their course and print the list, sorted in 2 different ways
// first using List.sort with the Comparator.naturalOrder() comparator, and then using your own Comparator, so first by student id, as well
// as one of the other ways listed.
import dev.lpa.model.LPAStudent;
import dev.lpa.model.LPAStudentComparator;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    //create a new instance of the QueryList
        QueryList<LPAStudent> queryList = new QueryList<>();
        int studentCount = 25;
        //add students (25 random students)
        for (int i = 0 ; i < studentCount; i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        //CREATE A SORT ON THE LIST USING ARRAYLIST.SORT METHOD
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);
        System.out.println("_".repeat(30));

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete","50")
                .getMatches("Course", "Python")
                ;
        //first ordered by percent
        matches.sort(new LPAStudentComparator());
        printList(matches);
        System.out.println("_".repeat(30));
        //then second sort by studentID
        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);

    }

    //IMPLEMENT A PRINTLIST METHOD TO PRINT THE LIST; using unbounded wildcard
    public static void printList(List<?> students){
        for (var s : students){
            System.out.println(s);
        }
    }
}
