package org.example;

import environment.Location;
import environment.Map;

public class Player {
    private final char symbol = '+';
    private PlayerRole playerRole;
    private Location currentLocation;
    Map map;

    public Player(PlayerRole playerRole, Map map) {
        this.playerRole = playerRole;
        this.map = map;
    }

    public void movePlayer(String location) {
        Location moveTo = map.getLocationByName(location);
        if (map.isAdjacent(currentLocation, moveTo)) {
            setCurrentLocation(moveTo);
            System.out.println("Player moved to " + location);
        } else {
            System.out.println("You can't move to " + location);
        }
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public char getSymbol() {
        return symbol;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location newLocation) {
        this.currentLocation = newLocation;
    }
}

