package player;

import environment.Location;
import environment.WorldMap;
import npc.HostileNpcRace;

public class Player {
    private final char symbol = '+';
    private PlayerRole playerRole;
    private Location currentLocation;
    private int[] position;
    WorldMap worldMap;

    public Player(PlayerRole playerRole, WorldMap worldMap) {
        this.playerRole = playerRole;
        this.worldMap = worldMap;
    }

    /**
     * changes current location of a player if the goal location is adjacent to the current one.
     * @param location goal location
     */
    public void movePlayerOnWorldMap(String location) {
        Location moveTo = worldMap.getLocationByName(location);
        if (worldMap.isAdjacent(currentLocation, moveTo)) {
            setCurrentLocation(moveTo);
            moveTo.placeObjectInLocation(0, 0, this.symbol);
            System.out.println("Player moved to " + location);
        } else {
            System.out.println("You can't move to " + location);
        }
    }

    public int[] getPosition() {
        return this.position;
    }

    //    public boolean isInMeleeRange(HostileNpcRace enemy) {
//
//    }

    public PlayerRole getPlayerRole() {
        return this.playerRole;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location newLocation) {
        this.currentLocation = newLocation;
    }

}

