package model;

public class Grid {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final int numberOfPlayers;
    private final char[][] grid;
    private final Player[] players;
    private int currentPlayer;

    public Grid(int numberOfRows, int numberOfColumns, Player[] players) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.grid = new char[numberOfRows][numberOfColumns];
        this.players = players;
        this.numberOfPlayers = players.length;
        this.currentPlayer = 0;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }


    public int getNumberOfColumns() {
        return numberOfColumns;
    }


    public char[][] getGrid() {
        return grid;
    }


    public Player[] getPlayers() {
        return players;
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
