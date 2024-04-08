package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final String parkingLotId;
    private final int numberOfFloors;
    private final int numberOfSlotsPerFloor;
    private final Floor[] floor;
    Map<String, Vehicle> parkingDetails;

    public ParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
        this.floor = new Floor[numberOfFloors];
        this.parkingDetails = new HashMap<>();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public Floor[] getFloor() {
        return floor;
    }

    public Map<String, Vehicle> getParkingDetails() {
        return parkingDetails;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfSlotsPerFloor=" + numberOfSlotsPerFloor +
                ", floor=" + Arrays.toString(floor) +
                ", parkingDetails=" + parkingDetails +
                '}';
    }
}
