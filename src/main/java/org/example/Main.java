package org.example;

import environment.Location;
import environment.Map;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(PlayerRole.KNIGHT);
        Map map = new Map();


        Location town = new Location("Town");
        Location dungeon = new Location("Dungeon");
        Location nest = new Location("Nest");
        Location trainingGrounds = new Location("Training Grounds");
        player.setCurrentLocation(town);


        map.addRoom(town, dungeon);
        map.addRoom(town, trainingGrounds);
        map.addRoom(dungeon, nest);
        map.printAdjacentRooms(town);
        if (map.isAdjacent(player.getCurrentLocation(), dungeon)) {
            System.out.println(player.getCurrentLocation().getName() + " is adjacent to " + dungeon.getName());
        } else {
            System.out.println(player.getCurrentLocation().getName() + " is not adjacent to " + dungeon.getName());
        }

//        town.placeObjectInLocation(0, 0 , player.getSymbol());
//        town.printLocation();


    }
}