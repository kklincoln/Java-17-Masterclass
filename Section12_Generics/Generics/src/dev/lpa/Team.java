 package dev.lpa;

import java.util.ArrayList;
import java.util.List;

 // to ensure that this is a generic class, we enforce the <T> type parameter and any of the Player instances as shown in
 // SportsTeam would be replaced with this type
// It’s saying the parameterized type T, has to be a Player or a subtype of Player.
//      player in this case could have been either a class or an interface, the syntax would have been the same.
//      this declaration establishes what is called an upper bound on the types that are allowed to be used with this class.
record Affiliation(String name, String type, String countryCode){
     @Override
     public String toString() {
         return name + " (" + type + " in " + countryCode + ")";
     }
 };

public class Team<T extends Player, S> {
    // create the fields with encapsulation methods private
    private String teamName;
    private List<T> teamMembers = new ArrayList<>(); //using generic interface List and generic class ArrayList
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    //add baseball T to the team, if not already within
    public void addTeamMember(T t){
        if (!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }
    // print current roster
    public void listTeamMembers(){
        System.out.print(teamName + " Roster:");
        System.out.println((affiliation == null ? "" : " AFFILIATION: "+ affiliation));
//         System.out.println(teamMembers); // using ArrayList's built in functionality to pass this directly to println
        for (T t : teamMembers){
            System.out.println(t.name());//this will error if you dont explicitly declare an upper bound, because it is otherwise using java.lang.Object as its upper bound, which does not have a name() method
        }
    }
    //print current ranking
    public int ranking(){
        return (totalLosses * 2) + totalTies + 1; //best team has the highest ranking; team with most wins is ranked #1
    }
    //return a string whether this team lost or beat the other team
    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore > theirScore) {
            //if we beat them, increment total wins
            totalWins++;
            message = "beat";
            return message;
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
            return message;
        }else{
            totalLosses++;
        }
        return message;
    }

    //override the toString method to print the team name with its rank
    @Override
    public String toString(){
        return teamName + " (Ranked " + ranking() + ")";
    }
}
