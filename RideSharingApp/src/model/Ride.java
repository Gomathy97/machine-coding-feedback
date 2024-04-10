package model;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    private String name;
    private Vehicle vehicle;
    private String origin;
    private String destination;
    private int availableSeats;
    private List<String> usersTaken;

    public Ride(String name, Vehicle vehicle, String origin, String destination, int availableSeats) {
        this.name = name;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.usersTaken = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<String> getUsersTaken() {
        return usersTaken;
    }

    public void setUsersTaken(List<String> usersTaken) {
        this.usersTaken = usersTaken;
    }
}
