package org.example;

import environment.Location;
import environment.WorldMap;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap();
        Player player = new Player(PlayerRole.KNIGHT, worldMap);
        Location location;


//        Location town = new Location("Town");
//        Location dungeon = new Location("Dungeon");
//        Location nest = new Location("Nest");
//        Location trainingGrounds = new Location("Training Grounds");
//        player.setCurrentLocation(town);
//
//
//        map.addConnectionAndLocationName(town, dungeon);
//        map.addConnectionAndLocationName(town, trainingGrounds);
//        map.addConnectionAndLocationName(dungeon, nest);
//        map.printAdjacentRooms(town);
//        if (map.isAdjacent(player.getCurrentLocation(), dungeon)) {
//            System.out.println(player.getCurrentLocation().getName() + " is adjacent to " + dungeon.getName());
//        } else {
//            System.out.println(player.getCurrentLocation().getName() + " is not adjacent to " + dungeon.getName());
//        }


//        town.placeObjectInLocation(0, 0 , player.getSymbol());
//        town.printLocation();

//        LoadLocationFromFile lok1 = new LoadLocationFromFile();
//        try {
//            Location dungeon =  lok1.loadLocationFromFile("locations/dungeon.txt");
//            dungeon.printLocation();
//            System.out.println(dungeon.getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        LoadMapFromFile loadMap = new LoadMapFromFile(worldMap);
        LoadLocationFromFile locationLoad = new LoadLocationFromFile();
        try {
            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }

        worldMap.printWorldMap();
        System.out.println("");
        if (worldMap.isAdjacent(worldMap.getLocationByName("Town"), worldMap.getLocationByName("Dungeon"))){
            System.out.println("Adjacent");
        }

        worldMap.printAdjacentLocations(worldMap.getLocationByName("Town"));
        Location town = worldMap.getLocationByName("Town");
        town.printLocation();
    }
}