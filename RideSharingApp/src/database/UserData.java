package database;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private Map<String, User> users;

    public UserData() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getFirstName(), user);
    }

    public void updateOffered(String name, int offered) {
        User user = users.get(name);
        user.setOffered(user.getOffered() + offered);
    }

    public void updateTaken(String name, int taken) {
        User user = users.get(name);
        user.setTaken(user.getTaken() + taken);
    }

    public User getUser(String name) {
        return users.get(name);
    }

    public void printRide() {
        for (String name : users.keySet()) {
            User user = users.get(name);
            System.out.println(name + ": " + user.getTaken() + " Taken, " + user.getOffered() + " Offered");
        }
    }

    @Override
    public String toString() {
        return "UserData{" +
                "users=" + users +
                '}';
    }
}
