package org.example;

import environment.Location;
import environment.WorldMap;

public class Player {
    private final char symbol = '+';
    private PlayerRole playerRole;
    private Location currentLocation;
    WorldMap worldMap;

    public Player(PlayerRole playerRole, WorldMap worldMap) {
        this.playerRole = playerRole;
        this.worldMap = worldMap;
    }

    /**
     * changes current location of a player if the goal location is adjacent to the current one.
     * @param location goal location
     */
    public void movePlayer(String location) {
        Location moveTo = worldMap.getLocationByName(location);
        if (worldMap.isAdjacent(currentLocation, moveTo)) {
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

