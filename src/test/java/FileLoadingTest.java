import environment.Map;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileLoadingTest {
    @Test
    public void test() {
        Map map = new Map();
        LoadMapFromFile loadMap = new LoadMapFromFile(map);
        LoadLocationFromFile locationLoad = new LoadLocationFromFile();

        try {
            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        map.printWorldMap();
        map.printAdjacentLocation(map.getLocationByName("Town"));
    }
}
