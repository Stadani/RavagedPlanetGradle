package org.example;

import environment.Location;

public class Player {
    private final String symbol = "+";
    private PlayerRole playerRole;
    private Location currentLocation;

    public Player(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public void movePlayer(Location newLocation) {
//        if ()
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public String getSymbol() {
        return symbol;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}

