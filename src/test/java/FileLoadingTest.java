import environment.Location;
import environment.WorldMap;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileLoadingTest {
    private WorldMap worldMap;


    public FileLoadingTest() {
        this.worldMap = new WorldMap();
        LoadMapFromFile loadMap = new LoadMapFromFile(worldMap);
        LoadLocationFromFile locationLoad = new LoadLocationFromFile();

        try {
            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printWorldMap() {
        System.out.println("Printing World Map:");
        worldMap.printWorldMap();
    }

    @Test
    public void printConnectionsBetweenLocations() {
        System.out.println("Printing Connections Between Locations:");
        this.worldMap.printListOfLocationsConnectedToKey();
    }

    @Test
    public void printAdjacentLocations() {
        System.out.println("Printing Adjacent Locations to Town:");
        Location location = this.worldMap.getLocationByName("Town");
        this.worldMap.printAdjacentLocations(location);
    }

}
