package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TicketsWrapper ticketsWrapper = mapper.readValue(new File("src/main/java/org/example/tickets.json"), TicketsWrapper.class);
            List<Ticket> tickets = ticketsWrapper.getTickets();

            tickets = tickets.stream()
                    .filter(ticket -> "VVO".equals(ticket.getOrigin()) && "TLV".equals(ticket.getDestination()))
                    .collect(Collectors.toList());

            FlightStatistics stats = new FlightStatistics(tickets);
            stats.printMinimumFlightTimeByCarrier();
            stats.printPriceDifference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


