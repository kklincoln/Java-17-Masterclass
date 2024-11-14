package dev.lpa.setOperationsChallenge;

///
enum Priority { HIGH, MEDIUM, LOW }
enum Status { IN_QUEUE, ASSIGNED, IN_PROGRESS }

/// Should implement Comparable, so that tasks are sorted by project name and description
public class Task implements Comparable<Task>  {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    /// GENERATE CONSTRUCTOR
    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public Task(String project, String description, String assignee, Priority priority) {
        //CHAIN A CALL TO THE FIVE-ARG CONSTRUCTOR
        this(project, description, assignee, priority,
                assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        //CHAIN A CALL TO THE CONSTRUCTOR ABOVE
        this(project, description, null, priority);    // sets status to in_queue because the assignee is null
    }

    /// GENERATE GETTERS/ SETTERS
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    /// GENERATE A TOSTRING()
    @Override
    public String toString() {
        return ("%-20s , %-25s, %-10s, %-10s, %s").formatted(
                project, description, priority, assignee, status);
    }

    // we want the project to be unique by project and description, so we need the equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProject().equals(task.getProject()) && getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }


    /// ADJUST THE GENERATED COMPARABLE METHOD
    @Override
    public int compareTo(Task o) {
        // Use projects for comparator, if equal, use description
        int result = this.project.compareTo(o.project);
        if (result == 0){
            result = this.description.compareTo(o.description);
        }
        return result;
    }


    /// SET UP AND RETURN SOME TEST DATA
    //tasks identified by the manager
    // tasks identified by Ann, that shes working on or plans to work on
    // tasks which bob says have been assigned to him
    // tasks Carol is doing as reported by herself

//    This class should have a getTask method that returns a set of Task.
//    this method should take a string, either the name of one of the employees, or 'all' to get the full task Set


}
