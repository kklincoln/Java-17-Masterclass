package dev.lpa;

//interface to implement the solution of having different team types; records can implement interfaces, but cant extend classes
interface Player{

    // create an abstract method; one without a method body is implicitly public and static
    String name();
}
// this record will only have two fields
record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}
record VolleyballPlayer(String name, String position) implements Player{}

public class Main {
    public static void main(String[] args) {
        var philly = new Affiliation("City", "Philidelphia, PA", "US");
        var newYork = new Affiliation("City", "New York, NY", "US");


        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam yankees1 = new BaseballTeam("New York Yankees");
        scoreResult(yankees1,20,phillies1,4);

        // for the new SportsTeam class that is implementing Player class
        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam yankees2 = new SportsTeam("New York Yankees");
        scoreResult(yankees2,20,phillies2,4);

        // for the new **Generic** Class: Team
        Team<BaseballPlayer, Affiliation> phillies =
                new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation>  yankees =
                new Team<>("New York Yankees", newYork);
        scoreResult(yankees, 20, phillies, 4);


        //add new players to the baseball team
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        //add players to a football team
        SportsTeam afc1 = new SportsTeam("Adelade Crows");
        // creating this type enforcement of the Football player causes the error in line 42
        Team<FootballPlayer, String> afc = //we can pass a string here because we did not create an upper bound for this second Record class
                new Team<>("Adelade Crows", "City of Adelaide, South Australia, in AU");
        var tex = new FootballPlayer("Tex Walker", "Center half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();

        //type checking testing
//        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
//        afc.addTeamMember(guthrie); // this should not be possible, and now that we created the Generic type class for Team, it's blocked
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);//type checking validated the proper player type
        afc.listTeamMembers();


        // CREATE ADDITIONAL TEAM; demonstrating that the Team class could work with any type at all, and typechecking works
        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N. Roberts","Setter"));
        adelaide.listTeamMembers();

        // CREATE A VOLLEYBALL TEAM; demonstrating that the methods will also work, given the types are the same
        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B. Black","Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);
    }

    //score the results
    public static void scoreResult(BaseballTeam team1, int t1_score,
                                    BaseballTeam team2, int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score); //set the second team's score, but ignore, because that's not our team
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    //score the results; overloaded method with the SportsTeam reference type
    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score); //set the second team's score, but ignore, because that's not our team
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    //score the results; overloaded method with the Team generic class reference type
    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score); //set the second team's score, but ignore, because that's not our team
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
