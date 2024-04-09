package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightStatistics {
    private List<Ticket> tickets;

    public FlightStatistics(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void printMinimumFlightTimeByCarrier() {
        Map<String, Long> minTimes = new HashMap<>();
        for (Ticket ticket : tickets) {
            long duration = ticket.getFlightDuration();
            minTimes.put(ticket.getCarrier(), minTimes.containsKey(ticket.getCarrier()) ?
                    Math.min(minTimes.get(ticket.getCarrier()), duration) : duration);
        }

        minTimes.forEach((carrier, time) -> System.out.println("Carrier: " + carrier + ", Min Time: " + time + " minutes"));
    }

    public void printPriceDifference() {
        List<Integer> prices = new ArrayList<>();
        for (Ticket ticket : tickets) {
            prices.add(ticket.getPrice());
        }
        Collections.sort(prices);

        double average = prices.stream().mapToInt(val -> val).average().orElse(0.0);
        double median = prices.size() % 2 == 0 ?
                (prices.get(prices.size()/2) + prices.get(prices.size()/2 - 1)) / 2.0 :
                prices.get(prices.size()/2);

        System.out.println("Difference between Average and Median Prices: " + (average - median));
    }
}
