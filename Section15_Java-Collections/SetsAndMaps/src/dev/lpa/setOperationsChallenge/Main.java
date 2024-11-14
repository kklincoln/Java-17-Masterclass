package dev.lpa.setOperationsChallenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /// TEST DATA Set
        Set<Task> tasks = TaskData.getTask("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTask("ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        /// CREATE A UNION OF ANN, BOB, AND CAROL'S TASKS
        Set<Task> bobsTasks = TaskData.getTask("bob");
        Set<Task> carolsTasks = TaskData.getTask("carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        /// :::::::::::::::QUESTIONS TO ANSWER:::::::::::::::
        // which tasks have been assigned to the team members?
        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks",assignedTasks);

        // What is the complete task list?
        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("True All Tasks", everyTask);

        //get what's missing from the boss's list
        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);

        // which tasks haven't been assigned?
        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        // Which tasks are assigned to multiple employees?
        //union of all three tests
        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(carolsTasks,annsTasks)
        ));
        sortAndPrint("Assigned to Multiple Owners",overlap,sortByPriority);

        //get more info on the duplicates
        List<Task> overlapping = new ArrayList<>();
        // for each set within the 'sets' (combination of all assigned sets), if there's tasks overlapping another set, add to the List
        for (Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set, overlap); //get task of the team member that's also assigned to someone else
            overlapping.addAll(dupes);
        }
        //new comparator: sort by priority, then project, description
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder()
        );
        sortAndPrint("Overlapping List", overlapping, priorityNatural);


    }

    ///METHOD WITHOUT COMPARATOR
    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header,collection, null); //null uses default comparator Task::compareTo
    }

    /// METHOD TO SORT AND PRINT TASKS
    private static void sortAndPrint(String header, Collection<Task>collection, Comparator<Task> sorter){
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        //sortable set
        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    /// THREE METHODS for challenge; each returns a Set type Task>
    private static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
        //loop through the list of sets passed as arg
        for (var taskSet : sets){
            union.addAll(taskSet); // add each set from the list into the new Set
        }
        return union;
    }
    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b){
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b); //retain anything that also exists in b
        return intersect;
    }
    public static Set<Task> getDifference(Set<Task> a, Set<Task> b){
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);//remove all from a that also exist in b
        return difference;
    }

}