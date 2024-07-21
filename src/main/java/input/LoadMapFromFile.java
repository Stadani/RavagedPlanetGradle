package input;

import environment.Location;
import environment.WorldMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadMapFromFile {
    private WorldMap worldMap;

    public LoadMapFromFile(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    /**
     * Loads resource file based on the name.
     * Reads the line, splits it into Strings and creates location and connections between them
     * @param fileName name of the file
     * @param loadLocation
     * @throws IOException
     */
    public void loadConnectionsFromFile(String fileName, LoadLocationFromFile loadLocation) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("File not found: " + fileName);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
            String[] locations = line.split(", ");
            if (locations.length == 2) {
                Location loc1 = this.worldMap.getOrCreateLocation(locations[0], loadLocation);
                Location loc2 = this.worldMap.getOrCreateLocation(locations[1], loadLocation);
                worldMap.addConnectionAndLocationName(loc1, loc2);
            }
        }
        br.close();
    }
}
