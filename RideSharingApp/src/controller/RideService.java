package controller;

import database.RideData;
import database.UserData;
import database.VehicleData;
import exception.NoRidesFound;
import exception.RideNodeFound;
import exception.VehicleNotFound;
import model.Ride;
import model.User;
import model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Commands.Most_Vacant;

public class RideService {
    private VehicleData vehicleData;
    private RideData rideData;
    private UserData userData;

    public RideService (UserData userData, VehicleData vehicleData, RideData rideData) {
        this.userData = userData;
        this.vehicleData = vehicleData;
        this.rideData = rideData;
    }

    public void offerRide(String name, String origin, int availableSeats, String vehicleName, String vehicleNumber, String destination) {
        Vehicle vehicle = vehicleData.getVehicle(vehicleNumber);
        if (vehicle == null || !vehicleName.equals(vehicle.getVehicleName())) {
            throw new VehicleNotFound("The vehicle number and name does not match");
        }
        if (!name.equals(vehicle.getUser().getFirstName())) {
            throw new VehicleNotFound("Vehicle " + vehicleName + " " + vehicleNumber + " not associated with the user " + name);
        }
        Ride ride = new Ride(name, vehicle, origin, destination, availableSeats);
        rideData.addRide(ride);
        userData.updateOffered(ride.getName(), 1);
    }

    public Ride selectRide(String name, String origin, String destination, int seats, String preference) {
        Ride rideDetails = null;
        Map<String, Ride> rideList = rideData.getRideList();
        for (String vehicleNumber : rideList.keySet()) {
            Ride ride = rideList.get(vehicleNumber);
            if (destination.equals(ride.getDestination()) && origin.equals(ride.getOrigin())) {
                if (Most_Vacant.name().equals(preference)) {
                    if (rideDetails == null) {
                        rideDetails = ride;
                    } else if (rideDetails.getAvailableSeats() < ride.getAvailableSeats()) {
                        rideDetails = ride;
                    }
                } else if (preference.equals(ride.getVehicle().getVehicleName()) && seats <= ride.getAvailableSeats()) {
                    rideDetails = ride;
                    break;
                }
            }
        }

        if (rideDetails == null) {
            throw new NoRidesFound("No rides found");
        }
        userData.updateTaken(name, 1);
        rideDetails.setAvailableSeats(rideDetails.getAvailableSeats() - seats);
        rideDetails.getUsersTaken().add(name);

        return rideDetails;
    }

    public void endRide(String vehicleNumber) {
        Ride ride = rideData.getRideList().getOrDefault(vehicleNumber, null);
        if (ride == null) {
            throw new RideNodeFound("Ride not found");
        }
        userData.updateOffered(ride.getName(), -1);
        for (String user : ride.getUsersTaken()) {
            userData.updateTaken(user, -1);
        }
    }

    public void printRide() {
        userData.printRide();
    }

    @Override
    public String toString() {
        return "RideService{" +
                "vehicleData=" + vehicleData +
                ", rideData=" + rideData +
                '}';
    }
}
