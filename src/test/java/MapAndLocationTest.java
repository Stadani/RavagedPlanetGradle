import environment.Location;
import environment.WorldMap;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerRole;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapAndLocationTest {
    Player player;
    WorldMap worldMap;
    Location location;

    public MapAndLocationTest() {
        this.worldMap = new WorldMap();
        LoadMapFromFile loadMap = new LoadMapFromFile(worldMap);
        LoadLocationFromFile locationLoad = new LoadLocationFromFile();

        try {
            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.player = new Player(PlayerRole.KNIGHT, worldMap);
    }

    @Test
    public void printDungeon() {

    }

    @Test
    public void playerPositionTest() {
        this.player.setCurrentLocation(this.worldMap.getLocationByName("Town"));
        this.player.movePlayerOnWorldMap("Dungeon");
        System.out.println("im here");
        var actual = this.worldMap.getLocationByName("Dungeon").getPlayerPosition();

        assertArrayEquals(new int[]{0, 0}, actual);

    }

    @Test
    public void npcPlacingTest() {
        this.player.setCurrentLocation(this.worldMap.getLocationByName("Town"));
        this.player.movePlayerOnWorldMap("Dungeon");
        var actual = this.worldMap.getLocationByName("Dungeon").isPositionFree(this.player.getCurrentLocation().getPlayerPosition()[0], this.player.getCurrentLocation().getPlayerPosition()[1]);
        this.worldMap.getLocationByName("Dungeon").printLocation();
        assertEquals(false, actual);
    }
}
