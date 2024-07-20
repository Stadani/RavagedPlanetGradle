package input;

import environment.Location;
import environment.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadMapFromFile {
    private Map map;

    public LoadMapFromFile(Map map) {
        this.map = map;
    }

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
                Location loc1 = this.map.getOrCreateLocation(locations[0], loadLocation);
                Location loc2 = this.map.getOrCreateLocation(locations[1], loadLocation);
                map.addConnectionAndLocationName(loc1, loc2);
            }
        }
        br.close();
    }
}
