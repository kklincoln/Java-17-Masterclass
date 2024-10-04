public class Printer {
    //create fields
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    //overloaded constructor to pass defaults
    public Printer(){
        this(50, false);
    }

    //create constructor
    public Printer(int tonerLevel, boolean duplex){
        this.pagesPrinted = 0; //default value for int is 0
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    //create methods that the calling class should be able to access (public)
    public int addToner(int tonerAmount){
        int tempAmount = tonerAmount + tonerLevel;
        if (tempAmount > 100 || tempAmount < 0){
            return -1;
        }else{
            tonerLevel += tonerAmount;
            return tonerLevel;
        }
    }

    public int printPages(int pages){
        int jobPages = (duplex) ? (pages /2) + (pages % 2) : pages; //adds additional page if there is a half sheet
        pagesPrinted += jobPages;
        return jobPages;
    }

    //create setters/getters if necessary
    public int getPagesPrinted(){
        return pagesPrinted;    }

}
