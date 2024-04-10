package controller;

import database.UserData;
import database.UserVsVehicle;
import database.VehicleData;
import model.User;
import model.Vehicle;

public class OnboardService {
    UserData userData;
    VehicleData vehicleData;
    UserVsVehicle nameVsVehicleRegNo;

    public OnboardService(UserData userData, VehicleData vehicleData, UserVsVehicle nameVsVehicleRegNo) {
        this.userData = userData;
        this.vehicleData = vehicleData;
        this.nameVsVehicleRegNo = nameVsVehicleRegNo;
    }

    public User addUser(String firstName, String lastName, int age) {
        User user = new User(firstName, lastName, age);
        userData.addUser(user);
        nameVsVehicleRegNo.addName(user.getFirstName());
        return user;
    }

    public Vehicle addVehicle(User user, String name, String vehicleNumber) {
        Vehicle vehicle = new Vehicle(user, name, vehicleNumber);
        vehicleData.addVehicle(vehicle);
        nameVsVehicleRegNo.addNameVsVehicleRegNo(user.getFirstName(), vehicle.getVehicleNumber());
        return vehicle;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public VehicleData getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }

    public UserVsVehicle getNameVsVehicleRegNo() {
        return nameVsVehicleRegNo;
    }

    public void setNameVsVehicleRegNo(UserVsVehicle nameVsVehicleRegNo) {
        this.nameVsVehicleRegNo = nameVsVehicleRegNo;
    }
}
