package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String origin;
    private String origin_name;
    private String destination_name;
    private String destination;
    private String carrier;
    private int price;
    private String departure_time;
    private String departure_date;
    private String arrival_time;
    private String arrival_date;
    private String stops;
    public Ticket(String origin, String originName, String destinationName, String destination, String carrier, int price, String departureTime, String departureDate, String arrivalTime, String arrivalDate, String stops) {

        this.origin = origin;
        this.origin_name = originName;
        this.destination_name = destinationName;
        this.destination = destination;
        this.carrier = carrier;
        this.price = price;
        this.departure_time = departureTime;
        this.departure_date = departureDate;
        this.arrival_time = arrivalTime;
        this.arrival_date = arrivalDate;
        this.stops = stops;
    }
    public Ticket(){}

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrive_time) {
        this.arrival_time = arrive_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public long getFlightDuration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        String departureString = this.departure_date + " " + this.departure_time;
        String arrivalString = this.arrival_date + " " + this.arrival_time;
        LocalDateTime departure = LocalDateTime.parse(departureString, formatter);
        LocalDateTime arrival = LocalDateTime.parse(arrivalString, formatter);
        Duration duration = Duration.between(departure, arrival);
        return duration.toMinutes();
    }
}
