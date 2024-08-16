/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TainJourney;

/**
 *
 * @author ebepa
 */
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TrainJourney {
    public static void main(String[] args) {
        int totalDistance = 10000; // total distance in km
        int passengerStopDistance = 150; // distance for passenger stop
        int refuelStopDistance = 200; // distance for refuel stop
        int speedKmPerHour = 250; // speed in km/h
        int minutesPerStop = 5; // time spent per stop in minutes

        // (i) Compute the number of stops during the journey
        int passengerStops = totalDistance / passengerStopDistance;
        int refuelStops = totalDistance / refuelStopDistance;

        // Calculate the least common multiple (LCM) to avoid double counting stops
        int lcm = lcm(passengerStopDistance, refuelStopDistance);
        int commonStops = totalDistance / lcm;

        int totalStops = (passengerStops + refuelStops) - commonStops;

        System.out.println("Total number of stops: " + totalStops);

        // (ii) Compute the total travel time from Kampala to Kabale
        double totalStopTimeInHours = (totalStops * minutesPerStop) / 60.0;
        double travelTimeWithoutStops = (double) totalDistance / speedKmPerHour;
        double totalTravelTime = travelTimeWithoutStops + totalStopTimeInHours;

        System.out.println("Total travel time in hours: " + totalTravelTime);

        // (iii) Compute the total time for the return journey
        int returnStops = totalDistance / refuelStopDistance;
        double returnStopTimeInHours = (returnStops * minutesPerStop) / 60.0;
        double returnTravelTimeWithoutStops = (double) totalDistance / speedKmPerHour;
        double returnTotalTravelTime = returnTravelTimeWithoutStops + returnStopTimeInHours;

        System.out.println("Total return journey time in hours: " + returnTotalTravelTime);

        // (iv) Compute the arrival time for the second coach
        double speedMetersPerSecond = 225.5; // speed in m/s
        double speedKmPerHour2 = speedMetersPerSecond * 3.6;
        double travelTimeInHours2 = totalDistance / speedKmPerHour2;

        // Starting time for the second coach is 09:00
        LocalTime startTime = LocalTime.of(9, 0);

        // Calculate the arrival time
        LocalTime arrivalTime = startTime.plusMinutes((long) (travelTimeInHours2 * 60));

        // Format and print the arrival time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Approximate arrival time for the second coach: " + arrivalTime.format(formatter));
    }

    // Helper function to calculate greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper function to calculate least common multiple (LCM)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
