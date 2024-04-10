package database;

import model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleData {
    Map<String, Vehicle> vehicles;

    public VehicleData() {
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicles.getOrDefault(vehicleNumber, null);
    }
}
