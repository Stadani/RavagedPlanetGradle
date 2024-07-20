package org.example;

import environment.Location;
import environment.Map;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player(PlayerRole.KNIGHT, map);
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

        LoadMapFromFile loadMap = new LoadMapFromFile(map);
        LoadLocationFromFile locationLoad = new LoadLocationFromFile();
        try {
            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.printWorldMap();
        System.out.println("");
        if (map.isAdjacent(map.getLocationByName("Town"), map.getLocationByName("Dungeon"))){
            System.out.println("Adjacent");
        }

        map.printAdjacentLocation(map.getLocationByName("Town"));

    }
}