package dev.lpa;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {
    //create a theatre class that has a Set of Seats
    class Seat implements Comparable<Seat>{ //implementing comparable so that the seats can be ordered
        ///the Seat class should be a nested class on the Theatre class
        ///a Seat should be constructed with a row character and an integer that represents the seat number within the row.
        /// each Seat should have a String and a seat number, in the format 'A005' where A is the row number, and 005 is the seat number
        ///within the row, and it should be a zero padded up to three digits
        /// Seats should also have a field, a boolean, indicating if the seat is reserved or not.
        private String seatNum;
        boolean reserved;

        //GENERATE A CONSTRUCTOR
        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase(); //prefixed with leading digits up to 3 digits, uppercase
        }
        //GENERATE TOSTRING
        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    ///theatre class should have three fields: TheatreName, integer for seats in each row (how many seats are in a single row),
    /// and a field for the seats themselves. the last field should be a TreeSet.
    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;   //collection for the theatre seats; using NavigableSet to be able to use floor() and ceiling() methods


    ///Theatre instance should be constructed with the theatre name, the number of rows in the theatre and the number of seats total in the theatre
    ///for simplicity, assume there are a uniform number of seats in every row, and the number of rows should never exceed 26, so the rows will be labeled A through Z
    ///you should create the seats and number them, as part of the initialization of a Theatre class.
    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;

        //set up the seats; NOTE: HashSet doesn't guarantee any sorted order, LinkedHashSet will have the seats as ordered bc they are ordered upon insertion
        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++){
            char rowChar = (char) (i / seatsPerRow + (int)'A'); // adding the i/seats to the ASCII value for A, effectively moving through the alphabet
            int seatInRow = i % seatsPerRow + 1; //adding one to start from 1 instead of 0
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    /// The theatre class should also have a printSeatMap method that prints each seat with each row printed on a separate line
    public void printSeatMap(){
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);   //#$ allows for using a parameter in multiple places, starting with 1

        int index = 0;
        for (Seat s : seats){
            System.out.printf("%-8s%s"
                    ,s.seatNum + ((s.reserved) ? "(\u25CF)" : "")   //populate symbol if reserved
                    ,((index++ +1) % seatsPerRow == 0) ? "\n" : "");    // new line once max seats are reached, otherwise loop
        }

        System.out.println(separatorLine);
    }


    ///create a second method on theatre that lets the agent specify:
        /// the number of reservations being requested
        /// a range of rows (from A to C for example, for front row seats)
        /// A range of seats ( a number greater than or equal to 1, and less than or equal to the total number of rows per seat)
        /// the seats that get reserved should be contiguous within a row.
    public String reserveSeat(char row, int seat){
        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.floor(requestedSeat); // get the element passed
        if(requested == null || !requested.seatNum.equals(requestedSeat.seatNum)){ //if returns null or if the seat that is returned has a different number than the one requested
            System.out.println("--> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first(), seats.last());
        }else{
            if (!requested.reserved){
                requested.reserved = true;
                return requested.seatNum;
            } else{
                System.out.println("Seat's already reserved.");
            }
        }
        return null;
    }

    /// BONUS METHOD
    /// Create an additional method that lets an agent reserve a number of seats, contiguous within a row
    /// params: Number of resrevations being requested // range of rows (e.g. from A to C)
    /// a range of seats ( number greater than or equal to one, less than or equal to rows per seat)
    private boolean validate(int count, char first, char last, int min, int max){
        //seats always start with 1; users shouldnt request more seats than available in a row;
        boolean result = (min > 0 || seatsPerRow >= count || (max - min +1) >= count);
        //are the seats they requested even in the vailable seats?
        result = result && seats.contains(new Seat(first, min));    //only executes if the top boolean passes
        if (!result){//if false
            System.out.printf("Invalid! %1$d seats between " + "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try Again",
                    count, first, min, max, last);
            System.out.printf(": Seat must be between %s and %s%n", seats.first(), seats.last());
        }

        return result;
    }
    public Set<Seat> reserveSeats(int seatCount, char minRow, char maxRow, int minSeat, int maxSeat){ //num seats requested, minimum row requested as char,
        char lastValid = seats.last().seatNum.charAt(0); // get the first character from the last valid seat
        maxRow = (maxRow < lastValid) ? maxRow : lastValid; //if the user enters a maxRow that's out of bounds, use the lastValid one

        if (!validate(seatCount, minRow, maxRow, minSeat,maxSeat)){
            return null;
        }
        NavigableSet<Seat> selected = null;

        for (char letter = minRow; letter <= maxRow; letter++){ //maxRow is either what user passed or last theatre row, whichever is less
            NavigableSet<Seat> contiguous = seats.subSet(new Seat(letter, minSeat), true, new Seat(letter, maxSeat), true);

            int index = 0;
            Seat first = null;
            //loop through the subset of seats (contiguous)
            for (Seat current : contiguous){
                if (current.reserved){
                    index =0;
                    continue;
                }
                first = ((index == 0 ) ? current : first);
                if (++index == seatCount){
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }
            }
            if (selected != null){
                break;
            }
        }
        Set<Seat> reservedSeats = null;
        if (selected != null){
            selected.forEach(s -> s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }

}
