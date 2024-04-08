package model;

public class Player {
    private final String name;
    private final Character token;

    public Player(String name, Character token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public Character getToken() {
        return token;
    }
}
