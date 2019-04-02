package pl.coderslab;

public class Flight {
    private String departure;
    private String arrival;
    private String arrivalTime;
    private double price;

    public Flight(String departure, String arrival, String arrivalTime, double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }
}
