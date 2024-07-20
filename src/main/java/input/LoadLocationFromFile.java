package input;

import environment.Location;


import java.io.*;

public class LoadLocationFromFile {

    public Location loadLocationFromFile(String file) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            throw new IOException("File not found: " + file);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String name = br.readLine();
        String line;

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();

        String[] lines = sb.toString().split("\n");
        char[][] grid = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }

        return new Location(name, grid);
    }
}
