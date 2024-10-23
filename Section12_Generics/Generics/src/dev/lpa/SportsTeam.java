 package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {
    // create the fields with encapsulation methods private
    private String teamName;
    private List<Player> teamMembers = new ArrayList<>(); //using generic interface List and generic class ArrayList
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    //add baseball player to the team, if not already within
    public void addTeamMember(Player player){
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }
    // print current roster
    public void listTeamMembers(){
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers); // using ArrayList's built in functionality to pass this directly to println
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
