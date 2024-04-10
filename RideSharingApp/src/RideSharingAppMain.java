import controller.OnboardService;
import controller.RideService;
import database.RideData;
import database.UserData;
import database.UserVsVehicle;
import database.VehicleData;
import exception.DuplicateRide;
import exception.RideAlreadyAssigned;
import exception.VehicleNotFound;
import model.Ride;
import model.User;
import model.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Commands.add_user;
import static utils.Commands.end_input;
import static utils.Commands.end_ride;
import static utils.Commands.offer_ride;
import static utils.Commands.print_ride_stats;
import static utils.Commands.select_ride;

public class RideSharingAppMain {

    public static void main(String[] args) {
        UserData userData = new UserData();
        VehicleData vehicleData = new VehicleData();
        UserVsVehicle nameVsVehicleRegNo = new UserVsVehicle();
        OnboardService onboardService = new OnboardService(userData, vehicleData, nameVsVehicleRegNo);
        RideService rideService = new RideService(onboardService.getUserData(), onboardService.getVehicleData(), new RideData());
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String command = "";
            while (!end_input.name().equals(command)) {
                command = inputReader.readLine();
                try {
                    if (command.startsWith(add_user.name())) {
                        String[] queries = command.split(";");
                        String[] userCommand = queries[0].split(" ")[1].split(",");
                        User user = onboardService.addUser(userCommand[0], userCommand[1], Integer.parseInt(userCommand[2]));
                        int numberOfQueries = 0;
                        while (++numberOfQueries < queries.length) {
                            String[] vehicleCommand = queries[numberOfQueries].split(",");
                            onboardService.addVehicle(user, vehicleCommand[1], vehicleCommand[2]);
                        }
                    }
                    if (command.startsWith(offer_ride.name())) {
                        String[] rideCommand = command.split(" ")[1].split(",");
                        String name = rideCommand[0];
                        String regNo = rideCommand[4];
                        try {
                            List<String> vehicleNumbers = nameVsVehicleRegNo.getVehicleNumbers(name);
                            if (vehicleNumbers == null || !vehicleNumbers.contains(regNo)) {
                                throw new VehicleNotFound("Vehicle not associated with the user");
                            }
                            rideService.offerRide(name, rideCommand[1], Integer.parseInt(rideCommand[2]), rideCommand[3], regNo, rideCommand[5]);
                        } catch (RuntimeException runtimeException) {
                            System.out.println(runtimeException.getMessage());
                        }
                    }
                    if (command.startsWith(select_ride.name())) {
                        String[] rideCommand = command.split(" ")[1].split(",");
                        Ride ride = rideService.selectRide(rideCommand[0], rideCommand[1], rideCommand[2], Integer.parseInt(rideCommand[3]), rideCommand[4]);
                        System.out.println(ride.getVehicle().getVehicleNumber());
                    }
                    if (command.startsWith(end_ride.name())) {
                        String vehicleNumber = command.split(" ")[1];
                        rideService.endRide(vehicleNumber);
                    }
                    if (print_ride_stats.name().equals(command)) {
                        rideService.printRide();
                    }
                } catch (RuntimeException runtimeException) {
                    System.out.println(runtimeException.getMessage());
                }
            }
        } catch (IOException ioException) {
            System.out.println("Unable to read from commandline");
        }
    }
}