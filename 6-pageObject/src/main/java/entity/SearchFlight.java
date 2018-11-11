package entity;

public class SearchFlight {
    public String from;
    public String to;
    public String departureDate;
    public String returnDate;
    public int adults;
    public int children;
    public int infants;

    public SearchFlight(String from, String to, String departureDate, String returnDate, int adults, int children, int infants) {
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }
}
