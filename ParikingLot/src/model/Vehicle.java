package model;

public class Vehicle {
    private final String type;
    private final String colour;
    private final String registrationNumber;

    public Vehicle(String type, String colour, String registrationNumber) {
        this.type = type;
        this.colour = colour;
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
