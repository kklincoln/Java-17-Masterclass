package dev.lpa;

//allow a booking agent to reserve a single seat, and the printedSeatMap method should hsow which seats are reserved.

public class BookingAgent {
    public static void main(String[] args) {

        /// TEST DATA
        int rows = 10;
        int totalSeats = 100;
        Theatre rodgersNYC = new Theatre("Richard Rodgers", rows, totalSeats);
        rodgersNYC.printSeatMap();

        bookSeat(rodgersNYC, 'g',1);
        bookSeat(rodgersNYC, 'g',1);

        bookSeat(rodgersNYC, 'B',5);
        bookSeat(rodgersNYC, 'B',11);
        bookSeat(rodgersNYC, 'M',1);



        ///testing the contiguous seats reservation methods
        bookSeats(rodgersNYC, 4, 'B',3,10);
        bookSeats(rodgersNYC, 6, 'B','C',3,10);
        bookSeats(rodgersNYC, 4, 'B', 4,10);
        bookSeats(rodgersNYC,4,'B','C',1,10);   //
        bookSeats(rodgersNYC,1,'B','C',1,10);   // individual seat
        bookSeats(rodgersNYC,1,'M','Z',1,10);   //bad data

    }

    private static void bookSeat(Theatre theatre, char row, int seatNo){
        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null){
            System.out.println("Congratulations, your reserved seat is " + seat);
            theatre.printSeatMap();
        }else{
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }

    //overload the bookSeats method
    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat){
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat){
    var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat,maxSeat);

    if (seats != null){
        System.out.println("Congratulations! Your seats are " + seats);
        theatre.printSeatMap();
    }else{
        System.out.println("Sorry! No matching contiguous seats in rows:" + minRow + " - " + maxRow);
    }
    }

}
