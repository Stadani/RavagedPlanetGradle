package environment;

import input.LoadLocationFromFile;

import java.io.IOException;
import java.util.*;

public class WorldMap {
    private HashMap<Location, List<Location>> worldMap; //room graph
    private HashMap<String, Location> locationNameMap;

    public WorldMap() {
        this.worldMap = new HashMap<>();
        this.locationNameMap = new HashMap<>();
    }

    /**
     * adds a bidirectional connections for locations 1 and 2.
     * If the location1 doesn't exist as a key it creates it and assigns empty arraylist and adds location2 to the list
     */
    public void addConnectionAndLocationName(Location location1, Location location2) {
        this.worldMap.computeIfAbsent(location1, k -> new ArrayList<>()).add(location2);
        this.worldMap.computeIfAbsent(location2, k -> new ArrayList<>()).add(location1);
    }

    /**
     * @param location1
     * @param location2
     * @return true if values of a key contain desired location
     */
    public boolean isAdjacent(Location location1, Location location2) {
        return this.worldMap.get(location1).contains(location2);
    }

    /**
     * @param name of location
     * @return location by a name
     */
    public Location getLocationByName(String name) {
        return this.locationNameMap.get(name);
    }

    /**
     * returns locations with associated name if it exists.
     * if it doesn't exist it computes a value using lambda expression and associates it with the key(name)
     * @param name name of the location that is used to get the grid
     * @param loadLocation instance of location loader
     */
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

    /**
     * prints all names of locations
     */
    public void printWorldMap() {
        System.out.println("World Map Locations: ");
        for (Location location : this.worldMap.keySet()) {
            System.out.print(Optional.of(location).get().getName() + ", ");
        }
    }

    /**
     * prints locations that are connected to the inputted location
     * @param location input location
     */
    public void printAdjacentLocations(Location location) {
        List<Location> list = this.worldMap.get(location);
        for (Location i : list) {
            System.out.println(i.getName());
        }
    }

    /**
     * prints "associative array" of locations
     * e.g. Town => Dungeon, Training grounds
     */
    public void printListOfLocationsConnectedToKey() {
        for (Location location : this.worldMap.keySet()) {
            List<Location> list = this.worldMap.get(location);
            System.out.print(location.getName() + " => ");
            for (Location i : list) {
                System.out.print(i.getName() + ", ");
            }
            System.out.print("\n");
        }
    }


}
