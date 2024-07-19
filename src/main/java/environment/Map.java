package environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Map {
    private HashMap<Location, List<Location>> map; //room graph

    public Map() {
        this.map = new HashMap<>();
    }

    /**
     * adds a bidirectional connections for locations 1 and 2
     * if the location1 doesn't exist as a key it creates it and assigns empty arraylist and adds location2 to the list
     */
    public void addRoom(Location location1, Location location2) {
        this.map.computeIfAbsent(location1, k -> new ArrayList<>()).add(location2);
        this.map.computeIfAbsent(location2, k -> new ArrayList<>()).add(location1);
    }

    public void printAdjacentRooms(Location currentLocation) {
        if (Optional.ofNullable(this.map.get(currentLocation)).isPresent()) {
            for (Location location : map.keySet()) {
                System.out.println(Optional.of(location).get().getName());
            }
        }
    }

    public boolean isAdjacent(Location location1, Location location2) {
        List<Location> adjacentLocations = this.map.get(location1);
        return adjacentLocations.contains(location2);
    }

}
