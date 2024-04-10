package model;

public class Vehicle {
    private User user;
    private String vehicleName;
    private String vehicleNumber;

    public Vehicle() {

    }

    public Vehicle(User user, String vehicleName, String vehicleNumber) {
        this.user = user;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "user=" + user +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
