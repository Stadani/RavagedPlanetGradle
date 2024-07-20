package environment;

import input.LoadLocationFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Map {
    private HashMap<Location, List<Location>> worldMap; //room graph
    private HashMap<String, Location> locationNameMap;

    public Map() {
        this.worldMap = new HashMap<>();
        this.locationNameMap = new HashMap<>();
    }

    /**
     * adds a bidirectional connections for locations 1 and 2
     * if the location1 doesn't exist as a key it creates it and assigns empty arraylist and adds location2 to the list
     * adds "Name" => Location association in locationNameMap
     */
    public void addConnectionAndLocationName(Location location1, Location location2) {
        this.worldMap.computeIfAbsent(location1, k -> new ArrayList<>()).add(location2);
        this.worldMap.computeIfAbsent(location2, k -> new ArrayList<>()).add(location1);
    }


    public void printAdjacentRooms(Location currentLocation) {
        if (Optional.ofNullable(this.worldMap.get(currentLocation)).isPresent()) {
            for (Location location : worldMap.keySet()) {
                System.out.println(Optional.of(location).get().getName());
            }
        }
    }

    public boolean isAdjacent(Location location1, Location location2) {
        return this.worldMap.get(location1).contains(location2);
    }

    public Location getLocationByName(String name) {
        return this.locationNameMap.get(name);
    }

    public Location getOrCreateLocation(String name, LoadLocationFromFile loadLocation) {
        return this.locationNameMap.computeIfAbsent(name, k -> {
            try {
                return loadLocation.loadLocationFromFile("locations/" + name.toLowerCase() + ".txt");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public void printWorldMap() {
        for (Location location : this.worldMap.keySet()) {
            System.out.println(Optional.of(location).get().getName());
        }
    }

    public void printAdjacentLocation(Location location) {
        List<Location> list = this.worldMap.get(location);
        for (Location i : list) {
            System.out.println(i.getName());
        }

    }
}
