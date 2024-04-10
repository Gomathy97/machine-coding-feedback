package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserVsVehicle {
    Map<String, List<String>> nameVsVehicleRegNo;

    public UserVsVehicle() {
        nameVsVehicleRegNo = new HashMap<>();
    }

    public void addName(String name) {
        if (!nameVsVehicleRegNo.containsKey(name)) {
            nameVsVehicleRegNo.put(name, new ArrayList<>());
        }
    }

    public void addNameVsVehicleRegNo(String name, String regNo) {
        if (!nameVsVehicleRegNo.containsKey(name)) {
            nameVsVehicleRegNo.put(name, new ArrayList<>());
        }
        nameVsVehicleRegNo.get(name).add(regNo);
    }

    public List<String> getVehicleNumbers(String name) {
        return nameVsVehicleRegNo.getOrDefault(name, null);
    }

    @Override
    public String toString() {
        return "UserVsVehicle{" +
                "nameVsVehicleRegNo=" + nameVsVehicleRegNo +
                '}';
    }
}
